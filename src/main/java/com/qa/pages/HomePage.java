package com.qa.pages;

import com.qa.util.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends TestBase
{
    JavascriptExecutor js = (JavascriptExecutor) driver;

    @FindBy(xpath="//*[@id=\"column-right\"]/div/a[12]")
    WebElement newsMenuLinkClick;

    @FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
    WebElement continueClick;

    @FindBy(xpath="//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input")
    WebElement subRadioYes;

    @FindBy(xpath="//div[contains(text(), 'Your newsletter subscription has been successfully updated')]")
    WebElement successMsg;

    public HomePage(WebDriver driver) throws IOException
    {
        super();
        PageFactory.initElements(TestBase.driver, this);
    }

    public String getHomePageTitle()
    {
        return driver.getTitle();
    }

    public String menuItemClick()
    {
        js.executeScript("window.scrollBy(0, 600)", "");// Scrolls down by 500 pixels
        newsMenuLinkClick.click();
        return newsMenuLinkClick.getText();

    }
    public void selectYesOption()
    {
        subRadioYes.click();

    }
    public void submitContinue()
    {
        continueClick.click();

    }

    public String verifySuccessMessage() throws InterruptedException
    {
        Thread.sleep(3000);
        return  successMsg.getText();
    }
}
