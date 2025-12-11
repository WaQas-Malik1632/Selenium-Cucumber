package com.qa.stepDefinitions;

import com.qa.pages.LoginPage;
import com.qa.util.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.io.IOException;

public class loginStepDefinition extends TestBase 
{
	public LoginPage login;
	
    public loginStepDefinition() throws IOException
    {
    }

	@Given("User Opens the application")
	public void User_Opens_the_application()
	{
		intialization();
       // Headless_Intialization();
	}

	@When("User redirect towards Login Page")
	public void user_redirect_towards_login_page() throws IOException
    {
		login=new LoginPage(driver);
		login.PreRequisiteMenuClickLogin();
		Assert.assertTrue(true);
    }

	@Then("Title of Login Page is Account Login")
	public void title_of_login_page_is_account_login()
	{
		String title = login.getLoginPageTitle();
		System.out.println("Title is: " + title);

		Assert.assertEquals("Account Login", title);
	}

	// Reg Exp: We can use but its no longer usable i.e \"(.*)\" and \"([^\"]*)\"
	// @Then("^user enters \"(.*)\" and \"(.*)\"$")
	
	@Then("User logs into the application")
//	@Then("User enters {string} and {string}")
	public void User_logs_into_the_application()
	{
		String ActualTitle=	login.doLogin(prop.getProperty("emailAddress"),prop.getProperty("password"));

	        System.out.println(">>Actual Message: " + ActualTitle);
	        String ExpectedTitle = "My Account";
	        Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Then("User is on Home Page")
	public void user_is_on_Home_Page() 
	{
		String homePageTitle = driver.getTitle();
		System.out.println("Home Page Title is: " + homePageTitle);

		Assert.assertEquals("My Account", homePageTitle);
	}
}
