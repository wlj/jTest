package core.jtester.staticanalysis.svd.execution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.SimpleName;

import com.clarkparsia.sparqlowl.parser.antlr.SparqlOwlParser.booleanLiteral_return;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.cp.solver.search.real.CyclicRealVarSelector;
import choco.cp.solver.search.real.RealIncreasingDomain;
import choco.cp.solver.search.set.MinDomSet;
import choco.cp.solver.search.set.MinEnv;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerExpressionVariable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.model.variables.real.RealExpressionVariable;
import choco.kernel.model.variables.real.RealVariable;
import choco.kernel.model.variables.set.SetVariable;
import choco.kernel.solver.Configuration;

public class ConstraintSolver {
	// int��float��double�������ݵ�ֵ��
	public static final int intupperlimit = Integer.MAX_VALUE;
	public static final int intlowerlimit = Integer.MIN_VALUE;

	public static final float floatupperlimit = Float.MAX_VALUE;
	public static final float floatlowerlimit = Float.MIN_VALUE;

	public static final double doubleupperlimit = Double.MAX_VALUE;
	public static final double doublelowerlimit = Double.MIN_VALUE;
	public static HashSet<InfixExpression.Operator> feasible_operators = new HashSet<>();
	static {
		feasible_operators.add(InfixExpression.Operator.LESS);
		feasible_operators.add(InfixExpression.Operator.LESS_EQUALS);
		feasible_operators.add(InfixExpression.Operator.GREATER);
		feasible_operators.add(InfixExpression.Operator.GREATER_EQUALS);
		feasible_operators.add(InfixExpression.Operator.EQUALS);
		feasible_operators.add(InfixExpression.Operator.NOT_EQUALS);
	}
	public HashMap<String, IntegerVariable> envVariableValueHashMap = new HashMap<String, IntegerVariable>();
	public CPSolver solver = new CPSolver();
	public CPModel model = new CPModel();
	public ProgramEnv env;
	
	public ConstraintSolver(){
		env = new ProgramEnv();
	}
	public ConstraintSolver(Path path){
		this.env = path.getEnv();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*ExpressionNode root = null;
		root = prepare();
		CPExecutor cpExecutor = new CPExecutor();
		// �������rootΪ���������ڱ�����ͬʱ����envVariableValueHashMap����
		cpExecutor.updateVariable(root);
		// ����ExpressionNodeΪ���ı��ʽ������Լ����ģ��Constraint Modeling��,������Լ��
		println("");
		println(cpExecutor.expressionModeling(root));
		Constraint constraint = Choco.lt(5, cpExecutor.expressionModeling(root));
		// �������
		CPModel model = new CPModel();
		model.addConstraint(constraint);
		CPSolver solver = new CPSolver();
		solver.read(model);
		boolean solverable = solver.solve();
		println(solverable);
		*/
//		simpleDemo2();
	}
	
	/**
	 * TODO
	 * @param e
	 * @return
	 */
	public static boolean solve(InfixExpression e) {
		// ����Expression��ߵı��ʽ��������Ӧ��ExpressionNode
		
		// ����Expression��ߵı��ʽ��������Ӧ��ExpressionNode

		// �õ�Expression���߼��жϷ��ţ������������߽������

		// ���ؿɷ����

		return false;
	}
	
	/**
	 * �˷��������������жϱ��ʽ����Լ����⣬���������н����˵��޷�������������ʽ
	 * @param constraints
	 * @return
	 */
	public boolean solve(ExpressionNode leftnNode, ExpressionNode rightNode, InfixExpression.Operator operator){
		boolean solveable = true;
		
		CPSolver solver = new CPSolver();
		solver.read(model);
//		solveable = solver.solve();
		return solveable;
	}
	
