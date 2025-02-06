package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginStepDefinition
{

    public WebDriver driver;

    @Given("^User is already on Login Page$")
    public void user_already_on_loginPage()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        driver.manage().window().maximize();
    }
    @When("^Title of Login Page is Free CRM$")
    public void title_of_page_is_CRM()
    {
        String title=driver.getTitle();
        System.out.println("Title is: "+title);

        Assert.assertEquals("Account Login",title);
    }
    @Then("^User enters username and Password$")
    public void user_enters_username_and_Password()
    {
        driver.findElement(By.name("email")).sendKeys("Testerqaw@youpmail.com");
        driver.findElement(By.name("password")).sendKeys("Playwright@123");
    }

    @Then("^User clicks on Login Button$")
    public void user_clicks_on_Login_Button()
    {
        WebElement loginBtn=driver.findElement(By.xpath("//input[@value=\"Login\"]"));
        loginBtn.click();
    }

    @Then("^User is on Home Page$")
    public void user_is_on_Home_Page()
    {
        String homePageTitle=driver.getTitle();
        System.out.println("Home Page Title is: "+homePageTitle);

        Assert.assertEquals("My Account",homePageTitle);
    }

}
