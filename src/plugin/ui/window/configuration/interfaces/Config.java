package plugin.ui.window.configuration.interfaces;

import java.util.UUID;

import plugin.ui.window.configuration.entity.ConfigCategoryEnum;
import plugin.ui.window.configuration.entity.ConfigEntity;
import plugin.ui.window.configuration.entity.ConfigItemEntity;
import plugin.ui.window.configuration.persistence.PersistenceContext;
/**
 * 配置类
 * @author wlj
 *
 */
public class Config implements IConfig {

	protected PersistenceContext persistenceContext;
	
	public Config(PersistenceContext persistenceContext){
		this.persistenceContext=persistenceContext;
	}
	
	@Override
	public void newConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		persistenceContext.add(configEntity.configCategory, configEntity);
	}

	@Override
	public void editConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		persistenceContext.update(configEntity.configCategory, configEntity);
	}

	@Override
	public void exportConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Export");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);
	}

	@Override
	public void deleteConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);

	}

	@Override
	public void SetDefault(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("SetDefault");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);
	}

	@Override
	public ConfigEntity getConfig(ConfigCategoryEnum categoryEnum,UUID configID) {
		// TODO Auto-generated method stub
		return persistenceContext.getConfigEntity(categoryEnum, configID);
	}

}
