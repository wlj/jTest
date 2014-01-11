package plugin.ui.window.configuration.persistence;



import java.io.*;
import java.util.UUID;

import plugin.ui.window.configuration.entity.ConfigCategoryEnum;
import plugin.ui.window.configuration.entity.ConfigEntity;
import plugin.util.Const;

import javax.xml.bind.*;

import org.apache.commons.io.IOUtils;
/**
 * 配置持久化到xml中
 * @author wlj
 *
 */
public class XmlConfigPersistence implements IConfigPersistence {

	private final String usrPath=Const.rootPath;
	@Override
	public boolean add(ConfigCategoryEnum categoryEnum,
			ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		String pathName=usrPath+"\\"+categoryEnum.toString();
		File path=new File(pathName);
		if(path.exists()==false){
			path.mkdir();
		}
		String fileName=configEntity.id+".xml";
		File file=new File(path,fileName);
		try {
			file.createNewFile();
			JAXBContext context=JAXBContext.newInstance(ConfigEntity.class);
			Marshaller jaxbMarshaller = context.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(configEntity, file);  
	        jaxbMarshaller.marshal(configEntity, System.out); 
	        return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		//return false;
	}

	@Override
	public boolean update(ConfigCategoryEnum categoryEnum,
			ConfigEntity configEntity) {
		// TODO Auto-generated method stub
		String pathName=usrPath+"\\"+categoryEnum.toString();
		File path=new File(pathName);
		if(path.exists()==false){
			path.mkdir();
		}
		String fileName=configEntity.id+".xml";
		File file=new File(path,fileName);
		try {
			file.createNewFile();
			JAXBContext context=JAXBContext.newInstance(ConfigEntity.class);
			Marshaller jaxbMarshaller = context.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(configEntity, file);  
	        jaxbMarshaller.marshal(configEntity, System.out); 
	        return true;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ConfigEntity getConfigEntity(ConfigCategoryEnum categoryEnum,
			UUID configId) {
		// TODO Auto-generated method stub
		String pathName=usrPath+"\\"+categoryEnum.toString()+"\\"+configId+".xml";
		File file=new File(pathName);
		if(!file.exists()){
			return null;
		}
		try {
			InputStream is = new FileInputStream(file);
			String content = IOUtils.toString(is);
			JAXBContext ctx = JAXBContext.newInstance(ConfigEntity.class);
			Unmarshaller um = ctx.createUnmarshaller();
			ConfigEntity configEntity = (ConfigEntity) um.unmarshal(new StringReader(content));
			return configEntity;
		} catch (IOException | JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean remove(ConfigCategoryEnum categoryEnum, UUID configId) {
		// TODO Auto-generated method stub
		String pathName=usrPath+"\\"+categoryEnum.toString()+"\\"+configId+".xml";
		File file=new File(pathName);
		if(!file.exists()){
			return false;
		}
		return file.delete();
	}

}
