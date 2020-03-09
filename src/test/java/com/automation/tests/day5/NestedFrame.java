package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrame {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/nested_frames");
        BrowserUtils.wait(2);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        BrowserUtils.wait(2);





        driver.quit();
    }
}
