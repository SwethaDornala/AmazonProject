package Amazon_Source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_ProductReview_Page {
	
	@FindBy(xpath="//img[@alt='select to rate item five star.']")
	WebElement FiveStarRating;
	
	public void FivestarRating_Review()
	{
		FiveStarRating.click();
	}
	public Amazon_ProductReview_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
