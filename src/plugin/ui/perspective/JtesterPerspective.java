package plugin.ui.perspective;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import plugin.ui.view.data_flow.DataFlowView;

public class JtesterPerspective implements IPerspectiveFactory{
	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();

		// ʹ��package explorer
		IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, 0.2f, editorArea);
		left.addView("org.eclipse.jdt.ui.PackageExplorer");
		
		IFolderLayout bottom = layout.createFolder("bottom", IPageLayout.BOTTOM, 0.7f, editorArea);
		// �����Ұ���ͼ��IDȡ�ɺ���ͼ���ȫ��һ�����������������ַ����õ���ȫ��
		bottom.addView(DataFlowView.class.getName());
	}
}
