package plugin.ui.window.configuration.configtree;

import org.eclipse.jface.action.Action;
/**
 * 删除
 * @author wlj
 *
 */
public class DeleteAction extends Action {
	
	final static String name="Delete";
	
	public DeleteAction(){
		super(name);
	}
	@Override
	public void run() {
		System.out.println("删除");
		// TODO Auto-generated method stub
		//super.run();
	}
}
