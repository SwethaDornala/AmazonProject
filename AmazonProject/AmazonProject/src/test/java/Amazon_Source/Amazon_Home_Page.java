package Amazon_Source;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Home_Page {
	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement AccountsLists;
	
	@FindBy(xpath="//span[@id='nav-cart-count']")
	WebElement AccountShoppingCart;
	
	@FindBy(xpath="//span[.='Your Account']")
	WebElement YourAccount;
	
	@FindBy(xpath="(//a[.='Start here.'])[1]")
	WebElement NewCustomerClickhere_link;
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchproduct_tf;
	
	@FindBy(xpath="//span[.='Your Orders']")
	WebElement YourOrders;
	
	public void NewCustomerClickToRegister()
	{
		NewCustomerClickhere_link.click();
	}
	
	public void YourAccounts_Orders()
	{
		YourOrders.click();
	}
	
	public void ShoppingCart_Home()
	{
		AccountShoppingCart.click();
	}
	
	public void searching_product()
	{
		searchproduct_tf.sendKeys("Shoe");
		searchproduct_tf.sendKeys(Keys.ENTER);
	}
	
	public void hoveringonAccountsLists(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(AccountsLists).perform();
	}
	
	public void YourAccount_AccountsLists()
	{
		YourAccount.click();
	}
	
	public Amazon_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
