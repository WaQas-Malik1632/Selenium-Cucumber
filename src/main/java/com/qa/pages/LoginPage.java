package com.qa.pages;

import com.qa.util.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends TestBase
{

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement MyAccountMenuClick;

	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement LoginMenuClick;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement Pass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnLoginClick;
	
	@FindBy(xpath="//div[@class='form-group']//a[normalize-space()='Forgotten Password']")
	WebElement linkForgotPass;

	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement btnLogoutClick;

	public LoginPage(WebDriver driver) throws IOException
	{
		super();
		PageFactory.initElements(TestBase.driver, this);
	}
	
	public boolean PreRequisiteMenuClickLogin()
	{
		MyAccountMenuClick.click();
		LoginMenuClick.click();

		return LoginMenuClick.isDisplayed();
    }

	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}

	public boolean isForgetPassLinkExists() 
	{
		linkForgotPass.isDisplayed();
		return false;

	}

	public String doLogin(String appUserEmail, String appPassword)
	{
		System.out.println("App Credentials:" + appUserEmail + " : " + appPassword);

		Email.sendKeys(appUserEmail);
		Pass.sendKeys(appPassword);
		btnLoginClick.click();
		
		return driver.getTitle();
	}
}
