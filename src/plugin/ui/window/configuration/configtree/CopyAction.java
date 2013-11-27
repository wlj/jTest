package plugin.ui.window.configuration.configtree;

import org.eclipse.jface.action.Action;
/**
 * 复制命令
 * @author wlj
 *
 */
public class CopyAction extends Action {

	final static String name="Copy";
	
	public CopyAction(){
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("复制");
		//super.run();
	}
}
