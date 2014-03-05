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
		if(this.startDate==null){
			this.startDate=Calendar.getInstance();
		}
		if(this.endDate==null){
			this.endDate=Calendar.getInstance();
		}
	}
	public int timeOption;
	public Calendar startDate;
	public boolean isEnabledEndDate;
	public Calendar endDate;
	public boolean isEnableNearestDays;
	public int nearestDays;
}
