package plugin.ui.window.configuration.entity;
/**
 * 范围实体类
 * @author wlj
 *
 */
public class ScopeEntity {
	
	public FileFilter4Scope fileFilters;
	public CodeFilter4Scope codeFilter;
	public MethodFilters4Scope methodFilters;
	//是否测试环形复杂度低于某值的方法
	public boolean testMethodsCyclomatic;
	//设置环形复杂度的值
	public int cyclomaticComplexity;
	//是否测试@deprecated的类或方法
	public boolean deprecatedClassesOrMethods;
}
