package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import objectRepositories.LandingPage;
import resources.Base;

public class ValidateTextInPage extends Base{

	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	public WebDriver driver;
	public LandingPage lp;
	@BeforeTest
	public void BrowserNavigation() throws IOException
	{
		driver=InitializeDriver();
		log.info("Driver is initialized successfully");
		String urlName = prop.getProperty("url");
		driver.get(urlName);
		log.info("Url is opened successfully");
	}
	
	@Test
	public void TextValidationInPage() throws IOException
	{
		lp = new LandingPage(driver);
		String textName = lp.ValidateText().getText();
		Assert.assertEquals(textName, "Featured Courses");
		log.info("Required text is displayed in the Home Page");
		Assert.assertTrue(lp.ValidateDisplay().isDisplayed());
		log.info("Required section is getting displayed in the Home Page");
	}
	
	@Test
	public void HeaderValidation()
	{
		String HeaderName = lp.getHeader().getText();
		Assert.assertEquals(HeaderName, "contact@rahulshettyacademy.com");
	}
	
	@AfterTest
	public void Teardown()
	{
		driver.close();
	}
}
