package plugin.ui.window.configuration.entity;
/**
 * bug检测配置
 * @author wlj
 *
 */
public class BugDetectionEntity {
	//是否启用增量配置
	private boolean isEnableIncrementalAnalysis;
	//缓存的天数
	private int catchDays;
	//目录深度
	private int depth;
}
