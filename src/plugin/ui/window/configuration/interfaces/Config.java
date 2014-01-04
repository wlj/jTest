package plugin.ui.window.configuration.interfaces;

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
	public void NewConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("New");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);
		persistenceContext.add(configEntity.configCategory, configEntity);
	}

	@Override
	public void EditConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Edit");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);
	}

	@Override
	public void CopyConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Copy");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);

	}

	@Override
	public void ExportConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Export");
		System.out.println(configEntity.configCategory);
		System.out.println(configEntity.name);
	}

	@Override
	public void DeleteConfig(ConfigEntity configEntity) {
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

}
