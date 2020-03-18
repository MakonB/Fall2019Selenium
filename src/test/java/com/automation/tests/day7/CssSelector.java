package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.creatDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        WebElement heading  = driver.findElement(By.cssSelector(".h3")); // . means = class
        WebElement button1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement button2 = driver.findElement(By.cssSelector("[name='button2']"));
       WebElement button6 = driver.findElement(By.cssSelector("#disappearing_button"));

        BrowserUtils.wait(3);
        button1.click();
        button2.click();
        button6.click();
        BrowserUtils.wait(3);
        driver.quit();

    }
}
