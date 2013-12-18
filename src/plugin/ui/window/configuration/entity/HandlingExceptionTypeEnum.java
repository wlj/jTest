package plugin.ui.window.configuration.entity;
/**
 * 处理异常方式枚举
 * @author wlj
 *
 */
public enum HandlingExceptionTypeEnum {
	/**
	 * 抛出和报告
	 */
	ThrowAndReport,
	/**
	 * 捕获和断言已检查的
	 */
	CatchAndAssertChecked,
	/**
	 * 捕获和断言所有的
	 */
	CatchAndAssertAll
}
