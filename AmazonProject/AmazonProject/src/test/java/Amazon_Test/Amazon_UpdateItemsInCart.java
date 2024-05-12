package Amazon_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon_Source.Amazon_Home_Page;
import Amazon_Source.Amazon_Login_Page;
import Amazon_Source.Amazon_ShoppingCart_Page;

@Listeners(AmazonListeners.class)
public class Amazon_UpdateItemsInCart extends LaunchQuit{
	
	@Test
	public void UpdateItemsInCart() throws EncryptedDocumentException, IOException, InterruptedException
	{
		driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
		
		Amazon_Login_Page a=new Amazon_Login_Page(driver);
		a.email();
		a.continuebutton();
		a.password();
		a.signin();
		Thread.sleep(20000);
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Amazon_Home_Page a1=new Amazon_Home_Page(driver);
        a1.ShoppingCart_Home();
        Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
        Amazon_ShoppingCart_Page a2=new Amazon_ShoppingCart_Page(driver);
        a2.IncreaseProductQuanity_ShoppingCart();
        a2.RemoveProduct_ShoppingCart();
	}

}
