package com.qa.stepDefinitions;

import com.qa.util.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class loginStepDefinition extends TestBase
{

    public loginStepDefinition() throws IOException
    {
    }

    @Given("^User is already on Login Page$")
    public void user_already_on_loginPage()
    {
        TestBase.intialization();
    }

    @When("^Title of Login Page is OpenCart$")
    public void title_of_page_is_Account_Login()
    {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        Assert.assertEquals("Account Login", title);
    }

    //Reg Exp: We can use but its no longer usable i.e \"(.*)\" and \"([^\"]*)\"
    //  @Then("^user enters \"(.*)\" and \"(.*)\"$")
    @Then("User enters {string} and {string}")
    public void user_enters_username_and_Password(String emailAdr, String pass)
    {
        driver.findElement(By.name("email")).sendKeys(emailAdr);
        driver.findElement(By.name("password")).sendKeys(pass);

    }

    @Then("^User clicks on LoginButton$")
    public void user_clicks_on_Login_Button()
    {
        WebElement loginBtn = driver.findElement(By.xpath("//input[@value=\"Login\"]"));
        loginBtn.click();
    }

    @Then("^User is on Home Page$")
    public void user_is_on_Home_Page()
    {
        String homePageTitle = driver.getTitle();
        System.out.println("Home Page Title is: " + homePageTitle);

        Assert.assertEquals("My Account", homePageTitle);
    }
}
