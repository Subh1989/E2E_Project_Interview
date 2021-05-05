package objectRepositories;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	private By login = By.xpath("//a[contains(text(),'Login')]");
	private By username = By.id("user_email");
	private By password = By.id("user_password");
	private By SignIn = By.cssSelector("input[value='Log In']");
	private By forgotPass = By.cssSelector(".link-below-button");
	
	

	public ForgotPassword ClickForgotPass()
	{
		driver.findElement(forgotPass).click();
		return new ForgotPassword(driver);
	}
	
	public WebElement ClickLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getUser()
	{
		return driver.findElement(username);
	}
	
	public WebElement getPass()
	{
		return driver.findElement(password);
	}
	
	public WebElement CLickSubmit()
	{
		return driver.findElement(SignIn);
	}
}
