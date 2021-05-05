package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By text = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By display = By.cssSelector(".navigation.clearfix");
	private By header = By.cssSelector("//li[contains(text(),'contact')]");


	public WebElement ValidateText()
	{
		return driver.findElement(text);
	}
	
	public WebElement ValidateDisplay()
	{
		return driver.findElement(display);
	}
	
	public WebElement getHeader()
	{
		return driver.findElement(header);
	}
}
