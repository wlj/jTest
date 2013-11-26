package core.jtester.ontology.checker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.SimpleName;

import core.common.model.jobflow.JobConst;
import core.common.model.semantics.DeclarationSemantics;
import core.common.model.semantics.InferenceSemantics;
import core.common.model.semantics.SemanticsStore;
import core.common.model.semantics.ViolationAxiom;
import core.common.model.test.TestData;
import core.common.model.test.TestFile;
import core.common.util.ASTUtil;
import core.common.util.Abacus;
import core.jtester.ontology.reasoner.IChecker;

public class DividedByZeroChecker implements IChecker{
	private CompilationUnit root;
	
	public void check(TestData data) {
		TestFile file = data.getCurrentTestFile();
		root = (CompilationUnit) file.get(JobConst.AST);
		
		SemanticsStore store = (SemanticsStore) file.get(JobConst.SEMANTICS);
		List<InferenceSemantics> exceptions = handleSemantics(store);

		generateReport(exceptions);
		produceAbox(data, exceptions);
	}

	private List<InferenceSemantics> handleSemantics(SemanticsStore store){
		List<InferenceSemantics> toCheck = new ArrayList<InferenceSemantics>();
		List<InferenceSemantics> violations = new ArrayList<InferenceSemantics>();
		
		Iterator<InferenceSemantics> ir = store.iterator2();
		while(ir.hasNext()){
			InferenceSemantics is = ir.next();
			ASTNode context = is.getContext();
			if(!(context instanceof InfixExpression)){
				// not binary expression
				continue;
			}
			
			InfixExpression ie = (InfixExpression)context;
			if(!ie.getOperator().equals(InfixExpression.Operator.DIVIDE)){
				// not division expression
				continue;
			}
			
			if(!ie.getRightOperand().toString().equals(is.getName().toString())){
				// not divisor
				continue;
			}
			
			toCheck.add(is);
		}
		
		for(InferenceSemantics is: toCheck){
			List<DeclarationSemantics> declarations = is.getDeclaraions();
			for(DeclarationSemantics ds: declarations){
				if(isExpressionZero(ds.getName().toString(), ds.getValue(), store)){
					violations.add(is);
					break;
				}
			}
		}
		
		return violations;
	}
	
	private boolean containsVariable(Expression exp){
		boolean result = false;
		switch(exp.getNodeType()){
		case ASTNode.SIMPLE_NAME:
			result = true;
			break;
		case ASTNode.INFIX_EXPRESSION:
			InfixExpression ie = (InfixExpression)exp;
			Expression left = ie.getLeftOperand();
			Expression right = ie.getRightOperand();
			result = containsVariable(left) | containsVariable(right);
			
			List extendedOprands = ie.extendedOperands();
			for(Object var : extendedOprands){
				result |= containsVariable((Expression) var);
			}
			break;
		}
		return result;
	}
	
	private void findVariable(Expression exp, Set<String> names){
		switch(exp.getNodeType()){
		case ASTNode.SIMPLE_NAME:
			names.add(exp.toString());
			break;
		case ASTNode.INFIX_EXPRESSION:
			InfixExpression ie = (InfixExpression)exp;
			Expression left = ie.getLeftOperand();
			Expression right = ie.getRightOperand();
			findVariable(left, names);
			findVariable(right, names);
			
			List<Object> extendedOprands = ie.extendedOperands();
			for(Object var : extendedOprands){
				if(var instanceof SimpleName){
					names.add(var.toString());
				}
			}
			break;
		}
	}
	
	private Set<InferenceSemantics> getInferenceSemantics(int line, Set<String> names, SemanticsStore store){
		Set<InferenceSemantics> ss = new HashSet<InferenceSemantics>();
		for(String name: names){
			Iterator<InferenceSemantics> ir = store.iterator2();
			while(ir.hasNext()){
				InferenceSemantics is = ir.next();
				if(is.getLine() == line && is.getName().toString().equals(name)){
					ss.add(is);
					break;
				}
			}
		}
		return ss;
	}
	
	private List<DeclarationSemantics> getDeclarations(Expression exp, SemanticsStore store){
		List<DeclarationSemantics> semantics = new ArrayList<DeclarationSemantics>();
		
		Set<String> names = new HashSet<String>();
		findVariable(exp, names);
	
		int line = ASTUtil.getLineNumber(root, exp);
		Set<InferenceSemantics> ss = getInferenceSemantics(line, names, store);
		for(InferenceSemantics is: ss){
			List<DeclarationSemantics> dss = is.getDeclaraions();
			semantics.addAll(dss);
		}
		
		return semantics;
	}
	
	private void isExpressionZeroHelper(String name, Expression exp, SemanticsStore store, Map<String, Long> fields){
		List<DeclarationSemantics> dss = getDeclarations(exp, store);
		for(DeclarationSemantics ds: dss){
			Expression value = ds.getValue();
			switch(value.getNodeType()){
			case ASTNode.NUMBER_LITERAL:
				fields.put(ds.getName().toString(), Long.parseLong(value.toString()));
				break;
			case ASTNode.INFIX_EXPRESSION:
				if(containsVariable(exp)){
					isExpressionZeroHelper(ds.getName().toString(), value, store, fields);
				}
				fields.put(ds.getName().toString(), Abacus.compute(exp, fields));
				break;
			case ASTNode.SIMPLE_NAME:
				isExpressionZeroHelper(ds.getName().toString(), value, store, fields);
				break;
			}
		}
		
		long expValue = Abacus.compute(exp, fields);
		fields.put(name, expValue);
	}
	
	private boolean isExpressionZero(String name, Expression exp, SemanticsStore store){
		if(exp == null){
			return false;
		}
		
		Map<String, Long> fields = new HashMap<String, Long>();
		
		isExpressionZeroHelper(name, exp,store,fields);
		return Abacus.compute(exp, fields) == 0;
	}
	
	private boolean generateReport(List<InferenceSemantics> exceptions){
		boolean report = false;
		if(exceptions != null && !exceptions.isEmpty()){
			System.err.println("Error: ����Ϊ0!");
			for(InferenceSemantics ds: exceptions){
				System.err.println("\t" + ds.toStringWithContext());
				if(report == false){
					report = true;
				}
			}
		}
		
		return report;
	}

	private void produceAbox(TestData data, List<InferenceSemantics> exceptions) {
		if(exceptions != null && !exceptions.isEmpty()){
			for(InferenceSemantics ds: exceptions){
				ViolationAxiom axiom = new ViolationAxiom(JobConst.ONTOLOGY_DIVIDED_BY_ZERO);
				axiom.setName(ds.getName().toString());
				axiom.setContext(ds.toStringWithContext());
				axiom.addDataProperty(JobConst.ONTOLOGY_DATA_PROPERTY_VALUE, Integer.toString(0));
				axiom.addDataProperty(JobConst.ONTOLOGY_DATA_PROPERTY_DIVISOR, Boolean.toString(true));
				data.getTestResult().addViolation(axiom);
			}
		}
	}
}
