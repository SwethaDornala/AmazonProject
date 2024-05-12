package Amazon_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_YourOrders_Page {
	
	@FindBy(xpath="(//div[@class='order-card js-order-card'])[2]//div[@class='a-fixed-left-grid-col a-col-left']")
	WebElement LastOrderProduct;
	
	@FindBy(xpath="//span[@id='a-autoid-9']")
	WebElement ProductReview_button;
	
	public void LastOrderedProduct_click()
	{
		LastOrderProduct.click();
	}
	
	public void WriteProductReview_orders()
	{
		ProductReview_button.click();
	}
	public Amazon_YourOrders_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
