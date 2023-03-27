package Testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.BasePage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass

{

	@Test(groups= {"Regression","Master"})
	public void test_account_Registration() throws InterruptedException
	{
		//try
		//{
		logger.debug("application logs......");
		logger.info("***  Starting TC_001_AccountRegistrationTest ***");
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account link");
		hp.clickRegister();
		logger.info("Clicked on register link");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Providing customer data");
		
         regpage.setFirstName(randomeString().toUpperCase());
		
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");;// randomly generated the email
	
		regpage.setPassword("test@123");
		
		
		WebElement e =driver.findElement(By.xpath("//input[@name='agree']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
		Thread.sleep(500); 
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		//String confmsg=regpage.getConfirmationMsg();
		
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}
		/*catch(Exception e)
		{
			Assert.fail();
		}
	}*/
	
	
	
	
	
	
	
	
	
	
	
	
	
}
