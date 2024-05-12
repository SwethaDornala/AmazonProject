package Amazon_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon_Source.Amazon_Home_Page;
import Amazon_Source.Amazon_Login_Page;
import Amazon_Source.Amazon_SearchResults_Page;

@Listeners(AmazonListeners.class)
public class Amazon_SearchProductsWithFilters extends LaunchQuit {
	
	@Test
	public void SearchWithFilters() throws EncryptedDocumentException, IOException, InterruptedException
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
		a.searching_product();
		Amazon_SearchResults_Page a1=new Amazon_SearchResults_Page(driver);
		a1.MenSportsOutDoorShoes_CategorySearch();
		a1.MenRunningShoes_Category();
		Assert.assertTrue(a1.MenRunningShoes_Category());
		Assert.assertEquals(driver.getTitle(), "Amazon.in : Shoe");
		a1.PriceRangeSearch_1000tTo2500();
		Thread.sleep(2000);
		a1.LowPriceInput();
		a1.HighPriceInput();
		Assert.assertTrue(a1.LowPriceInput());
		Assert.assertTrue(a1.HighPriceInput());

	}

}
