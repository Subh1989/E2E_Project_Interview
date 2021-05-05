package stepDefinations;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import org.testng.Assert;
import objectRepositories.LoginPage;
import objectRepositories.PortalLoginPage;
import resources.Base;

public class StepDefination extends Base{

	public LoginPage lpg;
	

    @Given("^Initialize the chrome browser$")
    public void initialize_the_chrome_browser() throws Throwable {
        
    	driver=InitializeDriver();
    }

    @And("^Navigate to the required url$")
    public void navigate_to_the_required_url() throws Throwable {
        
    	String urlName = prop.getProperty("url");
		driver.get(urlName);
    }

    @And("^Click on the Login button$")
    public void click_on_the_login_button() throws Throwable {
        
    	lpg = new LoginPage(driver);
		lpg.ClickLogin().click();
    }

    @When("^User enters username (.+) and password (.+) and clicks on submit button$")
    public void user_enters_username_and_password_and_clicks_on_submit_button(String username, String password) throws Throwable {
        
    	lpg.getUser().sendKeys(username);
    	lpg.getPass().sendKeys(password);
    	lpg.CLickSubmit().click();
    }

    @Then("^User should be able to login successfully$")
    public void user_should_be_able_to_login_successfully() throws Throwable {
       
    	PortalLoginPage p = new PortalLoginPage(driver);
    	Assert.assertTrue(p.getSearchBox().isDisplayed());
    	
    }
    
    @And("^Close the browsers$")
    public void close_the_browsers() throws Throwable {
       
    	driver.quit();
    }
	
}
