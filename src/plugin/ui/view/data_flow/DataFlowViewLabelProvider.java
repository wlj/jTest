package plugin.ui.view.data_flow;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

//��ǩ������ǩ�������ݼ��еĵ���ʵ�������д����ת�����ɱ�ǩ��������ʵ������е��ֶ���ʾ�ڱ�����һ���С�
public class DataFlowViewLabelProvider implements ITableLabelProvider{
	
	// �ɴ˷����������ݼ�¼�ڱ���ÿһ����ʾʲô���֡� element������һ��ʵ�������col�ǵ�ǰҪ���õ��е��кţ�0�ǵ�һ�С�
		public String getColumnText(Object element, int col) {
			return null; // �������Է��ؿ�ֵ
		}
		
	// getColumnText����������ʾ���֣�������������ʾͼƬ��
	public Image getColumnImage(Object element, int col) {
		return null; // �������Է��ؿ�ֵ
	}

	public void dispose() {
	}

	// -------------���·�������ʹ��,�Ȳ��ùܣ������ǿ�ʵ��-----------------
	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void removeListener(ILabelProviderListener listener) {
	}
}
