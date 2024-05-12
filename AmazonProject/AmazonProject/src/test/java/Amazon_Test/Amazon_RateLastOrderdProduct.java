package Amazon_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon_Source.Amazon_Home_Page;
import Amazon_Source.Amazon_Login_Page;
import Amazon_Source.Amazon_ProductDetails_Page;
import Amazon_Source.Amazon_ProductReview_Page;
import Amazon_Source.Amazon_YourOrders_Page;

@Listeners(AmazonListeners.class)
public class Amazon_RateLastOrderdProduct extends LaunchQuit {
	
	@Test
	public void RateLastOrderedProduct() throws InterruptedException, EncryptedDocumentException, IOException
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
		a.YourAccounts_Orders();
		Amazon_YourOrders_Page a1=new Amazon_YourOrders_Page(driver);
		//a1.LastOrderedProduct_click();
		Amazon_ProductDetails_Page a3=new Amazon_ProductDetails_Page(driver);
		Thread.sleep(10000);
		a1.WriteProductReview_orders();
		//a3.WriteProductReview(driver);
		Thread.sleep(10000);
		Amazon_ProductReview_Page a4=new Amazon_ProductReview_Page(driver);
		a4.FivestarRating_Review();
		Thread.sleep(1000);

	}
}
