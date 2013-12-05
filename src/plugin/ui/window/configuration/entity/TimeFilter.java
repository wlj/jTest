package plugin.ui.window.configuration.entity;

import java.util.Date;

/**
 * 时间过滤选项
 * @author wlj
 *
 */
public class TimeFilter {
	private int timeOption;
	private Date startDate;
	private Date endDate;
	private int nearestDays;
	public int getTimeOption() {
		return timeOption;
	}
	public void setTimeOption(int timeOption) {
		this.timeOption = timeOption;
	}
	/**
	 * 获取开始时间
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * 设置开始时间
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * 获取结束时间
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * 获取结束时间
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	/**
	 * 获取最近的天数设置
	 * @return
	 */
	public int getNearestDays() {
		return nearestDays;
	}
	/**
	 * 设置最近的天数
	 * @param nearestDays
	 */
	public void setNearestDays(int nearestDays) {
		this.nearestDays = nearestDays;
	}
}
