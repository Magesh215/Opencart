package Testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.Loginpage;
import PageObjects.Myaccountpage;
import TestBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
 {

	
	@Test(groups= {"Sanity","Master"})
	public void test_Login()
	{
		logger.info("Starting TC_002_LoginTest");
		
		try
		{				
			HomePage hp=new HomePage(driver);
			
			hp.clickMyAccount();
						
			hp.clickLogin();
			
			Loginpage lp=new Loginpage(driver);
			
			lp.setEmail(rb.getString("email")); // valid email, get it from properties file
			
			lp.setPassword(rb.getString("password")); // valid password, get it from properties file
			
			lp.clickLogin();
			
			Myaccountpage macc=new Myaccountpage(driver);
			
			boolean targetpage=macc.isMyAccountPageExists();
						
			Assert.assertEquals(targetpage, true);
			
		}	
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info(" Finished TC_002_LoginTest");
		
	}
}
