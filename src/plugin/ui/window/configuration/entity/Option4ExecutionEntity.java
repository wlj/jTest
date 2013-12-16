package plugin.ui.window.configuration.entity;
/**
 * 执行的选项
 * @author wlj
 *
 */
public class Option4ExecutionEntity {
	private boolean isReportMaxUncheckedOutput;
	private int maxUncheckedOutput;
	private boolean isReportUncheckedOutputPublish;
	
	private String vmParams;

	public boolean isReportMaxUncheckedOutput() {
		return isReportMaxUncheckedOutput;
	}

	public void setReportMaxUncheckedOutput(boolean isReportMaxUncheckedOutput) {
		this.isReportMaxUncheckedOutput = isReportMaxUncheckedOutput;
	}

	public int getMaxUncheckedOutput() {
		return maxUncheckedOutput;
	}

	public void setMaxUncheckedOutput(int maxUncheckedOutput) {
		this.maxUncheckedOutput = maxUncheckedOutput;
	}

	public boolean isReportUncheckedOutputPublish() {
		return isReportUncheckedOutputPublish;
	}

	public void setReportUncheckedOutputPublish(
			boolean isReportUncheckedOutputPublish) {
		this.isReportUncheckedOutputPublish = isReportUncheckedOutputPublish;
	}

	public String getVmParams() {
		return vmParams;
	}

	public void setVmParams(String vmParams) {
		this.vmParams = vmParams;
	}

	public Option4ExecutionEntity() {
	}
	
}
