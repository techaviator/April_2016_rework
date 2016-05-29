package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilityClass {
	
	public static String getpropertyfile(String key) 
	{
		FileInputStream fis = null;
		Properties prop = new Properties();
		try {
			 fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\ConfigFile.properties");
			 prop.load(fis);
			 fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*finally{
		System.out.println("Connection.close");
		}*/
		
		return prop.getProperty(key);		
	}
/*public static void main(String[] args) {
	System.out.println(getpropertyfile("URL"));
}*/
}
