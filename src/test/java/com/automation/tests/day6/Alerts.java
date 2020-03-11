package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);

        List<WebElement>allBut = driver.findElements(By.tagName("button"));

        allBut.get(0).click();

        BrowserUtils.wait(2);
        //System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        BrowserUtils.wait(2);
        allBut.get(2).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, world");
        BrowserUtils.wait(2);

        alert.accept();
        BrowserUtils.wait(2);
        if (driver.findElement(By.id("result")).getText().endsWith("Hello, world")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }




        BrowserUtils.wait(2);
        driver.quit();
    }
}
