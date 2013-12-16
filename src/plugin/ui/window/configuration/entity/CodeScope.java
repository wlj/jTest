package plugin.ui.window.configuration.entity;
/**
 * 代码过滤
 * @author wlj
 *
 */
public class CodeScope extends ScopeBase {
	
	private TimeFilter timeFilter;
	private AuthorFilter authorFilter;
	/**
	 * 获取时间过滤选项
	 * @return
	 */
	public TimeFilter getTimeFilter() {
		return timeFilter;
	}
	/**
	 * 设置时间过滤选项
	 * @param timeFilter
	 */
	public void setTimeFilter(TimeFilter timeFilter) {
		this.timeFilter = timeFilter;
	}
	
	/**
	 * 获取作者过滤选项
	 * @return
	 */
	public AuthorFilter getAuthorFilter() {
		return authorFilter;
	}
	/**
	 * 设置作者过滤选项设置
	 * @param authorFilter
	 */
	public void setAuthorFilter(AuthorFilter authorFilter) {
		this.authorFilter = authorFilter;
	}

	@Override
	public boolean isFilter(String path) {
		// TODO Auto-generated method stub
		return false;
	}

}
