package testscripts;

import generic.Base_Class;

import org.apache.log4j.Logger;
import org.testng.Reporter;
import org.testng.annotations.Test;



import pageFactory.HomePage;
import pageFactory.LoginPage;

public class Login_Scenario_TC extends Base_Class {
	
	@Test(dataProvider="Invalidlogin_DP", dataProviderClass=dataProviders.LoginScenario_DP.class,groups={"Regression"})
	public void Invalid_login_Test(String TCID,String Order, String Uname, String pwd, String expected)
	{
		Reporter.log("The Invalid_login_Test has started");
		Logger log = Logger.getLogger(Login_Scenario_TC.class);
		log.info("The Invalid_login_Test has started");		
		HomePage home = new HomePage(driver);
		home.Click_Signlink();
		LoginPage login = new LoginPage(driver);
		login.Enter_uname(Uname);
		login.Enter_pwd(pwd);
		login.Click_loginBTN();
		
		
		if(!driver.getTitle().equalsIgnoreCase("Buy Books Online | Online Bookstore India | Online Book Shopping | Free Shipping Across India"))
		{
			getscreenshot(TCID,Order);
		}
		boolean displayed = login.get_invalidloginMSG();
		if (displayed==true)
		{
			System.out.println("The Invalid_login_Test test case has passed");
			System.out.println("THe invalid message is "+ expected);
		}
		else 
		{
			log.error("The invalid_login_Test has failed");
			System.out.println("The Invalid_login_Test test case has failed");
		}
		log.info("The invalid_login_TC has completed");
		Reporter.log("The invalid_login_TC has completed");
		/*
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(Uname);
		driver.findElement(By.name("pswd")).sendKeys(pwd);
		driver.findElement(By.cssSelector("td[class = 'sb1'] input")).click();
		boolean displayed = driver.findElement(By.xpath("//b[text()='Sorry we were unable to complete this step because :']")).isDisplayed();
		if (displayed==true)
		{
			System.out.println("The Invalid_login_Test test case has passed");
			System.out.println("THe invalid message is "+ expected);
		}
		else 
		{
			System.out.println("The Invalid_login_Test test case has failed");
		}
		driver.close();*/
		
	}
	
	
	@Test(dataProvider = "validlogin_DP", dataProviderClass= dataProviders.LoginScenario_DP.class, groups={"Smoke","Regression"})
	public void Valid_login_Test(String TCID,String Order, String Uname, String pwd, String expected)
	{
		Reporter.log("The valid_login_Test has started");
		Logger log = Logger.getLogger(Login_Scenario_TC.class);
		log.info("The valid_login_Test has started");
		HomePage home = new HomePage(driver);
		home.Click_Signlink();
		LoginPage login = new LoginPage(driver);
		login.Enter_uname(Uname);
		login.Enter_pwd(pwd);
		login.Click_loginBTN();
		String actual = home.get_validLoginMSG();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The valid_login_test has passed");
		}
		else
		{
			log.error("The valid_login_Test has failed");
			System.out.println("The valid_login_test has failed");
		}
		
		
		/*driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.name("logid")).sendKeys(Uname);
		driver.findElement(By.name("pswd")).sendKeys(pwd);
		driver.findElement(By.cssSelector("td[class = 'sb1'] input")).click();
		String actual = driver.findElement(By.xpath("//a[@href='http://mypage.rediff.com/profile/myprofile']")).getText();
		if(actual.equalsIgnoreCase(expected))
		{
			System.out.println("The valid_login_test has passed");
		}
		else
		{
			System.out.println("The valid_login_test has failed");
		}
		driver.close();*/
		log.info("The valid_login_Test has completed");
		Reporter.log("The valid_login_Test has completed");
	}


}
