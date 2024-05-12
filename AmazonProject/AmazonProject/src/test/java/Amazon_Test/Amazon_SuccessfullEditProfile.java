package Amazon_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon_Source.Amazon_Home_Page;
import Amazon_Source.Amazon_LoginSecurity_Page;
import Amazon_Source.Amazon_Login_Page;
import Amazon_Source.Amazon_YourAccount_Page;

@Listeners(AmazonListeners.class)
public class Amazon_SuccessfullEditProfile extends LaunchQuit {
	
	@Test
	public void EditProfile() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		Amazon_Login_Page a2=new Amazon_Login_Page(driver);
		a2.email();
		a2.continuebutton();
		a2.password();
		a2.signin();
		Thread.sleep(20000);
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Amazon_Home_Page a=new Amazon_Home_Page(driver);
		a.hoveringonAccountsLists(driver);
		a.YourAccount_AccountsLists();
		Amazon_YourAccount_Page a1=new Amazon_YourAccount_Page(driver);
		a1.LoginSecurity();
		Thread.sleep(20000);
		Amazon_LoginSecurity_Page login1=new Amazon_LoginSecurity_Page(driver);
		login1.EditName();
		login1.UpdateName();
		login1.SaveName();
		login1.EditEmail();
		Thread.sleep(5000);
		login1.EmailAddress();
		login1.Continue();
		Thread.sleep(30000);
		a2.password();
		login1.SaveEmail();
		/*login1.EditMobileNumber();
		login1.MobileNumber();
		login1.continue_MobileNumber();
		login1.Accept_MobileNumberVerifyPopup();
		Thread.sleep(20000);*/
		login1.EditPassword();
		a2.password();
		login1.NewPassword();
		login1.Reenter_Newpassword();
		login1.SavePassword();
		
		
	}

}
