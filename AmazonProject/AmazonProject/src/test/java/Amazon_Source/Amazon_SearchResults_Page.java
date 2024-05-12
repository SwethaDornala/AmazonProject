package Amazon_Source;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_SearchResults_Page {
	
	@FindBy(xpath="//li[@id='n/1983519031']//a")
	WebElement MenSportsOutDoorShoes_option;
	
	@FindBy(xpath="//span[.='₹1,000 - ₹2,500']")
	WebElement PriceRange1000To2500_option;
	
	@FindBy(xpath="//input[@value='1,000' and @id='low-price']")
	WebElement LowPrice_tf;
	
	@FindBy(xpath="//input[@value='2,500' and @id='high-price']")
	WebElement HighPrice_tf;
	
	@FindBy(xpath="//li[@id='n/1983550031']//a")
	WebElement MenRunningShoes;
	
	@FindBy(xpath="//div[@data-index='4']//a//img")
	WebElement SecondShoe_product;
	
	@FindBy(id="s-result-sort-select")
	WebElement sort_Dropdown;
	
	public String getProductImageTitle()
	{
		return SecondShoe_product.getAttribute("alt");
	}
	public void Sort_products_NewArrivals()
	{
		Select s=new Select(sort_Dropdown);
		s.selectByVisibleText("Newest Arrivals");
	}
	public void Sort_products_Featured()
	{
		Select s=new Select(sort_Dropdown);
		s.selectByVisibleText("Featured");
	}
	public void Sort_products_LowToHighPrice()
	{
		Select s=new Select(sort_Dropdown);
		s.selectByVisibleText("Price: Low to High");
	}
	public void Sort_products_HighToLowPrice()
	{
		Select s=new Select(sort_Dropdown);
		s.selectByVisibleText("Price: High to Low");
	}
	public void Sort_products_AvgCustomerRating()
	{
		Select s=new Select(sort_Dropdown);
		s.selectByVisibleText("Avg. Customer Review");
	}
	public void SecondSearchProduct()
	{
		SecondShoe_product.click();
	}
	
	public boolean MenRunningShoes_Category()
	{
		return MenRunningShoes.isDisplayed();
	}
	
	public void MenSportsOutDoorShoes_CategorySearch()
	{
		MenSportsOutDoorShoes_option.click();
	}
	
	public boolean HighPriceInput()
	{
		return HighPrice_tf.isDisplayed();
		
	}
	
	public boolean LowPriceInput()
	{
		return LowPrice_tf.isDisplayed();
	}
	
	public void PriceRangeSearch_1000tTo2500()
	{
		PriceRange1000To2500_option.click();
	}
	
	public Amazon_SearchResults_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
