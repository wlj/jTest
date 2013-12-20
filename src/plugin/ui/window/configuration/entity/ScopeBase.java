package plugin.ui.window.configuration.entity;
/**
 * Scope
 * @author wlj
 *
 */
public abstract class ScopeBase {
	/**
	 * 判断是否已过虑
	 * @param path文件路径
	 * @return
	 */
	//public abstract boolean isFilter(String path);
	//是否测试环形复杂度低于某值的方法
	private boolean testMethodsCyclomatic;
	//设置环形复杂度的值
	private int cyclomaticComplexity;
	//是否测试@deprecated的类或方法
	private boolean deprecatedClassesOrMethods;
	
}
