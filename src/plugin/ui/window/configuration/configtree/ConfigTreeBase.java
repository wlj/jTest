package plugin.ui.window.configuration.configtree;

import java.util.Observable;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import plugin.ui.window.configuration.entity.ConfigEntity;
import plugin.ui.window.configuration.interfaces.IConfig;
import plugin.ui.window.configuration.persistence.PersistenceContext;

/**
 * 配置树的抽象类
 * @author wlj
 *
 */
public abstract class ConfigTreeBase extends Observable {
	/**
	 * 配置接口
	 */
	protected IConfig config;
	protected Tree tree;
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
	public Tree getTree() {
		return tree;
	}
	/**
	 * 添加配置项
	 * @return
	 */
	public abstract boolean Add();
	/**
	 * 删除配置项
	 * @return
	 */
	public abstract boolean Delete();
	/**
	 * 复制配置项
	 * @return
	 */
	public abstract boolean Copy();
	/**
	 * 设为默认项
	 * @return
	 */
	public abstract boolean SetAsDefault();
	/**
	 * 获取选中的配置文件
	 * @return
	 */
	public abstract ConfigEntity getSelectedConfigEntity();
}
