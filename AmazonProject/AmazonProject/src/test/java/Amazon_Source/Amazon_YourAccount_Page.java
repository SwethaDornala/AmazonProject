package Amazon_Source;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_YourAccount_Page {
	
	@FindBy(xpath="//div[@data-card-identifier='SignInAndSecurity']")
	WebElement LoginSecurity_field;
	
	
	
	
	
	public void LoginSecurity()
	{
		LoginSecurity_field.click();
	}
	
	
	
	public Amazon_YourAccount_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
