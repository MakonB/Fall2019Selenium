package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XpathSibling {

    public static String userNameLoc = "//label[text()='Username']/following-sibling::input";
    public static String passwordLoc = "//label[text()='Password']/following-sibling::input";

    public static void main(String[] args) {

        WebDriver driver= DriverFactory.creatDriver("chrome");

        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/login");
        driver.findElement(By.xpath(userNameLoc)).sendKeys("tomsmith");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath(passwordLoc)).sendKeys("SuperSecretPassword");
        BrowserUtils.wait(3);
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();










        BrowserUtils.wait(3);
        driver.quit();
    }
}
