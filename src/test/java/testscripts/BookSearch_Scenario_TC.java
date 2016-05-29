package testscripts;

import generic.Base_Class;

import org.testng.annotations.Test;

import pageFactory.HomePage;



public class BookSearch_Scenario_TC extends Base_Class {
	
	
	@Test(dataProvider= "InvalidSearch_DP",dataProviderClass=dataProviders.SearchScenario_DP.class)
	public void Invalid_Search_Test(String TCID, String Order, String SearchItem,String expected)
	{
		HomePage home = new HomePage(driver);
		
		home.Enter_SearchItem(SearchItem);
		home.Click_Searchbutton();
		String actual = home.getInvalidSearchMSG();
		
		/*
		driver.findElement(By.id("srchword")).sendKeys(SearchItem);
		driver.findElement(By.className("newsrchbtn")).click();
		String actual = driver.findElement(By.className("sorrymsg")).getText();*/
		//actual = actual.split("'")[0];
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The test case Invalid_Search_Test has passed ");
			System.out.println(actual);
		}
		else
		{
			System.out.println("The test case Invalid_Search_Test has failed ");
			System.out.println(actual);
		}
	}
	
	@Test(dataProvider= "ValidSearch_DP",dataProviderClass=dataProviders.SearchScenario_DP.class)
	public void Valid_Search_Test(String TCID, String Order, String SearchItem,String expected)
	{
		HomePage home = new HomePage(driver);
		home.Enter_SearchItem(SearchItem);
		home.Click_Searchbutton();
		String actual = home.getvalidSearchMSG();
		/*driver.findElement(By.id("srchword")).sendKeys(SearchItem);
		driver.findElement(By.className("newsrchbtn")).click();
		String actual = driver.findElement(By.id("find")).getText();*/
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The test case Valid_Search_Test has passed ");
			System.out.println(actual);
		}
		else
		{
			System.out.println("The test case Valid_Search_Test has failed ");
			System.out.println(actual);
		}
	}
	
	

}
