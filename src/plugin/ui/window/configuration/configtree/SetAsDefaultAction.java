package plugin.ui.window.configuration.configtree;

import org.eclipse.jface.action.Action;
/**
 * 设为默认
 * @author wlj
 *
 */
public class SetAsDefaultAction extends Action {
	final static String name="SetAsDefault";
	
	public SetAsDefaultAction(){
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//super.run();
		System.out.println("设为默认");
	}
}
