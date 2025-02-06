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
        driver.get("https://classic.freecrm.com/");
        driver.manage().window().maximize();
    }
    @When("^Title of Login Page is Free CRM$")
    public void title_of_page_is_CRM()
    {
        String title=driver.getTitle();
        System.out.println("Title is: "+title);

        Assert.assertEquals("Free CRM Software for customer relationship management, sales and support.",title);
    }
    @Then("^User enters username and Password$")
    public void user_enters_username_and_Password()
    {
        driver.findElement(By.name("username")).sendKeys("naveenk");
        driver.findElement(By.name("password")).sendKeys("test@123");
    }

    @Then("^User clicks on Login Button$")
    public void user_clicks_on_Login_Button()
    {
        WebElement loginBtn=driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/input"));
        loginBtn.click();
    }

    @Then("^User is on Home Page$")
    public void user_is_on_Home_Page()
    {
        String homePageTitle=driver.getTitle();
        System.out.println("Home Page Title is: "+homePageTitle);

        Assert.assertEquals("CRMPRO",homePageTitle);
    }

}
