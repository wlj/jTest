package plugin.ui.window.configuration;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TreeEditor;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

/**
 * ConfigTree的编辑控件
 * @author wlj
 *
 */
public class ConfigTreeEditorText {
	/**
	 * 创建文本框
	 * @param tree
	 * @return
	 */
	public static Text CreateText(Composite tree,FocusListener focusListener){
		Text text=new Text(tree, SWT.SINGLE | SWT.BORDER);
		text.addFocusListener(focusListener);
		return text;
	}
}
