package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest {

    private WebDriver driver;

    @Test
    public void searchGoogle(){
        driver.get("https://www.google.com/");

        driver.findElement(By.name("q")).sendKeys("Java", Keys.ENTER);
        BrowserUtils.wait(2);
        List<WebElement>searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            String var = searchItem.getText();
            if (!var.isEmpty()){
                System.out.println(var);
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }







    @BeforeMethod
    public  void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();

    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }





}
