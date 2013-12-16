package plugin.ui.window.configuration.entity;
/**
 * 未捕获的异常的严重等级
 * @author wlj
 *
 */
public class UncaughtExceptionSeverityLevelEntity {
	//未捕获的异常的名称
	private String name;
	//严重等级
	private SeverityLevelEnum severityLevel;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SeverityLevelEnum getSeverityLevel() {
		return severityLevel;
	}
	public void setSeverityLevel(SeverityLevelEnum severityLevel) {
		this.severityLevel = severityLevel;
	}
}
