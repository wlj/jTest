package plugin.ui.window.configuration.configtree;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import plugin.ui.window.configuration.interfaces.IConfig;
import plugin.ui.window.configuration.persistence.PersistenceContext;

/**
 * 配置树的抽象类
 * @author wlj
 *
 */
public abstract class ConfigTreeBase {
	/**
	 * 配置接口
	 */
	protected IConfig config;
	protected PersistenceContext persistenceContext;
	protected Tree tree;
	/**
	 * 构造函数
	 * @param parent
	 * @param style
	 * @param config
	 */
	public ConfigTreeBase(Composite parent, int style,IConfig config,PersistenceContext persistenceContext){
		if(config==null){
			throw new  NullPointerException("config cannot be null");
		}
		this.config=config;
	}
	public Tree getTree() {
		return tree;
	}
//	/**
//	 * 添加配置项
//	 * @return
//	 */
//	public abstract boolean Add();
//	/**
//	 * 
//	 * @return
//	 */
//	public abstract boolean Delete();
//	public abstract boolean Copy();
//	public abstract boolean SetAsDefault();
}
