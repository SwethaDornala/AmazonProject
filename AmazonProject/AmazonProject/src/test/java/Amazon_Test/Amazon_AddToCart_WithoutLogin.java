package Amazon_Test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon_Source.Amazon_Home_Page;
import Amazon_Source.Amazon_ProductDetails_Page;
import Amazon_Source.Amazon_SearchResults_Page;

@Listeners(AmazonListeners.class)
public class Amazon_AddToCart_WithoutLogin extends LaunchQuit {
	
	@Test
	public void NavigateToCartsWithoutLogin()
	{
		driver.get("https://www.amazon.in");
		Assert.assertEquals(driver.getTitle(),"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		Amazon_Home_Page a1=new Amazon_Home_Page(driver);
		a1.searching_product();
		Amazon_SearchResults_Page a2=new Amazon_SearchResults_Page(driver);
		a2.SecondSearchProduct();
		Set<String> Browsers=driver.getWindowHandles();
	    Iterator<String> ParentChild=Browsers.iterator();
	    String parentwindow=ParentChild.next();
	    String childwindow=ParentChild.next();
	    driver.switchTo().window(childwindow);
	    Amazon_ProductDetails_Page a3=new Amazon_ProductDetails_Page(driver);
	    a3.addToCart();
	    Assert.assertEquals(driver.getTitle(), "Amazon.in Shopping Cart");

	}

}
