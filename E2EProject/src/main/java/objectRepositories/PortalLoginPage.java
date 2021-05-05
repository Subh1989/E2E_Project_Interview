package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PortalLoginPage {

	public WebDriver driver;
	
	public PortalLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By search = By.name("query");

	
	public WebElement getSearchBox()
	{
		return driver.findElement(search);
	}
}
