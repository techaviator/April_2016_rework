package dataProviders;

import generic.ExcelReader;
import generic.UtilityClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class LoginScenario_DP {
	
	@DataProvider(name= "validlogin_DP")
	public static Object[][] DP_validLogin() throws IOException
	{
		
		
		List<String> ls = XLReader("Valid_Login_test");
		Object[][] obj = new Object[ls.size()][5];
		for(int i = 0 ;i<ls.size();i++)
		{
			obj[i][0]=ls.get(i).split(";")[0];
			obj[i][1]=ls.get(i).split(";")[1];
			obj[i][2]=ls.get(i).split(";")[2];
			obj[i][3]=ls.get(i).split(";")[3];
			obj[i][4]=ls.get(i).split(";")[4];
		}		
		
		return obj;
	}
	
	@DataProvider(name= "Invalidlogin_DP")
	public static Object[][] DP_invalidLogin() throws IOException
	{
		
		
		List<String> ls = XLReader("Invalid_Login_test");
		Object[][] obj = new Object[ls.size()][5];
		for(int i = 0 ;i<ls.size();i++)
		{
			obj[i][0]=ls.get(i).split(";")[0];
			obj[i][1]=ls.get(i).split(";")[1];
			obj[i][2]=ls.get(i).split(";")[2];
			obj[i][3]=ls.get(i).split(";")[3];
			obj[i][4]=ls.get(i).split(";")[4];
		}		
		
		return obj;
	}
	
	public static List<String> XLReader(String testscript) throws IOException
	{
		String path = UtilityClass.getpropertyfile("XLpath");
		ExcelReader xl = new ExcelReader(path);
		String sheetname= "Scenario_Login";
		int rowcount = xl.getRowcount(sheetname);
		List<String> ls = new ArrayList<String>();
		for(int i = 1;i<rowcount;i++)
		{
			if(xl.readXLcellvalue(sheetname, i, 3).equalsIgnoreCase(testscript))
			{	
			
				if(xl.readXLcellvalue(sheetname, i, 2).equalsIgnoreCase("Y"))
				{
					String TCID = xl.readXLcellvalue(sheetname, i, 0);
					String Order = xl.readXLcellvalue(sheetname, i, 1);
					String Uname = xl.readXLcellvalue(sheetname, i, 4);
					String Pwd = xl.readXLcellvalue(sheetname, i, 5);
					String expected = xl.readXLcellvalue(sheetname, i, 6);
					ls.add(TCID+";"+Order+";"+Uname+";"+Pwd+";"+expected);
				}
			}
		
		}
		
		return ls;
	}

}
