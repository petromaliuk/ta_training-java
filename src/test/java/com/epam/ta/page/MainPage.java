package com.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.saucedemo.com/inventory.html";

	@FindBy(className = "app_logo")
	private WebElement logo;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public MainPage openPage() {
		driver.navigate().to(BASE_URL);
		return this;
	}

	public boolean checkAppLogo() {
		return logo.getAttribute("innerHTML").equals("Swag Labs");
	}
}
