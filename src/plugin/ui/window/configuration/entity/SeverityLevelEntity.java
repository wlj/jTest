package plugin.ui.window.configuration.entity;

/**
 * 严重等级
 * 
 * @author wlj
 * 
 */
public class SeverityLevelEntity {
	// 严重程度
	private SeverityLevelEnum severityLevel;
	// 初始严重等级
	private InitSverityLevelEntity initSverityLevel;
	// 是否启用测试执行
	private boolean isEnabled;
	// BugDetective的运行时异常验证
	private ServerityModifierEnum bugDetective;
	// 用户定义的测试任务
	private ServerityModifierEnum testCaseUserDefine;
	// 在子句或@throws中声明异常
	private ServerityModifierEnum throwsDeclare;
	// 复制异常
	private ServerityModifierEnum copyException;
	// 异常要被测试代码明确抛出
	private ServerityModifierEnum testcodeThrowsException;
	// 测试输入来的NullPointerExceptions或者PreExpections
	private ServerityModifierEnum inputNullPointerExceptions;
	// 公共方法的任务
	private ServerityModifierEnum publicMethodTask;
	// 方法桩的任务
	private ServerityModifierEnum methodStubTask;
	// 未验证的任务
	private ServerityModifierEnum uncheckedTask;
	// 灵敏方法例外
	private ServerityModifierEnum sensitiveMethod;
	// 灵敏方法名
	private String[] sensitiveMethodNames;
	//未捕获异常类型的严重等级
	private UncaughtExceptionSeverityLevelEntity uncaughtExceptionSeverityLevelEntity;
}
