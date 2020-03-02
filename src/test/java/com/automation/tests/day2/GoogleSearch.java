package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;

public class GoogleSearch {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);
        WebElement search = driver.findElement(By.name("q"));

        search.sendKeys("M");
        Thread.sleep(1000);
        search.sendKeys("a");
        Thread.sleep(1000);
        search.sendKeys("n");
        Thread.sleep(1000);
        search.sendKeys("s");
        Thread.sleep(1000);
        search.sendKeys("h");
        Thread.sleep(1000);
        search.sendKeys("u");
        Thread.sleep(1000);
        search.sendKeys("k",Keys.ENTER);
        Thread.sleep(5000);



        //driver.quit();
    }
}
