package generic;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Class {
	
	public WebDriver driver = null;
	@BeforeMethod(groups= {"Smoke","Regression"})
	public void launchbrowser()
	{
		String browsertype = UtilityClass.getpropertyfile("browsertype");
		
		if(browsertype.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", UtilityClass.getpropertyfile("ChromeDriver"));
			driver = new ChromeDriver();
		}
		else if(browsertype.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", UtilityClass.getpropertyfile("IEDriver"));
			driver = new InternetExplorerDriver();
		}
		else if(browsertype.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(UtilityClass.getpropertyfile("URL"));
	}
	
	@AfterMethod(groups= {"Smoke","Regression"})
	public void tear_down()
	{
		driver.quit();
	}
	
	public void getscreenshot(String TCID, String Order)
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		String date1 = format.format(date);
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(UtilityClass.getpropertyfile("snapshot")+TCID+"_"+Order+"_Screenshot_"+date1+".png");
		try {
			FileUtils.copyFile(screenshotAs, file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
