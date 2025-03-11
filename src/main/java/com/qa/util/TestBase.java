package com.qa.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase
{
    public static WebDriver driver;
    public static Properties prop;

    public TestBase() throws IOException
	{
        prop = new Properties();
        FileInputStream ip = new FileInputStream("./src/main/java/com/qa/config/config.properties");
        prop.load(ip);
    }

    public static void intialization()
	{
        String browserName = prop.getProperty("browser");
        if (browserName.equalsIgnoreCase("chrome"))
		{
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox"))
		{
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge"))
		{
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        } else
		{
            System.out.println("\n" + "You have entered Invalid Browser Name" + "\n");

        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public static void Headless_Intialization()
	{
        String browserName = prop.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome"))
		{
            ChromeOptions options = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
            driver = new ChromeDriver(options);

        } else if (browserName.equalsIgnoreCase("firefox"))
		{
            FirefoxOptions options = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
            driver = new FirefoxDriver(options);

        } else if (browserName.equalsIgnoreCase("edge"))
		{
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--headless");
            options.addArguments("disable-gpu");
            driver = new EdgeDriver(options);

        } else
		{
            System.out.println("\n" + "You have entered Invalid Browser Name" + "\n");

        }
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

    }
}
