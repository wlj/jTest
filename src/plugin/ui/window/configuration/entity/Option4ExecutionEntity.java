package plugin.ui.window.configuration.entity;
/**
 * 执行的选项
 * @author wlj
 *
 */
public class Option4ExecutionEntity {
	/**
	 * 报告未验证输出的最大极限
	 */
	private boolean isReportMaxUncheckedOutput;
	/**
	 * 未验证输出的最大极限
	 */
	private int maxUncheckedOutput;
	/**
	 * 报告未验证输出结果发布
	 */
	private boolean isReportUncheckedOutputPublish;
	/**
	 * 使用参数化测试用例在Execl文件中添加新的输出结果
	 */
	private boolean addResultToExcel;
	/**
	 * 检查契约式设计（禁用契约式设计类的运行时错误检测）
	 */
	private boolean checkContractdesign;
	/**
	 * 执行下一个测试类或套件超时
	 */
	private boolean exectNextTestcaseTimeout;
	/**
	 * 超时分钟数
	 */
	private int timeout;
	/**
	 * 测试执行的时间
	 */
	private boolean exectTestTime;
	/**
	 * 分开发布每个测试类或测试套件
	 */
	private boolean dividedPublishTestcase;
	/**
	 * 用debug模式运行测试用例
	 */
	private boolean runTestcaseInDebug;
	/**
	 * vm参数
	 */
	private String vmParams;
	
}
