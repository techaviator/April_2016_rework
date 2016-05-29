package dataProviders;

import generic.ExcelReader;
import generic.UtilityClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

public class SearchScenario_DP {
	
	@DataProvider(name = "InvalidSearch_DP")
	public static Object[][] DP_InvalidSearch()
	
	{
		List<String> ls = XLReader("Invalid_Search");
		Object[][] obj = new Object[ls.size()][4];
		
		for(int i = 0; i<ls.size();i++)
		{
			obj[i][0]=ls.get(i).split(";")[0];
			obj[i][1]=ls.get(i).split(";")[1];
			obj[i][2]=ls.get(i).split(";")[2];
			obj[i][3]=ls.get(i).split(";")[3];
		}
		
		return obj;
		
	}
	
	@DataProvider(name = "ValidSearch_DP")
	public static Object[][] DP_ValidSearch()
	
	{
		List<String> ls = XLReader("Valid_Search");
		Object[][] obj = new Object[ls.size()][4];
		
		for(int i = 0; i<ls.size();i++)
		{
			obj[i][0]=ls.get(i).split(";")[0];
			obj[i][1]=ls.get(i).split(";")[1];
			obj[i][2]=ls.get(i).split(";")[2];
			obj[i][3]=ls.get(i).split(";")[3];
		}
		
		return obj;
		
	}
	
	public static List<String> XLReader(String testscript)
	{
		String path = UtilityClass.getpropertyfile("XLpath");
		ExcelReader xl = new ExcelReader(path);
		String sheetname= "Scenario_Search";
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
					String Search_item = xl.readXLcellvalue(sheetname, i, 4);
					String expected = xl.readXLcellvalue(sheetname, i, 5);
					
					ls.add(TCID+";"+Order+";"+Search_item+";"+expected);
				}
			}
		
		}
		
		return ls;
	}

}
