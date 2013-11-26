package core.jtester.staticanalysis.reaching_def;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

import core.common.cfg.interfaces.*;
import core.common.cfg.model.AbstractBasicBlock;
import core.common.model.functionblock.AnalysisBlockImpl;

public class RchDefBlock extends AnalysisBlockImpl {
	private CompilationUnit parser;

	public RchDefBlock(IBasicBlock bb, int lable) {
		super(bb, lable);
	}

	public void setParser(CompilationUnit parser) {
		this.parser = parser;
	}

	// ����ط���Ҫ�úÿ���һ�£����ڵ��뷨�ǲ�������ǰ�����������������Ƚ�����ı��ʽ����_temp��Ȼ���_temp����kill��gen�Ĳ���
	public void tansfer() {
		// ���_temp
		this._temp.clear();
		// ��_entry��Ԫ�ؼӵ�_temp
		if (this._entry.size() != 0) {
			for (int i = 0; i < this._entry.size(); i++) {
				this._temp.add(this._entry.get(i));
			}
		}

		this.kill();
		this.gen();

		// ��_temp��Ԫ�ظ���_exit
		if (this._temp.size() != 0) {
			this._exit.clear();
			for (int i = 0; i < this._temp.size(); i++) {
				this._exit.add(this._temp.get(i));
			}
		}

	}

	protected void killIPlainNode() {
		// �ж��Ƿ��Ǹ�ֵ��䣬����Ǿ�kill��_entry�к��С�=����߱����ı��ʽ
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();
		if (node instanceof ExpressionStatement) {
			Expression exp = ((ExpressionStatement) node).getExpression();
			if (exp instanceof Assignment) {
				Expression leftOperand = ((Assignment) exp).getLeftHandSide();
				for (int j = 0; j < this._temp.size(); j++) {
					if (leftOperand.toString().equals(((DefLocPair) _temp.get(j)).getVarName())) {
						this._temp.remove(j--);
					}
				}
			}
		}
	}

	public void gen() {
		if (_bb instanceof IPlainNode) {
			this.genIPlainNode();
		}
	}

	protected void genIPlainNode() {
		// ���ж��Ƿ��ǳ�ʼ�����߸�ֵ��䣬�ٽ���=�����ı����������к����һ��DefLocPair����_temp
		ASTNode node = (ASTNode) ((AbstractBasicBlock) this._bb).getData();
		
		if (node instanceof ExpressionStatement) {
			int startline = parser.getLineNumber(node.getStartPosition());
			Expression exp = ((ExpressionStatement) node).getExpression();
			if (exp instanceof Assignment) {
				Expression leftOperand = ((Assignment) exp).getLeftHandSide();
				DefLocPair dl = new DefLocPair(leftOperand.toString(),startline);
				this._temp.add(dl);
			}
		} else if (node instanceof VariableDeclarationStatement) {
			int startline = parser.getLineNumber(node.getStartPosition());
			VariableDeclarationStatement statement = (VariableDeclarationStatement) node;
			List fragments = statement.fragments();

			for (int i = 0; i < fragments.size(); i++) {
				VariableDeclarationFragment fragment = (VariableDeclarationFragment) fragments.get(i);
				SimpleName exp = fragment.getName();
				DefLocPair dl = new DefLocPair(exp.toString(),startline);
				this._temp.add(dl);
			}
		} else if (node instanceof SingleVariableDeclaration){
			int startline = parser.getLineNumber(node.getStartPosition());
			SingleVariableDeclaration statement = (SingleVariableDeclaration) node;
			DefLocPair dl = new DefLocPair(statement.getName().toString(),startline);
			this._temp.add(dl);
		}
	}
}
