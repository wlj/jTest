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
	
	private final ConfigTree configTree;
	
	final static String name="New";
	
	public NewAction(ConfigTree configTree){
		super(name);
		this.configTree=configTree;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//configTree.NewConfig();
	}
}
