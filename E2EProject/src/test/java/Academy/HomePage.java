package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import objectRepositories.ForgotPassword;
import objectRepositories.LoginPage;
import resources.Base;

public class HomePage extends Base{

	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void BrowserNavigation() throws IOException
	{
		driver=InitializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void BasePageNavigation(String username, String password) throws IOException
	{
		String urlName = prop.getProperty("url");
		driver.get(urlName);
		LoginPage lpg = new LoginPage(driver);
		lpg.ClickLogin().click();;
		lpg.getUser().sendKeys(username);
		lpg.getPass().sendKeys(password);
		lpg.CLickSubmit().click();
		log.info("User is able to pass the username, password and able to click the submit button");
		ForgotPassword fp = lpg.ClickForgotPass();
		fp.sendEmail().sendKeys(prop.getProperty("email"));
		fp.sendInstruction().click();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Array is 5 means it starts with 0,1,2,3,4.
		Object[][] obj = new Object[2][2];
		obj[0][0] = "user@gmail.com";
		obj[0][1] = "pass1234";
		
		obj[1][0] = "user123@gmail.com";
		obj[1][1] = "pass1234";
		return obj;
	}
	
	@AfterTest
	public void Teardown()
	{
		driver.close();
	}
}
