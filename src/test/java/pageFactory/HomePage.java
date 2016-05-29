package pageFactory;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	
	@FindBy (id= "find")
	WebElement valid_searchmsg;
	
	@FindBy (className= "sorrymsg")
	WebElement Invalid_searchmsg;
	
	@FindBy (id= "srchword")
	WebElement Search_textbox;
	
	@FindBy (className= "newsrchbtn")
	WebElement Search_button;
	
	
	@FindBy (linkText="Sign In")
	WebElement Home_SignInLink;
	
	@FindBy (xpath="//a[@href='http://mypage.rediff.com/profile/myprofile']")
	WebElement Home_validloginMsg;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Click_Signlink()
	{
		Home_SignInLink.click();
	}
	
	public String get_validLoginMSG()
	{
		return Home_validloginMsg.getText();
	}
	
	public void Enter_SearchItem(String searchitem)
	{
		Search_textbox.sendKeys(searchitem);
	}
	

	public void Click_Searchbutton()
	{
		Search_button.click();
	}
	
	public String getInvalidSearchMSG()
	{
		return Invalid_searchmsg.getText();
	}
	
	public String getvalidSearchMSG()
	{
		return valid_searchmsg.getText();
	}
	
	
}
