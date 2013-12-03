package plugin.ui.window.configuration.entity;
/**
 * 配置实体类
 * @author suntao
 *
 */
public class ConfigEntity {
	/**
	 * 配置名称
	 */
	private String name;
	/**
	 * 配置分类
	 */
	private ConfigCategoryEnum configCategory;
	/**
	 * 获取配置名称
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置配置名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取配置分类
	 * @return
	 */
	public ConfigCategoryEnum getConfigCategory() {
		return configCategory;
	}
	/**
	 * 设置配置分类
	 * @param configCategory
	 */
	public void setConfigCategory(ConfigCategoryEnum configCategory) {
		this.configCategory = configCategory;
	}
}
