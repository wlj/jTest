package core.jtester.staticanalysis.live_variable;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;

import core.common.cfg.interfaces.*;
import core.common.cfg.model.AbstractBasicBlock;
import core.common.model.functionblock.AnalysisBlockImpl;

public class LivVarBlock extends AnalysisBlockImpl {

	public LivVarBlock(IBasicBlock bb, int lable) {
		super(bb, lable);
	}

	// ����ط���Ҫ�úÿ���һ�£����ڵ��뷨�ǲ�������ǰ�����������������Ƚ�����ı��ʽ����_temp��Ȼ���_temp����kill��gen�Ĳ���
	public void tansfer() {
		// ���_temp
		this._temp.clear();
		// ��_entry��Ԫ�ؼӵ�_temp
		if (this._exit.size() != 0) {
			for (int i = 0; i < this._exit.size(); i++) {
				this._temp.add(this._exit.get(i));
			}
		}

		this.kill();
		this.gen();

		// ��_temp��Ԫ�ظ���_exit
		if (this._temp.size() != 0) {
			this._entry.clear();
			for (int i = 0; i < this._temp.size(); i++) {
				this._entry.add(this._temp.get(i));
			}
		}

	}

	protected void killIPlainNode() {
		// ���ж��Ƿ��Ǹ�ֵ��������������䣬����ǣ��ͽ���ʽ��ߵı�����_temp��ȥ��
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();
		if (node instanceof ExpressionStatement) {
			Expression exp = ((ExpressionStatement) node).getExpression();
			if (exp instanceof Assignment) {
				Expression leftOperand = ((Assignment) exp).getLeftHandSide();
				for (int j = 0; j < this._temp.size(); j++) {
					if (leftOperand.toString().equals(
							((Expression) _temp.get(j)).toString())) {
						this._temp.remove(j--);
					}
				}
			}
		} else if (node instanceof VariableDeclarationStatement) {
			VariableDeclarationStatement statement = (VariableDeclarationStatement) node;
			List fragments = statement.fragments();
			for (int i = 0; i < fragments.size(); i++) {
				VariableDeclarationFragment fragment = (VariableDeclarationFragment) fragments
						.get(i);
				String varName = fragment.getName().toString();
				for (int j = 0; j < this._temp.size(); j++) {
					if (varName.equals(((Expression) _temp.get(j)).toString())) {
						this._temp.remove(j--);
					}
				}
			}
		}
	}

	protected void genIPlainNode() {
		// ���ж��Ƿ��ǳ�ʼ�����߸�ֵ��䣬���жϡ�=���ұ��ǲ��Ǳ��ʽ������Ǿͼ���_temp
		// ��ʱ���ǵ�ʽ�ұ���һԪ���ʽ��һԪ���ʽ
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();

		if (node instanceof VariableDeclarationStatement) {
			VariableDeclarationStatement statement = (VariableDeclarationStatement) node;
			List fragments = statement.fragments();

			for (int i = 0; i < fragments.size(); i++) {
				VariableDeclarationFragment fragment = (VariableDeclarationFragment) fragments.get(i);
				Expression exp = fragment.getInitializer();
				if (exp instanceof InfixExpression) {
					InfixExpression infix = (InfixExpression) exp;
					Expression oprand1 = infix.getLeftOperand();
					Expression oprand2 = infix.getRightOperand();

					if (!isExist(oprand1)) {
						this._temp.add(oprand1);
						System.out.println("add : "+ oprand1);
					}

					if (!isExist(oprand2)) {
						this._temp.add(oprand2);
						System.out.println("add : "+ oprand2);
					}
				} else if (exp instanceof NumberLiteral || exp == null) {
					continue;
				} else {
					if (!isExist(exp)) {
						this._temp.add(exp);
					}
				}
			}
		} else if (node instanceof ExpressionStatement) {
			Expression exp = ((ExpressionStatement) node).getExpression();
			if (exp instanceof Assignment) {
				Expression rightOperand = ((Assignment) exp).getRightHandSide();
				if (rightOperand instanceof InfixExpression) {
					InfixExpression infix = (InfixExpression) rightOperand;
					Expression oprand1 = infix.getLeftOperand();
					Expression oprand2 = infix.getRightOperand();

					if (!isExist(oprand1)) {
						this._temp.add(oprand1);
					}

					if (!isExist(oprand2)) {
						this._temp.add(oprand2);
					}
				} else if (rightOperand instanceof NumberLiteral) {
				} else {
					if (!isExist(rightOperand)) {
						this._temp.add(rightOperand);
					}
				}
			}
		}
	}

	protected void genIDecisionNode() {
		// �ж� >,>=,<,<=,�����Ƿ��б��ʽ������оͼ���_exit
		// ��ʱֻ������һԪ���ʽ�Ͷ�Ԫ���ʽ�����
		// �ж� >,>=,<,<=,�����Ƿ��б��ʽ������оͼ���_exit
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();
		
		if (node instanceof InfixExpression) {
			Expression oprand1 = ((InfixExpression) node).getLeftOperand();
			Expression oprand2 = ((InfixExpression) node).getRightOperand();
			if (oprand1 instanceof InfixExpression){
				InfixExpression infix = (InfixExpression) oprand1;
				Expression o1 = infix.getLeftOperand();
				Expression o2 = infix.getRightOperand();

				if (!isExist(o1)) {
					this._temp.add(o1);
				}

				if (!isExist(o2)) {
					this._temp.add(o2);
				}
			} else if (oprand1 instanceof NumberLiteral){
				
			} else if (!isExist(oprand1)){
				this._temp.add(oprand1);
			}
				
			if (oprand2 instanceof InfixExpression){
				InfixExpression infix = (InfixExpression) oprand2;
				Expression o1 = infix.getLeftOperand();
				Expression o2 = infix.getRightOperand();

				if (!isExist(o1)) {
					this._temp.add(o1);
				}

				if (!isExist(o2)) {
					this._temp.add(o2);
				}
			} else if (oprand2 instanceof NumberLiteral){
				
			} else if (!isExist(oprand2)){
				this._temp.add(oprand2);
			}
		}
	}
}
