package core.common.model.functionblock;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.eclipse.jdt.core.dom.InfixExpression.Operator;

import core.common.cfg.interfaces.*;
import core.common.cfg.model.AbstractBasicBlock;
import core.common.model.functionblock.AnalysisBlock;

public class AnalysisBlockImpl extends AnalysisBlock{
	
	public AnalysisBlockImpl(IBasicBlock bb, int lable) {
		super(bb, lable);
	}

	// ����ط���Ҫ�úÿ���һ�£����ڵ��뷨�ǲ�������ǰ�����������������Ƚ�����ı��ʽ����_temp��Ȼ���_temp����kill��gen�Ĳ���
	public void transfer(){
	}

	public void kill() {
		if (_bb instanceof IStartNode) {
		} else if (_bb instanceof IBranchNode) {
		} else if (_bb instanceof IPlainNode) {
			this.killIPlainNode();
		} else if (_bb instanceof IExitNode) {
		} else if (_bb instanceof IDecisionNode) {
		} else if (_bb instanceof IJumpNode) {
		} else if (_bb instanceof IConnectorNode) {
		} else {
		}
	}

	protected void killIPlainNode() {
		// �ж��Ƿ��Ǹ�ֵ��䣬����Ǿ�kill��_entry�к��С�=����߱����ı��ʽ
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();

		if (node instanceof VariableDeclarationStatement) {
			VariableDeclarationStatement statement = (VariableDeclarationStatement)node;
			List fragments = statement.fragments();
			
			for(int i=0;i<fragments.size();i++){
				VariableDeclarationFragment fragment = (VariableDeclarationFragment)fragments.get(i);
				Expression exp = fragment.getName();
				
				for (int j = 0; j < this._temp.size(); j++) {
					Expression oprand1 = ((InfixExpression) _temp.get(j)).getLeftOperand();
					Expression oprand2 = ((InfixExpression) _temp.get(j)).getRightOperand();
					if (exp.equals(oprand1)|| exp.equals(oprand2)) {
						this._temp.remove(j--);
					}
				}
			}
		} else if (node instanceof ExpressionStatement){
			Expression exp = ((ExpressionStatement)node).getExpression();
			if(exp instanceof Assignment){
				Expression leftOperand = ((Assignment)exp).getLeftHandSide();
				for (int j = 0; j < this._temp.size(); j++) {
					Expression oprand1 = ((InfixExpression) _temp.get(j)).getLeftOperand();
					Expression oprand2 = ((InfixExpression) _temp.get(j)).getRightOperand();
					
					if (leftOperand.toString().equals(oprand1.toString())|| leftOperand.toString().equals(oprand2.toString())) {
						this._temp.remove(j--);
					}
				}
			}
		}
	}

	public void gen() {
		if (_bb instanceof IStartNode) {
		} else if (_bb instanceof IBranchNode) {
		} else if (_bb instanceof IPlainNode) {
			this.genIPlainNode();
		} else if (_bb instanceof IExitNode) {
		} else if (_bb instanceof IDecisionNode) {
			this.genIDecisionNode();
		} else if (_bb instanceof IJumpNode) {
		} else if (_bb instanceof IConnectorNode) {
		} else {
		}
	}

	// ����ʱ���жϴ�������ʽ�Ƿ����
	// Ĭ�����ڵ�Expressionֻ��2Ԫ������e.g. a + b
	// ���õݹ���ʵ�ָ��ӱ��ʽ���������ж�
	protected boolean isExist(InfixExpression exp) {
		boolean flag = false;
		Expression leftOperand =  exp.getLeftOperand();
		Expression rightOperand =  exp.getRightOperand();
		Operator operator =  exp.getOperator();

		for (int i = 0; i < this._temp.size(); i++) {
			Expression lOperand = ((InfixExpression) _temp.get(i)).getLeftOperand();
			Expression rOperand = ((InfixExpression) _temp.get(i)).getRightOperand();
			Operator op = ((InfixExpression) _temp.get(i)).getOperator();
			if (leftOperand.equals(lOperand) 
					&& rightOperand.equals(rOperand) 
					&& operator.equals(op)) {
				flag = true;
			}
		}
		return flag;
	}
	
	protected boolean isExist(Expression exp){
		for (int i = 0; i < this._temp.size(); i++) {
			Expression operand = (Expression) _temp.get(i);
			if(exp.toString().equals(operand.toString())){
				return true;
			}
		}
		return false;
	}

	protected void genIPlainNode() {
		// ���ж��Ƿ��ǳ�ʼ�����߸�ֵ��䣬���жϡ�=���ұ��ǲ��Ǳ��ʽ������Ǿͼ���_temp
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();
		
		if (node instanceof VariableDeclarationStatement) {
			VariableDeclarationStatement statement = (VariableDeclarationStatement)node;
			List fragments = statement.fragments();
			
			for(int i=0;i<fragments.size();i++){
				VariableDeclarationFragment fragment = (VariableDeclarationFragment)fragments.get(i);
				Expression exp = fragment.getInitializer();
				if(exp instanceof InfixExpression && !isExist((InfixExpression)exp)){
					this._temp.add((InfixExpression)exp);
				}
			}
		} else if (node instanceof ExpressionStatement){
			Expression exp = ((ExpressionStatement)node).getExpression();
			if(exp instanceof Assignment){
				Expression rightOperand = ((Assignment)exp).getRightHandSide();
				if(rightOperand instanceof InfixExpression && !isExist((InfixExpression)rightOperand)){
					this._temp.add((InfixExpression)rightOperand);
				}
			}
		}
	}

	protected void genIDecisionNode() {
		// �ж� >,>=,<,<=,�����Ƿ��б��ʽ������оͼ���_exit
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();
		
		Expression exp = null;
		if (node instanceof WhileStatement) {
			exp = ((WhileStatement) node).getExpression();
		} else if( node instanceof IfStatement){
			exp = ((IfStatement) node).getExpression();
		}		
		
		if(exp instanceof InfixExpression && !isExist((InfixExpression)exp)){
			Expression oprand1 = ((InfixExpression) exp).getLeftOperand();
			Expression oprand2 = ((InfixExpression) exp).getRightOperand();
			if (oprand1 instanceof InfixExpression){
				if (!isExist((InfixExpression)oprand1)){
					this._temp.add(oprand1);
				}
			}
				
			if (oprand2 instanceof InfixExpression){
				if (!isExist((InfixExpression)oprand2)){
					this._temp.add(oprand2);
				}
			}
		}
	}

	// Ĭ�ϲ��᷵������ a = b + c �����ı��ʽ
	protected void genIExitNode() {
		// �жϸýڵ��Ƿ���return�������return�����ж����ķ���ֵ�Ƿ���һ�����ʽ������Ǿͼ���_exit

	}

}
