package plugin.ui.window.configuration.entity;
/**
 * bug检测配置
 * @author wlj
 *
 */
public class BugDetectionEntity {
	
	public boolean isLimitTime;
	public boolean isReportViolation;
	//缓存的天数
	public int catchDays;
	//目录深度
	public int depth;
	public int levelReportViolation;
}