	public Constraint generateConstraint(ExpressionNode leftNode, ExpressionNode rightNode, InfixExpression.Operator operator){
		IntegerExpressionVariable leftVariable = null, rightVariable = null;
		if (leftNode.getType()!=ExpressionType.single_int ) {
			leftVariable = constraintVariableModeling(leftNode);
		}
		if (rightNode.getType() !=ExpressionType.single_int) {
			rightVariable = constraintVariableModeling(rightNode);
		}
		Constraint constraint = null;
		if (leftVariable!=null && rightVariable!=null) {
			if (operator.equals(InfixExpression.Operator.LESS)) {
				constraint =  Choco.lt(leftVariable, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.LESS_EQUALS)) {
				constraint =  Choco.leq(leftVariable, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.GREATER)) {
				constraint =  Choco.gt(leftVariable, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.GREATER_EQUALS)) {
				constraint =  Choco.geq(leftVariable, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.EQUALS)) {
				constraint =  Choco.eq(leftVariable, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.NOT_EQUALS)){
				constraint =  Choco.neq(leftVariable, rightVariable);
			}else{
				System.out.println("Constraint solver can't do with the operator: "+operator);
			}
		}else if (leftVariable!=null && rightVariable==null) {
			int rightValue = Integer.parseInt(rightNode.getValue());
			if (operator.equals(InfixExpression.Operator.LESS)) {
				constraint =  Choco.lt(leftVariable, rightValue);
			}else if (operator.equals(InfixExpression.Operator.LESS_EQUALS)) {
				constraint =  Choco.leq(leftVariable, rightValue);
			}else if (operator.equals(InfixExpression.Operator.GREATER)) {
				constraint =  Choco.gt(leftVariable, rightValue);
			}else if (operator.equals(InfixExpression.Operator.GREATER_EQUALS)) {
				constraint =  Choco.geq(leftVariable, rightValue);
			}else if (operator.equals(InfixExpression.Operator.EQUALS)) {
				constraint =  Choco.eq(leftVariable, rightValue);
			}else if (operator.equals(InfixExpression.Operator.NOT_EQUALS)){
				constraint =  Choco.neq(leftVariable, rightValue);
			}else{
				System.out.println("Constraint solver can't do with the operator: "+operator);
			}
		}else if (leftVariable==null && rightVariable!=null) {
			int leftValue = Integer.parseInt(leftNode.getValue());
			if (operator.equals(InfixExpression.Operator.LESS)) {
				constraint =  Choco.lt(leftValue, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.LESS_EQUALS)) {
				constraint =  Choco.leq(leftValue, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.GREATER)) {
				constraint =  Choco.gt(leftValue, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.GREATER_EQUALS)) {
				constraint =  Choco.geq(leftValue, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.EQUALS)) {
				constraint =  Choco.eq(leftValue, rightVariable);
			}else if (operator.equals(InfixExpression.Operator.NOT_EQUALS)){
				constraint =  Choco.neq(leftValue, rightVariable);
			}else{
				System.out.println("Constraint solver can't do with the operator: "+operator);
			}
		}else if (leftVariable==null && rightVariable==null) {
			int leftValue = Integer.parseInt(leftNode.getValue()),
					rightValue = Integer.parseInt(rightNode.getValue());
			boolean logicResult;
			Constraint falseConstraint = Choco.lt(Choco.makeIntVar("bigger", 5,6), Choco.makeIntVar("smaller", 1,2)),
					trueConstraint = Choco.gt(Choco.makeIntVar("bigger", 5,6), Choco.makeIntVar("smaller", 1,2));
			
			if (operator.equals(InfixExpression.Operator.LESS)) {
				if (leftValue<rightValue) {
					constraint = trueConstraint;
				}else {
					constraint = falseConstraint;
				}
			}else if (operator.equals(InfixExpression.Operator.LESS_EQUALS)) {
				if (leftValue<=rightValue) {
					constraint = trueConstraint;
				}else {
					constraint = falseConstraint;
				}
			}else if (operator.equals(InfixExpression.Operator.GREATER)) {
				if (leftValue>rightValue) {
					constraint = trueConstraint;
				}else {
					constraint = falseConstraint;
				}
			}else if (operator.equals(InfixExpression.Operator.GREATER_EQUALS)) {
				if (leftValue>=rightValue) {
					constraint = trueConstraint;
				}else {
					constraint = falseConstraint;
				}
			}else if (operator.equals(InfixExpression.Operator.EQUALS)) {
				if (leftValue==rightValue) {
					constraint = trueConstraint;
				}else {
					constraint = falseConstraint;
				}
			}else if (operator.equals(InfixExpression.Operator.NOT_EQUALS)){
				if (leftValue!=rightValue) {
					constraint = trueConstraint;
				}else {
					constraint = falseConstraint;
				}
			}else{
				System.out.println("Constraint solver can't do with the operator: "+operator);
			}
		}
		if (constraint == null) {
			System.out.println("can't solve this kind of constraint");
		}
		return constraint;
	}
	
