package plugin.ui.window.configuration.interfaces;

import java.util.UUID;

import plugin.ui.window.configuration.entity.*;
/**
 * 配置树
 * @author wlj
 *
 */
public interface IConfig {
	/**
	 * 新建配置项
	 * @param configEntity
	 */
	void newConfig(ConfigEntity configEntity);
	
	ConfigEntity getConfig(ConfigCategoryEnum categoryEnum,UUID configID);
	/**
	 * 编辑配置项
	 * @param configEntity
	 */
	void editConfig(ConfigEntity configEntity);
	
	/**
	 * 导出
	 * @param configEntity
	 */
	void exportConfig(ConfigEntity configEntity);
	/**
	 * 删除配置项
	 * @param configEntity
	 */
	void deleteConfig(ConfigCategoryEnum categoryEnum,String configID);
	/**
	 * 将指定配置设置默认
	 * @param configEntity
	 */
	void SetDefault(ConfigEntity configEntity);
	
}
