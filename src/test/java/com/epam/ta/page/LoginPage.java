package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractPage
{
	private final String PAGE_URL = "https://www.saucedemo.com/";

	@FindBy(className = "error-message-container")
	private WebElement errorField;

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
	public LoginPage openPage() {
		driver.navigate().to(PAGE_URL);
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
		return errorField.getAttribute("innerHTML").contains(str);
	}
	public LoginPage pressSubmit(){
		buttonSubmit.click();
		return this;
	}
	public LoginPage putDataInFields(User user){
		inputLogin.sendKeys(user.getUsername());
		inputPassword.sendKeys(user.getPassword());
		return this;
	}
	public LoginPage clearAllFields(){
		clear(inputLogin);
		clear(inputPassword);
		return this;
	}
	public LoginPage clearPasswordField(){
		clear(inputPassword);
		return this;
	}
	private void clear(WebElement element){
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
	}
}
