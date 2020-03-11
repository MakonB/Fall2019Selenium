package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrame {

    public static void main(String[] args) {


        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(2);
        driver.switchTo().frame("mce_0_ifr");

        WebElement id = driver.findElement(By.id("tinymce"));
        System.out.println(id.getText());
        id.clear();
        id.sendKeys("Java !!!");

        BrowserUtils.wait(2);
        driver.switchTo().defaultContent();

        BrowserUtils.wait(2);
        System.out.println(driver.findElement(By.tagName("h3")).getText());



        driver.quit();
    }
}
