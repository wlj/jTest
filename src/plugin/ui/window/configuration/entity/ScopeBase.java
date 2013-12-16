package plugin.ui.window.configuration.entity;
/**
 * Scope积累
 * @author wlj
 *
 */
public abstract class ScopeBase {
	/**
	 * 判断是否已过虑
	 * @param path文件路径
	 * @return
	 */
	public abstract boolean isFilter(String path);
}