	public boolean solve(){
		CPSolver solver = new CPSolver();
		for (Iterator iterator = model.getConstraintIterator();iterator.hasNext();) {
			Constraint constraint = (Constraint) iterator.next();
			System.out.println(constraint);
		}
		System.out.println("****");
		solver.read(model);
		boolean solverable = solver.solve();
		return solverable;
	}
	
	/**
	 * ����envVariableValueHashMap���key
	 */
	private void transEnv(){
		for (Iterator iterator = envVariableValueHashMap.keySet().iterator(); iterator.hasNext();) {
			String key = (String)iterator.next();
			IntegerVariable type = (IntegerVariable)envVariableValueHashMap.get(key);
			System.out.println(key + ":\t" + type);
		}
	}
	
	/**
	 * ��һ��ExpressionNode��������ʽ����������
	 * @param root the root of a expression tree which provided by symbolic execution environment
	 * @return
	 */
	public IntegerExpressionVariable constraintVariableModeling(ExpressionNode root){
		IntegerExpressionVariable result = null;
		ExpressionType type=root.getType();
		if (type==ExpressionType.expression) {
			ExpressionOperator operator = root.getOperator();
			ExpressionNode leftPart = root.getLeft();
			ExpressionNode rightPart = root.getRight();
			ExpressionType leftType = leftPart.getType();
			ExpressionType rightType = rightPart.getType();
			/*
			 * ���������ǽ����ʽ�ݹ�Ĺ�����IntegerExpressionVariable�����ṩ������Constraint��
			 * ��Ҫ˼·��������������ֲ�ͬ�����ͽ��б��ʽ�����Ĺ�������int��variable��expression���и������
			 * ��Ҫע������������û��(int, int)��������Ϊ��������ӽڵ㶼��int������ֵ�Ļ�����ô������ʽ���ǿ���
			 * ����������ģ��佫�ᱻ���������档��һ���Ĺ��������ڷ���ִ�й�������ɣ�Ҳ����ͨ��һ�������Ա��ʽ������
			 * ������������
			 */
			switch (operator) {
			case minus: {
				// int and variable
				if (leftType == ExpressionType.single_int && rightType == ExpressionType.single_variable) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					print((IntegerVariable) envVariableValueHashMap.get(rightPart.getValue()));
					result = Choco.minus(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.single_variable) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					print((IntegerVariable) envVariableValueHashMap.get(leftPart.getValue()));
					result = Choco.minus(leftValue, rightValue);
				}
				// int and expression
				else if (leftType == ExpressionType.single_int && rightType == ExpressionType.expression) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.minus(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.expression) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.minus(leftValue, rightValue);
				}
				// expression and variable
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.single_variable) {
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.minus(leftValue, rightValue);
				}else if (rightType == ExpressionType.expression && leftType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.minus(leftValue, rightValue);
				}
				// both are expression
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.expression) {
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.minus(leftValue, rightValue);
				}
				// both are variable
				else if (leftType == ExpressionType.single_variable && rightType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.minus(leftValue, rightValue);
				}
				break;
			}
			case plus: {
				// int and variable
				if (leftType == ExpressionType.single_int && rightType == ExpressionType.single_variable) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.plus(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.single_variable) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					result = Choco.plus(leftValue, rightValue);
				}
				// int and expression
				else if (leftType == ExpressionType.single_int && rightType == ExpressionType.expression) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.plus(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.expression) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.plus(leftValue, rightValue);
				}
				// expression and variable
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.single_variable) {
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.plus(leftValue, rightValue);
				}else if (rightType == ExpressionType.expression && leftType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.plus(leftValue, rightValue);
				}
				// both are expression
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.expression) {
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.plus(leftValue, rightValue);
				}
				// both are variable
				else if (leftType == ExpressionType.single_variable && rightType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.plus(leftValue, rightValue);
				}
				break;
			}
			case multi: {
				// int and variable
				if (leftType == ExpressionType.single_int && rightType == ExpressionType.single_variable) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.mult(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.single_variable) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					result = Choco.mult(leftValue, rightValue);
				}
				// int and expression
				else if (leftType == ExpressionType.single_int && rightType == ExpressionType.expression) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.mult(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.expression) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.mult(leftValue, rightValue);
				}
				// expression and variable
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.single_variable) {
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.mult(leftValue, rightValue);
				}else if (rightType == ExpressionType.expression && leftType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.mult(leftValue, rightValue);
				}
				// both are expression
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.expression) {
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.mult(leftValue, rightValue);
				}
				// both are variable
				else if (leftType == ExpressionType.single_variable && rightType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.mult(leftValue, rightValue);
				}
				break;
			}
			case div: {
				// int and variable
				if (leftType == ExpressionType.single_int && rightType == ExpressionType.single_variable) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.div(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.single_variable) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					result = Choco.div(leftValue, rightValue);
				}
				// int and expression
				else if (leftType == ExpressionType.single_int && rightType == ExpressionType.expression) {
					int leftValue = Integer.parseInt(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.div(leftValue, rightValue);
				}else if (rightType == ExpressionType.single_int && leftType == ExpressionType.expression) {
					int rightValue = Integer.parseInt(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.div(leftValue, rightValue);
				}
				// expression and variable
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.single_variable) {
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					result = Choco.div(leftValue, rightValue);
				}else if (rightType == ExpressionType.expression && leftType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.div(leftValue, rightValue);
				}
				// both are expression
				else if (leftType == ExpressionType.expression && rightType == ExpressionType.expression) {
					IntegerExpressionVariable leftValue = constraintVariableModeling(leftPart);
					IntegerExpressionVariable rightValue = constraintVariableModeling(rightPart);
					result = Choco.div(leftValue, rightValue);
				}
				// both are variable
				else if (leftType == ExpressionType.single_variable && rightType == ExpressionType.single_variable) {
					IntegerVariable leftValue = (IntegerVariable) envVariableValueHashMap.get(leftPart.getValue());
					IntegerVariable rightValue = (IntegerVariable) envVariableValueHashMap.get(rightPart.getValue());
					result = Choco.div(leftValue, rightValue);
				}
				break;
			}
			}

		}else if (type == ExpressionType.single_variable) {
			result = (IntegerVariable) envVariableValueHashMap.get(root.getValue());
		}else if (type == ExpressionType.single_int) {
			System.out.println("Try to make a integer into a variable: "+root.getValue());
		}else {
			System.out.println("can't generate the cp variable" + type);
		}
		/*
		 * ��ע�͵������Ӧ�����ò��ŵ�
		 */
		return result;
	}
	
	/**
	 * ΪԼ�����ʽ����Լ��
	 * @param exp
	 * @return
	 */
	public Constraint constraintModeling(InfixExpression exp){
		Constraint constraint = null;
		exp.getOperator();
		exp.getLeftOperand();
		exp.getRightOperand();
		return constraint;
	}
	
	/**
	 * ����exp�õ�ExpressionNode
	 * @param exp
	 * @return
	 */
	public ExpressionNode getExpressionNode(Expression exp) {
		ExpressionNode result = null;
		ExpressionNode leftPart = null;
		ExpressionNode rightPart = null;
		ExpressionType type = null;
		ExpressionOperator operator = null;
		// InfixExpression.Operator operator;

		if (exp instanceof InfixExpression) {
			((InfixExpression) exp).getOperator();
		} else if (exp instanceof SimpleName) {

		} else if (exp instanceof NumberLiteral) {

		}
		return result;
	}
	
	// ׼����������Expression
	public static ExpressionNode prepare(){
		ExpressionNode leaf1= new ExpressionNode(ExpressionType.single_int, "58",ExpressionOperator.plus, null, null);
		ExpressionNode leaf2= new ExpressionNode(ExpressionType.single_variable, "a",ExpressionOperator.minus,null, null);
		ExpressionNode branch1= new ExpressionNode(ExpressionType.expression, null,ExpressionOperator.plus,leaf1, leaf2);
		ExpressionNode leaf3= new ExpressionNode(ExpressionType.single_int, "29",ExpressionOperator.minus, null, null);
		return new ExpressionNode(ExpressionType.expression, null,ExpressionOperator.minus,branch1, leaf3);
	}
	
	/**
	 * �˷�������root�漰���ķ��ű�����ʼ��ΪԼ������еĻ�������
	 * @param root
	 */
	public void updateVariable(ExpressionNode root){
		HashMap<ExpressionOperator, String> expression_operator = new HashMap<>();
		expression_operator.put(ExpressionOperator.div, "\\");
		expression_operator.put(ExpressionOperator.plus, "+");
		expression_operator.put(ExpressionOperator.minus, "-");
		expression_operator.put(ExpressionOperator.multi, "*");
		if (root!=null) {
//			if(root.operator!=null){
			if(root.getType()==ExpressionType.expression){
//				print("(");
				updateVariable(root.getLeft());
//				print(root.getOperator());
				print(expression_operator.get(root.getOperator()));
				updateVariable(root.getRight());
//				print(")");
			}else {
//				print(root.getValue());
				if(root.getType()==ExpressionType.single_variable){
					String variableName = root.getValue();
					if (!envVariableValueHashMap.containsKey(variableName)) {
						envVariableValueHashMap.put(variableName, Choco.makeIntVar(variableName));
					}
				}
			}
		}
	}

	
	/**
	 * �˷�������root�漰���ķ��ű�����ʼ��ΪԼ������еĻ�������
	 * @param root
	 */
	public void updateVariableAndPrintExpression(ExpressionNode root){
		HashMap<ExpressionOperator, String> expression_operator = new HashMap<>();
		expression_operator.put(ExpressionOperator.div, "\\");
		expression_operator.put(ExpressionOperator.plus, "+");
		expression_operator.put(ExpressionOperator.minus, "-");
		expression_operator.put(ExpressionOperator.multi, "*");
		if (root!=null) {
//			if(root.operator!=null){
			if(root.getType()==ExpressionType.expression){
				print("(");
				updateVariable(root.getLeft());
//				print(root.getOperator());
				print(expression_operator.get(root.getOperator()));
				updateVariable(root.getRight());
				print(")");
			}else {
				print(root.getValue());
				if(root.getType()==ExpressionType.single_variable){
					String variableName = root.getValue();
					if (!envVariableValueHashMap.containsKey(variableName)) {
						envVariableValueHashMap.put(variableName, Choco.makeIntVar(variableName));
					}
				}
			}
		}
	}


	private static void println(Object o) {
		System.out.println(o);
	}

	private static void print(Object o) {
		System.out.print(o);
	}
