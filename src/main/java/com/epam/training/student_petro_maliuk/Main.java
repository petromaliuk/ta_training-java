package com.epam.training.student_petro_maliuk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://seleniumhq.org");
        Thread.sleep(3000);
        driver.quit();
    }
}