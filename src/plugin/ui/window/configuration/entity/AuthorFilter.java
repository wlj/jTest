package plugin.ui.window.configuration.entity;
/**
 * 作者过滤选项
 * @author wlj
 *
 */
public class AuthorFilter {
	private int authorOption;
	public int getAuthorOption() {
		return authorOption;
	}
	public void setAuthorOption(int authorOption) {
		this.authorOption = authorOption;
	}
	private String[] authorNames;
	/**
	 * 获取设置的作者名称
	 * @return
	 */
	public String[] getAuthorNames() {
		return authorNames;
	}
	/**
	 * 设置作者的名称
	 * @param authorNames
	 */
	public void setAuthorNames(String[] authorNames) {
		this.authorNames = authorNames;
	}
}
