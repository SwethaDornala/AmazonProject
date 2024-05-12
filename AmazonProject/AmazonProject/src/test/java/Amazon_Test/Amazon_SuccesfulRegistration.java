package Amazon_Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Amazon_Source.Amazon_Home_Page;
import Amazon_Source.Amazon_Registration_Page;

@Listeners(AmazonListeners.class)
public class Amazon_SuccesfulRegistration extends LaunchQuit{
	
	@Test
	public void SuccessfullRegistration() throws InterruptedException {
		
		driver.get("https://www.amazon.in");
		Amazon_Home_Page a=new Amazon_Home_Page(driver);
		a.hoveringonAccountsLists(driver);
		a.NewCustomerClickToRegister();
		Assert.assertEquals(driver.getTitle(), "Amazon Registration");
		Amazon_Registration_Page a1=new Amazon_Registration_Page(driver);
		a1.NewCustomerName();
		a1.NewCustomerPhoneNumber();
		a1.NewCustomerPassword();
		a1.VerifyMobileNumber();
        Thread.sleep(50000);
		
	}

}
