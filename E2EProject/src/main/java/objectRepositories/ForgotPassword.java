package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {

public WebDriver driver;
	
	public ForgotPassword(WebDriver driver) {
		this.driver=driver;
	}
	
	private By email = By.id("user_email");
	private By sendMeInstructions = By.cssSelector("input[value='Send Me Instructions']");
	


	public WebElement sendEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendInstruction()
	{
		return driver.findElement(sendMeInstructions);
	}
}
