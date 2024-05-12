	package Amazon_Test;

	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Set;

	import org.apache.poi.EncryptedDocumentException;
	import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

	import Amazon_Source.Amazon_Checkout_Page;
	import Amazon_Source.Amazon_Home_Page;
	import Amazon_Source.Amazon_Login_Page;
	import Amazon_Source.Amazon_ProductDetails_Page;
	import Amazon_Source.Amazon_SearchResults_Page;
	import Amazon_Source.Amazon_ShoppingCart_Page;

	@Listeners(AmazonListeners.class)
	public class Amazon_ApplyCouponCode extends LaunchQuit {
		
		@Test
		
		public void ProductCheckoutProcess() throws EncryptedDocumentException, IOException, InterruptedException
		{
			boolean OrderReviewProductCheck=false;
			 driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_signin&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
				
				Amazon_Login_Page a=new Amazon_Login_Page(driver);
				a.email();
				a.continuebutton();
				a.password();
				a.signin();
				Thread.sleep(20000);
				Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
			Amazon_Home_Page a1=new Amazon_Home_Page(driver);
			a1.searching_product();
			Assert.assertEquals(driver.getTitle(), "Amazon.in : Shoe");
			Amazon_SearchResults_Page a2=new Amazon_SearchResults_Page(driver);
			String ProductTitle=a2.getProductImageTitle();
			System.out.println(ProductTitle);
			a2.SecondSearchProduct();
			Set<String> Browsers=driver.getWindowHandles();
		    Iterator<String> ParentChild=Browsers.iterator();
		    String parentwindow=ParentChild.next();
		    String childwindow=ParentChild.next();
		    driver.switchTo().window(childwindow);
		    Amazon_ProductDetails_Page a3=new Amazon_ProductDetails_Page(driver);
		    a3.addToCart();
		    Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");
		    Amazon_ShoppingCart_Page a4=new Amazon_ShoppingCart_Page(driver);
		    a4.ProceedToBuy();
		    Amazon_Checkout_Page a5=new Amazon_Checkout_Page(driver);
		    a5.ChangeDeliveryAdress();
		    Thread.sleep(10000);
		    a5.SelectDeliveryAddress();
		   Thread.sleep(10000);
		    a5.UseThisAddress();
		    Thread.sleep(20000);
		    a5.SelectNetankingPaymentMethod();
		    a5.SelectHDFCBank();
		    Assert.assertTrue(a5.OrderSummary());
		    Thread.sleep(10000);
		    a5.UseThisPaymentMethod();
		    Thread.sleep(20000);
		    a5.CouponCodeInput();
		    a5.ApplyCouponCode();
		    Thread.sleep(10000);

		}

	


}
