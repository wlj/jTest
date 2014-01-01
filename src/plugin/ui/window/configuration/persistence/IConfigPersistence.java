package plugin.ui.window.configuration.persistence;

import plugin.ui.window.configuration.entity.*;

/**
 * 配置持久化接口
 * @author wlj
 *
 */
public interface IConfigPersistence {
	/**
	 * 添加配置文件
	 * @param categoryEnum 配置的分类
	 * @param configEntity 配置实体
	 * @return
	 */
	boolean add(ConfigCategoryEnum categoryEnum,ConfigEntity configEntity);
	/**
	 * 更新配置实体
	 * @param categoryEnum 配置的分类
	 * @param configEntity 配置实体
	 * @return
	 */
	boolean update(ConfigCategoryEnum categoryEnum,ConfigEntity configEntity);
	/**
	 * 获取配置信息
	 * @param categoryEnum 配置分类
	 * @param configName 配置名称
	 * @return
	 */
	ConfigEntity getConfigEntity(ConfigCategoryEnum categoryEnum,String configName);
	/**
	 * 删除配置文件
	 * @param categoryEnum 配置分类
	 * @param configName 配置名称
	 * @return
	 */
	boolean remove(ConfigCategoryEnum categoryEnum,String configName);
}
