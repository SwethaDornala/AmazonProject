package Amazon_Source;



import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Amazon_Checkout_Page {
	
	String ReviewProductTitle;
	int flag=0;
	
	@FindBy(xpath="//a[@id='addressChangeLinkId']")
	WebElement ChangeDeliveryAddress_link;
	
	@FindBy(xpath="//span[contains(text(),'505405')]")
	WebElement DeliverAddress;
	
	@FindBy(xpath="//span[contains(text(),'505405')]//parent::span//parent::label//input")
	WebElement DeliverAddress_radiobutton;
	
	@FindBy(xpath="//span[@id='shipToThisAddressButton']")
	WebElement UseThisAddress_button;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left'])[6]")
	WebElement Netbanking_PaymentMethod_radiobutton;
	
	@FindBy(xpath="//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")
	WebElement NetBanking_PaymentMethod;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left'])[5]")
	WebElement CreditCard_DebitCard_PaymentMethod_radiobutton;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left'])[7]")
	WebElement OtherUIPApps_PaymentMethod_radiobutton;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left'])[8]")
	WebElement EMI_PaymentMethod_radiobutton;
	
	@FindBy(xpath="(//div[@class='a-fixed-left-grid-col a-col-left'])[9]")
	WebElement CashOnDelivery_PaymentMethod_radiobutton;
	
	@FindBy(xpath="//div[@class='a-fixed-left-grid-inner']//select[@name='ppw-bankSelection_dropdown']")
	WebElement BankSelection_dropdown;
	
	@FindBy(xpath="(//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent'])[1]")
	WebElement UseThisPaymentMethod_button;
	
	@FindBy(xpath="//h3[.='Order Summary']")
	WebElement OrderSummary_Text;
	
	@FindBy(xpath="//div[@aria-label='Review items and delivery']//img")
	List<WebElement> ReviewandDeliveryProduct_Title;
	
	@FindBy(xpath="//input[@name='claimCode']")
	WebElement CouponCode_tf;
	
	@FindBy(xpath="//span[@id='gcApplyButtonId']")
	WebElement CouponCodeApply_button;
	
	public String ValidateProductInOrderReview()
	{
		String ReviewProductTitle="";
		for(int i=0;i<ReviewandDeliveryProduct_Title.size();i++)
		{
		ReviewProductTitle=ReviewProductTitle+ReviewandDeliveryProduct_Title.get(i).getAttribute("alt");
		}
		return ReviewProductTitle;	
	}
	
	
	public void ApplyCouponCode()
	{
		CouponCodeApply_button.click();
	}
	
	public void CouponCodeInput()
	{
		CouponCode_tf.sendKeys("ABC123");
	}
	
	public boolean CheckDeliveryAddressSelection()
	{
		return DeliverAddress_radiobutton.isSelected();
	}
	
	public boolean CheckPaymentMethodSelection()
	{
		return NetBanking_PaymentMethod.isSelected();
	}
	
	public boolean OrderSummary()
	{
		return OrderSummary_Text.isDisplayed();
	}
	
	public void UseThisPaymentMethod()
	{
		UseThisPaymentMethod_button.click();
	}
	
	public void SelectHDFCBank()
	{
		Select s=new Select(BankSelection_dropdown);
		s.selectByVisibleText("HDFC Bank");
	}
	
	public void SelectNetankingPaymentMethod()
	{
		Netbanking_PaymentMethod_radiobutton.click();
	}
	
	public void SelectCreditDebitcardPaymentMethod()
	{
		CreditCard_DebitCard_PaymentMethod_radiobutton.click();
	}
	
	public void SelectUPIAppsPaymentMethod()
	{
		OtherUIPApps_PaymentMethod_radiobutton.click();
	}
	
	public void SelectEMIPaymentMethod()
	{
		EMI_PaymentMethod_radiobutton.click();
	}
	
	public void SelectCashOnDeliveryPaymentMethod()
	{
		CashOnDelivery_PaymentMethod_radiobutton.click();
	}
	
	
	public void UseThisAddress()
	{
		UseThisAddress_button.click();
	}
	
	public void SelectDeliveryAddress()
	{
		DeliverAddress.click();
	}
	
	public void ChangeDeliveryAdress()
	{
		try
		{
		if(ChangeDeliveryAddress_link.isDisplayed())
		{
		ChangeDeliveryAddress_link.click();
		}
		}
	   catch(NoSuchElementException e)
		{
			
		}
	}
	
	
	public Amazon_Checkout_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
