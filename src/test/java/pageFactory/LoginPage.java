package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy (name="logid")
	WebElement Textbox_logid;
	
	@FindBy (name="pswd")
	WebElement Textbox_pwd;
	
	@FindBy (css="td[class = 'sb1'] input")
	WebElement Button_login;
	
	@FindBy(xpath = "//b[text()='Sorry we were unable to complete this step because :']")
	WebElement Text_invalidlogmsg;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Enter_uname(String uname)
	{
		Textbox_logid.sendKeys(uname);
	}
	
	public void Enter_pwd(String pwd)
	{
		Textbox_pwd.sendKeys(pwd);
	}
	
	public void Click_loginBTN()
	{
		Button_login.click();
	}
	
	public boolean get_invalidloginMSG()
	{
		return Text_invalidlogmsg.isDisplayed();
	}
	


}