//
//	// a simple demo of solve exhibition
//	private static void simpleDemo() {
//		IntegerVariable v = Choco.makeIntVar("v", new Integer(1), new Integer(10));
//		Constraint c = Choco.eq(v, new Integer(1));
//		CPModel model = new CPModel();
//		model.addConstraint(c);
//		CPSolver solver = new CPSolver();
//		solver.read(model);
//		boolean solverable = solver.solve();
//		println(solverable);
//	}
//	
//	// a simple demo 
//	private static void simpleDemo2(){
//		IntegerVariable a= Choco.makeIntVar("a");
//		IntegerVariable b = Choco.makeIntVar("b");
//		Constraint c = Choco.lt(a, b);
//		Constraint d = Choco.gt(a, b);
//		CPModel model = new CPModel();
//		model.addConstraint(c);
//		model.addConstraint(d);
//		CPSolver solver = new CPSolver();
//		solver.read(model);
//		boolean solverable = solver.solve();
//		println(solverable);
//	}
//
//	// a demo to exhibit the process of Choco solving
//	private static void chocoStreamline() {
//		// Constant declaration
//		int n = 3; // Order of the magic square
//		int magicSum = n * (n * n + 1) / 2; // Magic sum
//		// Build the model
//		CPModel m = new CPModel();
//		// Creation of an array of variables
//		IntegerVariable[][] var = new IntegerVariable[n][n];
//		// For each variable, we define its name and the boundaries of its
//		// domain.
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n; j++) {
//				var[i][j] = Choco.makeIntVar("var_" + i + "_" + j, 1, n * n);
//				// Associate the variable to the model.
//				m.addVariable(var[i][j]);
//			}
//		}
//		// All cells of the matrix must be different
//		for (int i = 0; i < n * n; i++) {
//			for (int j = i + 1; j < n * n; j++) {
//				Constraint c = (Choco.neq(var[i / n][i % n], var[j / n][j % n]));
//				m.addConstraint(c);
//			}
//		}
//	}
//
//	/**
//	 * the n-queens problem
//	 */
//	private static void problem1() {
//		int nbQueen = 3;
//		// 1- Create the model
//		CPModel m = new CPModel();
//		// 2- Create the variables
//		IntegerVariable[] queens = Choco.makeIntVarArray("Q", nbQueen, 1, nbQueen);// �ĸ��ʺ�������У����������������е����
//		// 3- Post constraints
//		for (int i = 0; i < nbQueen; i++) {
//			for (int j = i + 1; j < nbQueen; j++) {
//				int k = j - i;
//				m.addConstraint(Choco.neq(queens[i], queens[j]));// queens[i]��ֵ���ǵ�i���ʺ����ڵ��б��
//				m.addConstraint(Choco.neq(queens[i], Choco.plus(queens[j], k))); // ���Խ���Լ����Ϊʲô����ȡChoco.neq(k, Choco.minus(queens[j], queens[i]))
////				m.addConstraint(Choco.neq(k, Choco.minus(queens[j], queens[i]))); // ����Choco.neq(k, Choco.minus(queens[j], queens[i]))�����ʧ�ܣ�����������
//				m.addConstraint(Choco.neq(queens[i], Choco.minus(queens[j], k))); // ���Խ���Լ��
//			}
//		}
//		// 4- Create the solver
//		CPSolver s = new CPSolver();
//		s.read(m);
//		s.solveAll();
//		// 5- Print the number of solutions found
//		System.out.println("Number of solutions found:" + s.getSolutionCount());
//	}
//	
//	/**
//	 *  Steiner problem
//	 */
//	private static void problem2() {
//		// 1- Create the problem
//		CPModel mod = new CPModel();
//		int m = 7;
//		int n = m * (m - 1) / 6;
//		// 2- Create Variables
//		SetVariable[] vars = new SetVariable[n]; // A variable for each set
//		SetVariable[] intersect = new SetVariable[n * n]; // A variable for each
//															// pair of sets
//		for (int i = 0; i < n; i++)
//			vars[i] = Choco.makeSetVar("set " + i, 1, n);
//		for (int i = 0; i < n; i++)
//			for (int j = i + 1; j < n; j++)
//				intersect[i * n + j] = Choco.makeSetVar("interSet " + i + " " + j, 1, n);
//		// 3- Post constraints
//		for (int i = 0; i < n; i++)
//			mod.addConstraint(Choco.eqCard(vars[i], 3));
//		for (int i = 0; i < n; i++)
//			for (int j = i + 1; j < n; j++) {
//				// the cardinality of the intersection of each pair is equal to
//				// one
//				mod.addConstraint(Choco.setInter(vars[i], vars[j], intersect[i * n + j]));
//				mod.addConstraint(Choco.leqCard(intersect[i * n + j], 1));
//			}
//		// 4- Search for a solution
//		CPSolver s = new CPSolver();
//		s.read(mod);
//		s.setVarSetSelector(new MinDomSet(s, s.getVar(vars)));
//		s.setValSetSelector(new MinEnv());
//		s.solve();
//		// 5- Print the solution found
//		for (SetVariable var : vars) {
//			System.out.println(s.getVar(var).pretty());
//		}
//	}
//
//	/**
//	 * Descripton: Example 3: the CycloHexane problem. The problem consists in
//	 * nding the 3D con guration of a cyclohexane molecule. It is described with
//	 * a system of three non linear equations: Variables: x; y; z. Domain:[8, 8]
//	 * Constraints: 
//	 * y2 * (1 + z2) + z * (z - 24 * y) = -13 
//	 * x2 * (1 + y2) + y * (y - 24 * x) = -13 
//	 * z2 * (1 + x2) + x * (x - 24 * z) = -13
//	 */
//	private static void problem3() {
//		// 1- Create the problem
//		CPModel pb = new CPModel();
//		// 2- Create the variable
//		RealVariable x = Choco.makeRealVar("x", -1.0e8, 1.0e8);
//		RealVariable y = Choco.makeRealVar("y", -1.0e8, 1.0e8);
//		RealVariable z = Choco.makeRealVar("z", -1.0e8, 1.0e8);
//		// 3- Create and post the constraints
//		RealExpressionVariable exp1 = Choco.plus(// ��Լ�����ʽ�Ĺ�������ͨ��������XXXExpressionVariable�ĺ���ʵ�ֵ�
//				Choco.mult(Choco.power(y, 2), Choco.plus(1, Choco.power(z, 2))),// y2 *(1 + z2)
//				Choco.mult(z, Choco.minus(z, Choco.mult(24, y)))// z * (z - 24 * y)
//				);
//		RealExpressionVariable exp2 = Choco.plus(Choco.mult(Choco.power(z, 2), Choco.plus(1, Choco.power(x, 2))),
//				Choco.mult(x, Choco.minus(x, Choco.mult(24, z))));
//		RealExpressionVariable exp3 = Choco.plus(Choco.mult(Choco.power(x, 2), Choco.plus(1, Choco.power(y, 2))),
//				Choco.mult(y, Choco.minus(y, Choco.mult(24, x))));
//		Constraint eq1 = Choco.eq(exp1, -13);
//		Constraint eq2 = Choco.eq(exp2, -13);
//		Constraint eq3 = Choco.eq(exp3, -13);
//		pb.addConstraint(eq1);
//		pb.addConstraint(eq2);
//		pb.addConstraint(eq3);
//		// 4- Search for all solution
//		CPSolver s = new CPSolver();
//		s.getConfiguration().putDouble(Configuration.REAL_PRECISION, 1e-8);
//		s.read(pb);
//		s.setVarRealSelector(new CyclicRealVarSelector(s));
//		s.setValRealIterator(new RealIncreasingDomain());
//		s.solve();
//		// 5- print the solution found
//		System.out.println("x " + s.getVar(x).getValue());
//		System.out.println("y " + s.getVar(y).getValue());
//		System.out.println("z " + s.getVar(z).getValue());
//	}
}
