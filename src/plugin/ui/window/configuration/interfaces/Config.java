package plugin.ui.window.configuration.interfaces;

import plugin.ui.window.configuration.entity.ConfigItemEntity;
/**
 * 配置类
 * @author suntao
 *
 */
public class Config implements IConfig {

	@Override
	public void NewConfig(ConfigItemEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("New");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

	@Override
	public void EditConfig(ConfigItemEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Edit");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

	@Override
	public void CopyConfig(ConfigItemEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Copy");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());

	}

	@Override
	public void ExportConfig(ConfigItemEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Export");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

	@Override
	public void DeleteConfig(ConfigItemEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());

	}

	@Override
	public void SetDefault(ConfigItemEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("SetDefault");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

}
