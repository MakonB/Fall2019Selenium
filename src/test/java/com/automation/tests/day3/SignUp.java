package com.automation.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignUp {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullname = driver.findElement(By.name("full_name"));
        fullname.sendKeys("Mister Twister");
        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@Cybertek.com");
        WebElement  signUp= driver.findElement(By.name("wooden_spoon"));
        signUp.click();

        driver.quit();
    }
}
