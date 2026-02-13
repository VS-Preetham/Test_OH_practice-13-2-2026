package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import testBase.BaseTest;

public class TC__03_DDT_LoginPage extends BaseTest{

	@Test(dataProvider = "LoginData", dataProviderClass = utilities.DataPros.class, groups = {"Master", "DDT"})
public void test_LoginPage(String email, String pass, String exp) {
	
		log.info(" *** DDT Testing Login Page *** ");
		try {
			
			log.info(" *** launch Application *** ");
			
			HomePage hp = new HomePage(driver);
			hp.clk_MyAcc();
			hp.clk_Login();
			
			LoginPage lp = new LoginPage(driver);
			lp.enter_Email(email);
			lp.enter_pwd(pass);
			lp.clk_Login();
			
			MyAccountPage map = new MyAccountPage(driver);
			boolean target = map.is_MyAcc_exist();
			
			if(exp.equalsIgnoreCase("valid")) {
				if(target==true) {
					map.clk_MyAcc();
				map.btn_Logout();
				Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("invalid")) {
				if(target==true) {
					map.clk_MyAcc();
				map.btn_Logout();
				Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		
			map.btn_Continue();
			
		} catch (Exception e) {
			Assert.fail();
		}
		log.info(" *** Finished TC__03 DDT *** ");
		}
	
}
