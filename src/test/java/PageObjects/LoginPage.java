package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_pass;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btn_Login;
	
	public void enter_Email(String emailk) {
		txt_email.sendKeys(emailk);
	}
	
	public void enter_pwd(String pwdd) {
		txt_pass.sendKeys(pwdd);
	}
	
	public void clk_Login() {
		btn_Login.click();
	}
}
