package Amazon_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Registration_Page {
	
	@FindBy(id="ap_customer_name")
	WebElement Customername_tf;
	
	@FindBy(id="ap_phone_number")
	WebElement PhoneNumber_tf;
	
	@FindBy(id="ap_password")
	WebElement Password_tf;
	
	@FindBy(id="continue")
	WebElement VerifyMobileNumber_button;
	
	@FindBy(id="auth-verify-button")
	WebElement CreateAmazonAccount_button;
	
	public void CreateAmazonAccount()
	{
		CreateAmazonAccount_button.click();
	}
	
	public void VerifyMobileNumber()
	{
		VerifyMobileNumber_button.click();
	}
	
	public void NewCustomerName()
	{
		Customername_tf.sendKeys("swetha reddy");
	}
	public void NewCustomerPhoneNumber()
	{
		PhoneNumber_tf.sendKeys("9505922094");
	}
	public void NewCustomerPassword()
	{
		Password_tf.sendKeys("Swetha321@");
	}

	
	public Amazon_Registration_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
