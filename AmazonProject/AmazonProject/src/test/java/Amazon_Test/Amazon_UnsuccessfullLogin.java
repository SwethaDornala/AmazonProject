package Amazon_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Amazon_Source.Amazon_Login_Page;
import org.testng.annotations.Listeners;

@Listeners(AmazonListeners.class)
public class Amazon_UnsuccessfullLogin extends LaunchQuit {
	
	@Test
	public void UnsuccessfulLogin() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		Amazon_Login_Page a=new Amazon_Login_Page(driver);
		a.email();
		a.continuebutton();
		Assert.assertTrue(a.Verify_PasswordScreen());
		a.invalidpassword();
		a.signin();
		Thread.sleep(10000);
	    Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "Invalid Credentials");

	}

}
