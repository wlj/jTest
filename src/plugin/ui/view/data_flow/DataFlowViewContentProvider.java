package plugin.ui.view.data_flow;

import java.util.List;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

//���������ɴ�������뵽�������ݽ���ɸѡ��ת����
public class DataFlowViewContentProvider implements IStructuredContentProvider{
	// �����뵽�������ݼ��Ͻ���ɸѡ��ת����������ݼ�ȫ��Ҫת�������飬ÿһ������Ԫ�ؾ���һ��ʵ�������Ҳ���Ǳ���е�һ����¼��
		public Object[] getElements(Object element) {
			// ����element����ͨ��setInput(Object input)����Ķ���input��
				return new Object[0]; // ���List�����򷵻�һ��������
		}

		// ��TableViewer���󱻹ر�ʱ����ִ�д˷���
		public void dispose() {}

		// ��TableViewer�ٴε���setInput()ʱ����ִ�д˷���
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {}
}
