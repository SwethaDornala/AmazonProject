package Amazon_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_ShoppingCart_Page {
	
	@FindBy(xpath="//form[@id='activeCartViewForm']//div[@data-item-index='1']//select[@id='quantity']")
	WebElement ShoppingCart_FirstProduct_Quanitity;
	
	@FindBy(xpath="//form[@id='activeCartViewForm']//div[@data-item-index='2']//input[@value='Delete']")
	WebElement ShoppingCart_SecondProduct_Delete;
	
	@FindBy(xpath="//input[@name='proceedToRetailCheckout']")
	WebElement ProceedToBuy_button;
	
	public void ProceedToBuy()
	{
		ProceedToBuy_button.click();
	}
	
	public void IncreaseProductQuanity_ShoppingCart()
	{
		Select s=new Select(ShoppingCart_FirstProduct_Quanitity);
		s.selectByVisibleText("4");
	}
	
	public void RemoveProduct_ShoppingCart()
	{
		ShoppingCart_SecondProduct_Delete.click();
	}
	
	public Amazon_ShoppingCart_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
