package plugin.ui.window.configuration.entity;
/**
 * 执行的选项
 * @author wlj
 *
 */
public class Option4ExecutionEntity {
//	/**
//	 * 报告未验证输出的最大极限
//	 */
//	public boolean isReportMaxUncheckedOutput;
//	/**
//	 * 未验证输出的最大极限
//	 */
//	public int maxUncheckedOutput;
//	/**
//	 * 报告未验证输出结果发布
//	 */
//	public boolean isReportUncheckedOutputPublish;
//	/**
//	 * 使用参数化测试用例在Execl文件中添加新的输出结果
//	 */
//	public boolean addResultToExcel;
//	/**
//	 * 检查契约式设计（禁用契约式设计类的运行时错误检测）
//	 */
//	public boolean checkContractdesign;
//	/**
//	 * 执行下一个测试类或套件超时
//	 */
//	public boolean exectNextTestcaseTimeout;
//	/**
//	 * 超时分钟数
//	 */
//	public int timeout;
//	/**
//	 * 测试执行的时间
//	 */
//	public boolean exectTestTime;
//	/**
//	 * 分开发布每个测试类或测试套件
//	 */
//	public boolean dividedPublishTestcase;
//	/**
//	 * 用debug模式运行测试用例
//	 */
//	public boolean runTestcaseInDebug;
//	/**
//	 * vm参数
//	 */
//	public String vmParams;
	public boolean isReportLineCoverage;
	public boolean isReportDecisionCoverage;
	public boolean isReportFailureLessThanCoverage;
	public int lessThanCoverage;
	public boolean isPublishMethodCoverage;
	public boolean isClearPreviousCoverage;
	public boolean isReportUnverifiedOutcomesLimit;
	public int limitOutcomes;
	public boolean isReportUnverifiedOutcomesDistributions;
	public boolean isAddOutcomesToExcel;
	public boolean isDetectMemoryLeaks;
	public boolean isCheckDesignByContract;
	public boolean isTimeoutBeforeExecuteNextTest;
	public int timeoutMinutes;
	public boolean isTotalTimeout4TestExecution;
	public int totalTimeoutMinutes;
	public boolean isSeperatelaunch;
	public boolean isRunTestsInDebugMode;
	public int PluginTests;
	//1:Do not run plugin tests;
	
	
}
