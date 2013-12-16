package plugin.ui.window.configuration.entity;
/**
 * 执行的规则树(此类暂不使用)
 * @author wlj
 *
 */
public class RuleTree4Execution {
	//是否启用规则错误检查
	private boolean isEnabled;
	//报告运行时错误类型
	//1=来自于工作空间的全部项目
	//2=从范围中选择的文件
	//3=从范围中选择的行
	private int runtimeErrorScopeType4Report;
	//排除测试类
	private boolean isExcludeTestCase;
	
}
