package plugin.ui.window.configuration.entity;
/**
 * 静态分析实体类
 * @author wlj
 *
 */
public class StaticEntity {
	private boolean isEnabled;
	private int maxCount;
	private boolean skipTestClass;
	private StaticRuleItemBase[] staticRuleItemBases;
	private StaticGeneral general;
	private Metrics metrics;
	private BugDetectionEntity bugDetection;
	/**
	 * 获取启用状态
	 * @return
	 */
	public boolean isEnabled() {
		return isEnabled;
	}
	/**
	 * 设置启用状态
	 * @param isEnabled
	 */
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * 获取每条规则报告的最大任务数
	 * @return
	 */
	public int getMaxCount() {
		return maxCount;
	}
	/**
	 * 设置每条规则报告的最大任务数
	 * @param maxCount
	 */
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	/**
	 * 获取是否跳过自动生成的测试类
	 * @return
	 */
	public boolean isSkipTestClass() {
		return skipTestClass;
	}
	/**
	 * 设置是否跳过自动生成的测试类
	 * @param skipTestClass
	 */
	public void setSkipTestClass(boolean skipTestClass) {
		this.skipTestClass = skipTestClass;
	}
	/**
	 * 获取检测项
	 * @return
	 */
	public StaticRuleItemBase[] getStaticRuleItemBases() {
		return staticRuleItemBases;
	}
	/**
	 * 设置检测项
	 * @param staticRuleItemBases
	 */
	public void setStaticRuleItemBases(StaticRuleItemBase[] staticRuleItemBases) {
		this.staticRuleItemBases = staticRuleItemBases;
	}
	/**
	 * 获取静态检测的一般设置
	 * @return
	 */
	public StaticGeneral getGeneral() {
		return general;
	}
	/**
	 * 设置静态检测一般设置
	 * @param general
	 */
	public void setGeneral(StaticGeneral general) {
		this.general = general;
	}
	/**
	 * 获取度量指标
	 * @return
	 */
	public Metrics getMetrics() {
		return metrics;
	}
	/**
	 * 设置度量指标
	 * @param metrics
	 */
	public void setMetrics(Metrics metrics) {
		this.metrics = metrics;
	}
	/**
	 * 获取bug检测配置
	 * @return
	 */
	public BugDetectionEntity getBugDetection() {
		return bugDetection;
	}
	/**
	 * 设置静态检测配置
	 * @param bugDetection
	 */
	public void setBugDetection(BugDetectionEntity bugDetection) {
		this.bugDetection = bugDetection;
	}
	
}
