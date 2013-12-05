package plugin.ui.window.configuration.entity;
/**
 * 度量指标项
 * @author wlj
 *
 */
public class MetricItem {
	private String name;
	private int level;
	private String AcceptableRanges;
	/**
	 * 获取度量指标项的名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置度量指标项的名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取度量指标项的级别
	 * @return
	 */
	public int getLevel() {
		return level;
	}
	/**
	 * 设置度量指标项的级别
	 * @param level
	 */
	public void setLevel(int level) {
		this.level = level;
	}
	/**
	 * 
	 * @return
	 */
	public String getAcceptableRanges() {
		return AcceptableRanges;
	}
	public void setAcceptableRanges(String acceptableRanges) {
		AcceptableRanges = acceptableRanges;
	}
	
	
}
