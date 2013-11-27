/**
 * 新建命令
 */
package plugin.ui.window.configuration.configtree;

import org.eclipse.jface.action.Action;

/**
 * @author wlj
 *
 */
public class NewAction extends Action {
	
	final static String name="New";
	
	public NewAction(){
		super(name);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("New");
	}
}
