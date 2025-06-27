package com.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://www.saucedemo.com/inventory.html";
	private final String BY = "//div[@class='app_logo' and text()='Swag Labs']";

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
		List<WebElement> list = driver.findElements(By.xpath(BY));
		return !list.isEmpty();
	}
}
