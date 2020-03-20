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



    @Test
    public void amazonSearch(){
        driver.get("https://www.amazon.com/");
        BrowserUtils.wait(3);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
        BrowserUtils.wait(3);

        List<WebElement>searItems= driver.findElements(By.tagName("h2"));
        searItems.get(0).click();
        BrowserUtils.wait(3);
        String actual = driver.findElement(By.id("productTitle")).getText();

        Assert.assertTrue(actual.contains("Java"));

    }

    @Test
    public void forgetPss(){
        driver.get("http://practice.cybertekschool.com/forgot_password");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        driver.findElement(By.name("email")).sendKeys("bbaimurat@gmail.com",Keys.ENTER);
        BrowserUtils.wait(3);
        //driver.findElement(By.className("icon-2x icon-signin")).click();
        BrowserUtils.wait(3);
        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();
        BrowserUtils.wait(3);
        Assert.assertEquals(expected,actual , "Failed");


    }
    @Test
    public void checkBox(){
        driver.get("http://practice.cybertekschool.com/checkboxes");
        List <WebElement> checkBox = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(3);
        checkBox.get(0).click();
        BrowserUtils.wait(3);

        Assert.assertTrue(checkBox.get(0).isSelected());

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
