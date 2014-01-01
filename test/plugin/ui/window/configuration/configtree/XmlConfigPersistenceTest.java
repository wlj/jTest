package plugin.ui.window.configuration.configtree;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import plugin.ui.window.configuration.entity.ConfigCategoryEnum;
import plugin.ui.window.configuration.entity.ConfigEntity;
import plugin.ui.window.configuration.entity.ScopeEntity;
import plugin.ui.window.configuration.persistence.XmlConfigPersistence;

public class XmlConfigPersistenceTest {

	
	@Test
	public void addTest() {
		XmlConfigPersistence xmlConfigPersistence=new XmlConfigPersistence();
		ConfigEntity configEntity=new ConfigEntity();
		configEntity.name="test";
		configEntity.scope=new ScopeEntity();
		configEntity.scope.cyclomaticComplexity=5;
		boolean result=xmlConfigPersistence.add(ConfigCategoryEnum.User, configEntity);
		assertTrue(result);
	}
	
	@Test
	public void getTest(){
		XmlConfigPersistence xmlConfigPersistence=new XmlConfigPersistence();
		ConfigCategoryEnum configCategory=ConfigCategoryEnum.User;
		String name="test";
		ConfigEntity configEntity=xmlConfigPersistence.getConfigEntity(configCategory, name);
		assertNotNull(configEntity);
		assertEquals("test", configEntity.name);
	}
	
	@Test
	public void updateTest(){
		XmlConfigPersistence xmlConfigPersistence=new XmlConfigPersistence();
		ConfigCategoryEnum configCategory=ConfigCategoryEnum.User;
		String name="test";
		ConfigEntity configEntity=xmlConfigPersistence.getConfigEntity(configCategory, name);
		configEntity.name="test1";
		boolean result = xmlConfigPersistence.update(configCategory, configEntity);
		assertTrue(result);
	}
	
	@Test
	public void deleteTest(){
		XmlConfigPersistence xmlConfigPersistence=new XmlConfigPersistence();
		ConfigCategoryEnum configCategory=ConfigCategoryEnum.User;
		String name="test1";
		boolean result = xmlConfigPersistence.remove(configCategory, name);
		assertTrue(result);
	}

}
