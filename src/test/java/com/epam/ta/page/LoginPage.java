package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage
{
	private final String PAGE_URL = "https://www.saucedemo.com/";
	private final String BY = "//div[@class='error-message-container error']";

	@FindBy(id = "user-name")
	private WebElement inputLogin;

	@FindBy(id = "password")
	private WebElement inputPassword;

	@FindBy(id = "login-button")
	private WebElement buttonSubmit;



	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public LoginPage openPage()
	{
		driver.navigate().to(PAGE_URL);
		return this;
	}
	public LoginPage uc1(User user) {
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		clear(inputLogin);
		clear(inputPassword);
		buttonSubmit.click();
		return this;
	}
	public LoginPage uc2(User user){
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		clear(inputPassword);
		buttonSubmit.click();
		return this;
	}


	public MainPage login(User user)
	{
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		buttonSubmit.click();
		return new MainPage(driver);
	}
	public boolean checkErrorContains(String str){
		List<WebElement> error = driver.findElements(By.xpath(BY));
		if(error.isEmpty()) return false;
		String s = error.get(0).getAttribute("innerHTML");
		return s.contains(str);
	}
	public void clear(WebElement element){
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}
}
