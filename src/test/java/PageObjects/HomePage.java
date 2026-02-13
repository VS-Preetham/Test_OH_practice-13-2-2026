package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);		
		}
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement btn_MyAcc;

	
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement btn_Reg;
	
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement btn_Login;
	
	
	public void clk_MyAcc() {
		btn_MyAcc.click();
	}
	
	public void clk_Reg() {
		btn_Reg.click();
	}
	
	public void clk_Login() {
		btn_Login.click();
	}
}
