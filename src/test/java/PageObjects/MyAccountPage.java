package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msg_MyAcc;
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement btn_MyAcc;
	
	@FindBy(xpath = "//div[@id='top-links']//li[2]//ul/li[5]")
WebElement clk_LogOut;
	
	
	@FindBy(xpath = "//div[@class='pull-right']")
	WebElement clk_Continue;
	
	public boolean is_MyAcc_exist() {
		try {
			return (msg_MyAcc.isDisplayed());
		} catch (Exception e) {
			
			return false;
		}
	}
	
	public void clk_MyAcc() {
		btn_MyAcc.click();
	}
	
	public void btn_Logout() {
		clk_LogOut.click();
	}
	
	public void btn_Continue() {
		clk_Continue.click();
	}
}
