package plugin.ui.window.configuration.entity;
/**
 * bug检测配置
 * @author wlj
 *
 */
public class BugDetectionEntity {
	private boolean isEnableIncrementalAnalysis;
	private int catchDays;
	private int depth;
	public boolean isEnableIncrementalAnalysis() {
		return isEnableIncrementalAnalysis;
	}
	public void setEnableIncrementalAnalysis(boolean isEnableIncrementalAnalysis) {
		this.isEnableIncrementalAnalysis = isEnableIncrementalAnalysis;
	}
	public int getCatchDays() {
		return catchDays;
	}
	public void setCatchDays(int catchDays) {
		this.catchDays = catchDays;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
}
