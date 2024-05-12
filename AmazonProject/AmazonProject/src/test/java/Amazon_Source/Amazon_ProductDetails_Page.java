package Amazon_Source;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_ProductDetails_Page {
	
	@FindBy(xpath="//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@class='a-price-whole']")
	WebElement ProductPrice_text;
	
	@FindBy(xpath="//div[@id='productFactsDesktop_feature_div']//span[@class='a-color-base']")
	List<WebElement> ProductDetails_text;
	
	@FindBy(xpath="//span[@id='a-autoid-34']")
	WebElement WriteProductReview_button;
	
	@FindBy(xpath="//div[@id='averageCustomerReviews']//span[@class='a-size-base a-color-base']")
	WebElement CustomerRatingunderReviews_Product;
	
	@FindBy(xpath="//div[@id='averageCustomerReviews']")
	WebElement Product_AvgCustomerReviews;
	
	@FindBy(xpath="//div[@id='cm-cr-dp-review-list']//a[@data-hook='review-title']//span")
	List<WebElement> CustomerReviewunderReviews_Product;
	
	@FindBy(id="add-to-cart-button")
	WebElement AddToCart_Button;
	
	public void WriteProductReview(WebDriver driver)
	{
		WriteProductReview_button.click();
	}
	
	public void addToCart()
	{
		AddToCart_Button.click();
	}
	
	public boolean AvgCustomerReviews()
	{
		return Product_AvgCustomerReviews.isDisplayed();
	}
	
	public String VerifyCustomerReviewForProduct()
	{
		String reviews="";
		if(CustomerReviewunderReviews_Product.size()>0)
		{
			for(int i=0;i<CustomerReviewunderReviews_Product.size();i++)
			{
		      reviews=reviews+CustomerReviewunderReviews_Product.get(i).getText();
			}
			return reviews;
		}
		else
		{
			return null;
		}
		
	}
	
	public String VerifyCustomerRatingForProduct()
	{
		return CustomerRatingunderReviews_Product.getText();
	}
	
	public String VerifyProductDetails()
	{
		String ProductDetails="";
		if(ProductDetails_text.size()>0)
		{
			for(int i=0;i<ProductDetails_text.size();i++)
			{
				ProductDetails=ProductDetails+ProductDetails_text.get(i).getText();
			}
			return ProductDetails;
		}
		else
		{
			return null;
		}
		
	}
	
	public String VerifyProductPrice()
	{
		return ProductPrice_text.getText();
	}
	
	public Amazon_ProductDetails_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
