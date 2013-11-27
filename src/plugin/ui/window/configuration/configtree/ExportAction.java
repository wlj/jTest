package plugin.ui.window.configuration.configtree;

import org.eclipse.jface.action.Action;
/**
 * 导出action
 * @author wlj
 *
 */
public class ExportAction extends Action {
	
	final static String name="Export";
	
	public ExportAction(){
		super(name);
	}
	@Override
	public void run() {
		System.out.println("导出");
		// TODO Auto-generated method stub
		//super.run();
	}
}
