package Amazon_Source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_LoginSecurity_Page {
	
	Workbook w1;
	FileInputStream f1;
	FileOutputStream fileOut;
	String EmailAddress;
	String Password;
	String NewPassword;
	
	{
		try {
			f1=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\AmazonProject\\ExcelFiles\\LoginData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			w1=WorkbookFactory.create(f1);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fileOut = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\AmazonProject\\ExcelFiles\\LoginData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	@FindBy(id="NAME_BUTTON")
	WebElement name_edit_button;
	
	@FindBy(xpath="//input[@id='ap_customer_name']")
	WebElement name_tf;
	
	@FindBy(xpath="//input[@id='cnep_1C_submit_button']")
	WebElement Save_namebutton;
	
	@FindBy(xpath="//input[@id='cnep_1B_submit_button']")
	WebElement SaveEmail_button;
	
	@FindBy(id="EMAIL_BUTTON")
	WebElement EditEmail_button;
	
	@FindBy(xpath="//input[@class='a-input-text a-span12 cvf-widget-input']")
	WebElement EmailAddress_tf;
	
	@FindBy(xpath="//input[@name='cvf_action']")
	WebElement continue_btn;
	
	@FindBy(id="MOBILE_NUMBER_BUTTON")
	WebElement MobileNumber_Edit_Button;
	
	@FindBy(xpath="//input[@id='ap_phone_number']")
	WebElement MobileNumber_tf;
	
	@FindBy(xpath="//input[@id='auth-continue']")
	WebElement Continue_button_MobileNo;
	
	@FindBy(xpath="//button[@id='auth-verification-ok-announce']")
	WebElement OKButton_MobileNoUpdate;
	
	@FindBy(id="PASSWORD_BUTTON")
	WebElement Password_Edit_Button;
	
	@FindBy(id="ap_password_new")
	WebElement NewPswrd_tf;
	
	@FindBy(id="ap_password_new_check")
	WebElement Reenter_Newpassword_tf;
	
	@FindBy(id="cnep_1D_submit_button")
	WebElement SaveButton_Password;
	
	public void SavePassword() throws IOException
	{
		SaveButton_Password.click();
		fileOut = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\AmazonProject\\ExcelFiles\\LoginData.xlsx");
		w1.getSheet("Login_Data").getRow(1).getCell(1).setCellValue(NewPassword);
		w1.write(fileOut);
		fileOut.close();
	}
	
	
	public void NewPassword()
	{
		NewPassword=w1.getSheet("Login_Data").getRow(2).getCell(1).getStringCellValue();
		NewPswrd_tf.sendKeys(NewPassword);
	}
	public void Reenter_Newpassword()
	{
		Reenter_Newpassword_tf.sendKeys(NewPassword);
	}
	public void EditPassword()
	{
		Password_Edit_Button.click();
	}
	
	public void Accept_MobileNumberVerifyPopup()
	{
		OKButton_MobileNoUpdate.click();
	}
	
	public void continue_MobileNumber()
	{
		Continue_button_MobileNo.click();
	}
	
	public void MobileNumber()
	{
		MobileNumber_tf.sendKeys("9502297756");
	}
	
	public void EditMobileNumber()
	{
		MobileNumber_Edit_Button.click();
	}
	
	public void SaveEmail() throws IOException
	{
		SaveEmail_button.click();
		w1.getSheet("Login_Data").getRow(1).getCell(2).setCellValue(EmailAddress);
		fileOut = new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\AmazonProject\\ExcelFiles\\LoginData.xlsx");
     	w1.write(fileOut);
		fileOut.close();

		
	}
	
	public void Continue()
	{
		continue_btn.click();
	}
	
	public void EmailAddress()
	{
		EmailAddress=w1.getSheet("Login_Data").getRow(2).getCell(2).getStringCellValue();
		EmailAddress_tf.sendKeys(EmailAddress);
	}
	
	public void EditEmail()
	{
		EditEmail_button.click();
	}
	
	public void EditName()
	{
		name_edit_button.click();
	}
	
	public void SaveName()
	{
		Save_namebutton.click();
	}
	
	public void UpdateName()
	{
		name_tf.sendKeys(Keys.CONTROL+"A");
		name_tf.sendKeys(Keys.DELETE);
		name_tf.sendKeys("Swetha Reddy");
	}
	
	public Amazon_LoginSecurity_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
