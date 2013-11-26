package core.jtester.staticanalysis.available_exp;

import core.common.cfg.interfaces.IBasicBlock;
import core.common.model.functionblock.AnalysisBlockImpl;

public class AvbExpBlock extends AnalysisBlockImpl {

	public AvbExpBlock(IBasicBlock bb, int lable) {
		super(bb, lable);
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
		this.gen();
		this.kill();

		// ��_temp��Ԫ�ظ���_exit
		if (this._temp.size() != 0) {
			this._exit.clear();
			for (int i = 0; i < this._temp.size(); i++) {
				this._exit.add(this._temp.get(i));
			}
		}
	}
}
