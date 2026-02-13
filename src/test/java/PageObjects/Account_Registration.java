package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

public class Account_Registration extends BasePage{

	public Account_Registration(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h1[text()='Register Account']")
	WebElement conform_Reg_Acc;
	
	@FindBy(xpath = "//input[@name='firstname']")
	WebElement txt_FirstName;
	
	@FindBy(xpath = "//input[@name='lastname']")
	WebElement txt_LastName;
	
	@FindBy(xpath = "//input[@name='email']")
	WebElement txt_email;
	
	@FindBy(xpath = "//input[@name='telephone']")
	WebElement txt_Telephone;
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txt_pass;
	
	@FindBy(xpath = "//input[@name='confirm']")
	WebElement cnfm_pass;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement btn_agree;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement clk_submit;
	
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msg_acc_creation;
	
	public void Msg_Reg_Acc() {
		String exp_txt = conform_Reg_Acc.getText();
	Assert.assertEquals(exp_txt, "Register Account");	
	}
	
	public void enter_Fname(String fname) {
		txt_FirstName.sendKeys(fname);
	}
	
	
	public void enter_Lname(String Lname) {
		txt_LastName.sendKeys(Lname);
	}
	
	public void enter_email(String email) {
		txt_email.sendKeys(email);
	}
	
	public void enter_Telephone(String num) {
		txt_Telephone.sendKeys(num);
	}
	
	public void enter_Pass(String pwd) {
		txt_pass.sendKeys(pwd);
	}
	
	public void conf_pass(String cpwd) {
		cnfm_pass.sendKeys(cpwd);
	}
	
	
	public void clk_PolicyBtn() {
		btn_agree.click();
	}
	
	public void clk_Continue() {
		clk_submit.click();
	}
	
	public String get_Conform_Acc_Creation() {
return		msg_acc_creation.getText();
	}
	
}
