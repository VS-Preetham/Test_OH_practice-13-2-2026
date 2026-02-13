package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.Account_Registration;
import PageObjects.HomePage;
import testBase.BaseTest;

public class TC__01_Account_Registration extends BaseTest{

	
	@Test(groups = {"Regression", "Master"})
	public void test_Acc_Resgitration() throws Exception {
		
		log.info(" *** Account Registration *** ");
		
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clk_MyAcc();
		hp.clk_Reg();
		
		log.info(" *** Clicked on Register *** ");
		Account_Registration accreg = new Account_Registration(driver);
		
		log.info(" *** Entering the Details *** ");
		accreg.Msg_Reg_Acc();
		accreg.enter_Fname("John"+randomAlphabet());
		accreg.enter_Lname(randomAlphabet());
		accreg.enter_email(randomAlphabet()+"@gmail.com");
		accreg.enter_Telephone(randomNum());
		String password = AlphaNumeric();
		accreg.enter_Pass(password);
		accreg.conf_pass(password);
		Thread.sleep(3000);
		accreg.clk_PolicyBtn();
		accreg.clk_Continue();
		
		log.info(" *** Account Created *** ");
		
		String conform_Msg = (String) accreg.get_Conform_Acc_Creation();
		
		if (conform_Msg.equalsIgnoreCase("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			
		} else {
Assert.assertTrue(false);
log.error(" *** Test Failed *** ");
log.debug(" *** Debug logs *** ");

		}
		
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
		log.info(" *** TC__01 Account Resistration completed *** ");
		
	}
	
}
