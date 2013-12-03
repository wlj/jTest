package plugin.ui.window.configuration.configtree;

import org.eclipse.swt.widgets.Composite;

import plugin.ui.window.configuration.interfaces.IConfig;

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
	/**
	 * 构造函数
	 * @param parent
	 * @param style
	 * @param config
	 */
	public ConfigTreeBase(Composite parent, int style,IConfig config){
		if(config==null){
			throw new  NullPointerException("config cannot be null");
		}
		this.config=config;
	}
}
