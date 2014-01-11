package plugin.ui.window.configuration.configtree;

import static org.junit.Assert.*;

import java.util.UUID;

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
		configEntity.id=UUID.randomUUID();
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
		UUID id=UUID.fromString("96eac4f6-63c8-4475-a8b3-67018ebab81e");
		ConfigEntity configEntity=xmlConfigPersistence.getConfigEntity(configCategory, id);
		assertNotNull(configEntity);
		assertEquals("test", configEntity.name);
	}
	
	@Test
	public void updateTest(){
		XmlConfigPersistence xmlConfigPersistence=new XmlConfigPersistence();
		ConfigCategoryEnum configCategory=ConfigCategoryEnum.User;
		UUID id=UUID.fromString("96eac4f6-63c8-4475-a8b3-67018ebab81e");
		ConfigEntity configEntity=xmlConfigPersistence.getConfigEntity(configCategory, id);
		configEntity.name="test1";
		boolean result = xmlConfigPersistence.update(configCategory, configEntity);
		assertTrue(result);
	}
	
	@Test
	public void deleteTest(){
		XmlConfigPersistence xmlConfigPersistence=new XmlConfigPersistence();
		ConfigCategoryEnum configCategory=ConfigCategoryEnum.User;
		UUID id=UUID.fromString("96eac4f6-63c8-4475-a8b3-67018ebab81e");
		boolean result = xmlConfigPersistence.remove(configCategory, id);
		assertTrue(result);
	}

}
