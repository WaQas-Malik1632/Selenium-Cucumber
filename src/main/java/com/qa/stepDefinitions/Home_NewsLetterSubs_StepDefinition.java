package com.qa.stepDefinitions;

import java.io.IOException;

import com.qa.pages.HomePage;
import com.qa.util.TestBase;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Home_NewsLetterSubs_StepDefinition extends TestBase
{
	public HomePage home;

	public Home_NewsLetterSubs_StepDefinition() throws IOException 
	{
		
	}
	 @When("Then User is on Home Page")
	    public void User_is_on_Home_Page() throws IOException
     {
	        home=new HomePage(driver);
	        String title = home.getHomePageTitle();
			 Assert.assertEquals("My Account", title);

	    }

	    @Then("user clicks on Newsletter menu item")
	    public void user_clicks_on_newsletter_menu_item() throws IOException
        {
	        home=new HomePage(driver);
	        home.menuItemClick();
	    }

	    @Then("user selects the yes option")
	    public void user_selects_the_yes_option() throws IOException
        {
	        home=new HomePage(driver);
	        home.selectYesOption();
	    }

	    @Then("user clicks continue button")
	    public void user_clicks_continue_button() throws InterruptedException, IOException
        {
	        home=new HomePage(driver);
	        home.submitContinue();
	    }

	    @Then("Verify success message")
	    public void verify_success_message() throws InterruptedException
	    {
	       String ActualMsg= home.verifySuccessMessage();

	        System.out.println(">>Actual Message: " + ActualMsg);
	        String ExpectedMsg = "Success: Your newsletter subscription has been successfully updated!";
	      	Assert.assertEquals(ExpectedMsg, ActualMsg);
	    }

}
