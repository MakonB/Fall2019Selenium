package com.automation.tests.day12;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FluentWaitTest {
private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.creatDriver("chrome");

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class)
                .ignoring(ElementClickInterceptedException.class);

        WebElement submitBtn = driver.findElement(By.cssSelector("button[type='submit']"));
    }


    @Test
    public void waitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/6");

    }






    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
