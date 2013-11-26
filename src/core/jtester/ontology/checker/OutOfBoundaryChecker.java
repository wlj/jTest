package core.jtester.ontology.checker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.dom.ArrayCreation;
import org.eclipse.jdt.core.dom.Expression;

import core.common.model.jobflow.JobConst;
import core.common.model.semantics.DeclarationSemantics;
import core.common.model.semantics.InferenceSemantics;
import core.common.model.semantics.SemanticsStore;
import core.common.model.test.TestData;
import core.common.model.test.TestFile;
import core.jtester.ontology.reasoner.IChecker;

public class OutOfBoundaryChecker implements IChecker{

	@Override
	public void check(TestData data) {
		TestFile file = data.getCurrentTestFile();
		
		SemanticsStore store = (SemanticsStore) file.get(JobConst.SEMANTICS);
		List<InferenceSemantics> exceptions = handleSemantics(store);
		
		if(generateReport(exceptions)){
			data.getTestResult().addViolation(JobConst.ONTOLOGY_OUT_OF_BOUNDARY);
		}
	}

	private List<InferenceSemantics> handleSemantics(SemanticsStore store) {
		List<InferenceSemantics> toCheck = new ArrayList<InferenceSemantics>();
		List<InferenceSemantics> violations = new ArrayList<InferenceSemantics>();
		
		Iterator<InferenceSemantics> ir = store.iterator2();
		while(ir.hasNext()){
			InferenceSemantics semantics = ir.next();
			if(semantics.getIndex() > 0){
				toCheck.add(semantics);
			}
			
			if(semantics.getIndex() < 0){
				violations.add(semantics);
			}
		}
		
		for(InferenceSemantics semantics: toCheck){
			Iterator<DeclarationSemantics> ir2 = store.iterator1();
			while(ir2.hasNext()){
				DeclarationSemantics ds = ir2.next();
				if(ds.getName().toString().equals(semantics.getName().toString())){
					Expression exp = ds.getValue();
					if(exp instanceof ArrayCreation){
						ArrayCreation array = (ArrayCreation) exp;
						// only deal with one-dimension array
						int index = Integer.parseInt(array.dimensions().get(0).toString());
						if(semantics.getLine() >= index){
							violations.add(semantics);
						}
					}
				}
			}
		}
		return violations;
	}
	
	private boolean generateReport(List<InferenceSemantics> exceptions) {
		if(exceptions == null || exceptions.isEmpty()){
			return false;
		}
		
		boolean report = false;
		System.err.println("Warning: �����������");
		for(InferenceSemantics is : exceptions){
			System.err.println("\t" + is.toStringWithContext());
			if(report == false){
				report = true;
			}
		}
		return report;
	}
}
