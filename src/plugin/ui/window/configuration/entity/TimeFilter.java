package plugin.ui.window.configuration.entity;

import java.util.Calendar;
import java.util.Date;

/**
 * 时间过滤选项
 * @author wlj
 *
 */
public class TimeFilter {
	public TimeFilter(){
		this.startDate=Calendar.getInstance();
		this.endDate=Calendar.getInstance();
	}
	public int timeOption;
	public Calendar startDate;
	public Calendar endDate;
	public int nearestDays;
}
