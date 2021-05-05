package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {

	public WebDriver driver;
	public Properties prop;
	public WebDriver InitializeDriver() throws IOException
	{
		prop = new Properties();
		String HomeDir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(HomeDir+"\\src\\main\\java\\resources\\Data.properties");
		prop.load(fis);
		
		/*mvn test -Dbrowser=chrome -> This command can be used to control the browser details from Maven. Now since Maven is controlling the
		browser details hence we need to use "System.getProperty("browser")" instead of "prop.getProperty("browser")" as this is now independent of
		properties file.*/
		
		//String BrowserName = System.getProperty("browser");
		
		String BrowserName = prop.getProperty("browser");
		System.out.println(BrowserName);
		
		if(BrowserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if(BrowserName.contains("headless"))
			{
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option);
		}
		else if(BrowserName=="firefox")
		{
			//firefox code
		}
		else if(BrowserName=="IE")
		{
			//IE code
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	

	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}