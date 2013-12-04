package plugin.ui.window.configuration.interfaces;

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
	void NewConfig(ConfigItemEntity configEntity);
	/**
	 * 编辑配置项
	 * @param configEntity
	 */
	void EditConfig(ConfigItemEntity configEntity);
	/**
	 * 复制
	 * @param configEntity
	 */
	void CopyConfig(ConfigItemEntity configEntity);
	/**
	 * 导出
	 * @param configEntity
	 */
	void ExportConfig(ConfigItemEntity configEntity);
	/**
	 * 删除配置项
	 * @param configEntity
	 */
	void DeleteConfig(ConfigItemEntity configEntity);
	/**
	 * 将指定配置设置默认
	 * @param configEntity
	 */
	void SetDefault(ConfigItemEntity configEntity);
	
}
