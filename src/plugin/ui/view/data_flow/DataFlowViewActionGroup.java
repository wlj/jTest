package plugin.ui.view.data_flow;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.actions.ActionGroup;

public class DataFlowViewActionGroup extends ActionGroup {
	private TableViewer tv;
	
	// ��ActionҪʹ�õ�TableViewer��������ͨ�����캯������������
	public DataFlowViewActionGroup(TableViewer tv){
		this.tv = tv;
	}
	
	// �Զ��巽��������Action���󣬲�ͨ��������������ToolBarManager����������
	public void fillActionToolBars(ToolBarManager actionBarManager) {
		// ����Action����һ����ť��Ӧһ������Action
		Action ClearScreenAction = new ClearScreenAction();
		actionBarManager.add(createContributionItem(ClearScreenAction));
		actionBarManager.update(true);// ���¹����������򹤾�������ʾ�κΰ�ť
	}
	
	// �Ѱ�װ�Ĵ������д����һ������
	private IContributionItem createContributionItem(IAction action) {
		ActionContributionItem aci = new ActionContributionItem(action);
		aci.setMode(ActionContributionItem.MODE_FORCE_TEXT);// ��ʾͼ��+����
		return aci;
	}
	
	private class ClearScreenAction extends Action{
		public ClearScreenAction(){
			setText("Clear");
		}
		public void run(){
		}
	}
}
