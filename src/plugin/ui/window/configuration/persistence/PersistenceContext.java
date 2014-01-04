package plugin.ui.window.configuration.persistence;


import plugin.ui.window.configuration.entity.ConfigCategoryEnum;
import plugin.ui.window.configuration.entity.ConfigEntity;

public class PersistenceContext {
	//持久化策略
	private IConfigPersistence configPersistence;
	/**
	 * 构造函数：创建一个持久化环境
	 * @param configPersistence 持久化策略
	 */
	public PersistenceContext(IConfigPersistence configPersistence){
		this.configPersistence=configPersistence;
	}
	
	/**
	 * 添加一个配置
	 * @param categoryEnum 配置分类
	 * @param configEntity 配置实体
	 * @return
	 */
	public boolean add(ConfigCategoryEnum categoryEnum,ConfigEntity configEntity){
		return this.configPersistence.add(categoryEnum, configEntity);
	}
	/**
	 * 更新配置实体
	 * @param categoryEnum 配置的分类
	 * @param configEntity 配置实体
	 * @return
	 */
	public boolean update(ConfigCategoryEnum categoryEnum,ConfigEntity configEntity){
		return this.configPersistence.update(categoryEnum, configEntity);
	}
	/**
	 * 获取一个配置实体
	 * @param categoryEnum 配置分类
	 * @param configName 配置名称
	 * @return
	 */
	public ConfigEntity getConfigEntity(ConfigCategoryEnum categoryEnum,String configName){
		return this.configPersistence.getConfigEntity(categoryEnum, configName);
	}
	/**
	 * 删除一个配置实体
	 * @param categoryEnum 配置分类
	 * @param configName 配置名称
	 * @return
	 */
	public boolean remove(ConfigCategoryEnum categoryEnum,String configName){
		return this.remove(categoryEnum, configName);
	}
}
