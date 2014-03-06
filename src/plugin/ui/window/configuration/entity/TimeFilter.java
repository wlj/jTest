package plugin.ui.window.configuration.entity;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间过滤选项
 * @author wlj
 *
 */
public class TimeFilter {
	public int timeOption;
	private Date startDate;
	public boolean isEnabledEndDate;
	public Date endDate;
	public boolean isEnableNearestDays;
	public int nearestDays;
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
}
