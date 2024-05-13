package Amazon_Source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_Login_Page {
	Workbook w1;
	FileInputStream f1;
	String Valid_Password;
	String Valid_Username;
	String Invalid_Password;
	String Invalid_Username;
	
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
	}
   

	
	
	
	@FindBy(id="ap_email")
	WebElement email_tf;
	
	@FindBy(id="ap_password")
	WebElement password_tf;
	
	@FindBy(id="continue")
	WebElement cntn_button;
	
	@FindBy(id="signInSubmit")
	WebElement signin_button;
	
	
	public void email() throws EncryptedDocumentException, IOException
	{
		Valid_Username=NumberToTextConverter.toText(w1.getSheet("Login_Data").getRow(1).getCell(0).getNumericCellValue());
		email_tf.sendKeys(Valid_Username);
	}
	public void password()
	{
		Valid_Password=w1.getSheet("Login_Data").getRow(1).getCell(1).getStringCellValue();
		password_tf.sendKeys(Valid_Password);
	}
	public void invalidemail()
	{
		Invalid_Username=NumberToTextConverter.toText(w1.getSheet("Login_Data").getRow(2).getCell(0).getNumericCellValue());
		email_tf.sendKeys(Invalid_Username);
	}
	public void invalidpassword()
	{
		Invalid_Password="GroTechminds@123";
		password_tf.sendKeys(Invalid_Password);
	}
	public void continuebutton()
	{
		cntn_button.click();
	}
	
	public void signin()
	{
		signin_button.click();
	}
	
	public boolean Verify_PasswordScreen()
	{
		return password_tf.isDisplayed();
	}
	
	public Amazon_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
