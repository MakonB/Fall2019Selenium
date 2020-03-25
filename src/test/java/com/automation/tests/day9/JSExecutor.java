package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {

    private WebDriver driver;

    @Test
    public void scroll(){

        driver.get("http://practice.cybertekschool.com/infinite_scroll");

        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;


        for (int i = 0; i <10 ; i++) {
            js.executeScript("window.scrollBy(0,250)");
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(3);
    }


    @Test
    public void scrollToElemenr(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement lik = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)",lik);
    }






    @BeforeMethod
    public void setup(){
        driver = DriverFactory.creatDriver("chrome");
    }




    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }

}
