package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtility {
	public String getData(String key) throws Exception{
		FileInputStream fis=new FileInputStream("./src/test/resources/vtigerpropertyFile.properties");
		//Create Object for properties class to read data based on key
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
}