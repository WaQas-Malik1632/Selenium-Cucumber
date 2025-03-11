package com.qa.stepDefinitions;

import com.qa.util.TestBase;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class SubscribeNewsletter extends TestBase
{
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public SubscribeNewsletter() throws IOException
    {
    }

    @When("^Title of Login Page is Account Login$")
    public void title_of_login_page_is_account_login()
    {
        String title = driver.getTitle();
        System.out.println("Title is: " + title);

        Assert.assertEquals("Account Login", title);
    }

    @Then("user clicks on Newsletter menu item")
    public void user_clicks_on_newsletter_menu_item()
    {
        js.executeScript("window.scrollBy(0, 600)", "");// Scrolls down by 500 pixels

        WebElement newsMenuLinkClick = driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[12]"));
        newsMenuLinkClick.click();
    }

    @Then("user selects the yes option")
    public void user_selects_the_yes_option()
    {
        WebElement subRadioYes = driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input"));
        subRadioYes.click();
    }

    @Then("user clicks continue button")
    public void user_clicks_continue_button() throws InterruptedException {
        WebElement continueClick = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div[2]/input"));
        continueClick.click();
    }

    @Then("Verify success message")
    public void verify_success_message() throws InterruptedException
    {
        Thread.sleep(3000);
        WebElement verifySuccessMsg =driver.findElement(By.xpath("//div[contains(text(), 'Your newsletter subscription has been successfully updated')]"));
        String ActualMsg = verifySuccessMsg.getText();

        System.out.println(">>Actual Message: " + ActualMsg);
        String ExpectedMsg = "Success: Your newsletter subscription has been successfully updated!";
        Assert.assertEquals(ExpectedMsg, ActualMsg);

    }

}
