package testCases;


import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseTest;
public class TC__02_LoginPage extends BaseTest {

	@Test(groups = {"Sanity", "Master"})
	public void test_Login() {
		
		try {
			
			log.info(" *** Check Login Functionality *** ");
			
			HomePage hp = new HomePage(driver);
			hp.clk_MyAcc();
			hp.clk_Login();
			
			log.info(" *** Clicked Login *** ");
			log.info(" *** Enter credentials *** ");
			
			LoginPage lp = new LoginPage(driver);
			lp.enter_Email(prop.getProperty("email"));
			lp.enter_pwd(prop.getProperty("pass"));
			lp.clk_Login();
			
			log.info(" *** Account Logged in *** ");
			
			log.info(" *** Conform Login through My Account Page *** ");
			MyAccountPage map = new MyAccountPage(driver);
			
			boolean target = map.is_MyAcc_exist();
			
			Assert.assertTrue(target);
			map.clk_MyAcc();
			map.btn_Logout();
			map.btn_Continue();
			
		} catch (Exception e) {
			
			log.error(" *** Failed Login *** ");
			Assert.fail();
			
		}
		
		log.info(" *** Login Successfully *** ");
	}
}
