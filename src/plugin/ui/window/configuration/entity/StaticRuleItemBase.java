package plugin.ui.window.configuration.entity;
/**
 * 静态分析规则的基类
 * @author suntao2
 *
 */
public abstract class StaticRuleItemBase {
	
	protected Metrics metrics;
	/**
	 * 运行分析
	 * @return
	 */
	public abstract boolean check();
	/**
	 * 获取描述
	 * @return
	 */
	public abstract String getDescription();
	/**
	 * 获取检测名称
	 * @return
	 */
	public abstract String getName();
}
