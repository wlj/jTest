package plugin.ui.window.configuration.interfaces;

import plugin.ui.window.configuration.entity.ConfigEntity;
/**
 * 配置类
 * @author suntao
 *
 */
public class Config implements IConfig {

	@Override
	public void NewConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("New");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

	@Override
	public void EditConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Edit");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

	@Override
	public void CopyConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Copy");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());

	}

	@Override
	public void ExportConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Export");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

	@Override
	public void DeleteConfig(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("Delete");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());

	}

	@Override
	public void SetDefault(ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		System.out.println("SetDefault");
		System.out.println(configEntity.getConfigCategory());
		System.out.println(configEntity.getName());
	}

}
