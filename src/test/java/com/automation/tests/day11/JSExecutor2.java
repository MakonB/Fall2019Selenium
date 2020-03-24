package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {


    private WebDriver driver;

    @Test
    public void test1(){
        String ex = "Practice";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String act = (String) js.executeScript("return document.title");
        Assert.assertEquals(act,ex);
    }

    @Test
    public void test2(){
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        //link.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click()",link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));
        js.executeScript("arguments[0].click()",button6);
        BrowserUtils.wait(3);
        WebElement result  = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(),"Now it's gone!");



    }

    @Test
    public void  test3() {
        driver.findElement(By.linkText("Form Authentication")).click();

        BrowserUtils.wait(3);

        WebElement userName = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBut = driver.findElement(By.id("wooden_spoon"));
        BrowserUtils.wait(3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','tomsmith')",userName);
        js.executeScript("arguments[0].setAttribute('value','SuperSecretPassword')",password);
        js.executeScript("arguments[0].click()",loginBut);
        WebElement esl = driver.findElement(By.className("subheader"));
        //String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();
        Assert.assertEquals(esl.getText(),"Welcome to the Secure Area. When you are done click logout below.");
    }


    @Test
    public void tesy4(){
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",link);

    }


    @Test
    public void test5(){
        driver.navigate().to("http://practice.cybertekschool.com/infinite_scroll");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 0; i <10 ; i++) {
            js.executeScript("window.scrollBy(0,1000");
            BrowserUtils.wait(1);
        }
    }


    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.creatDriver("chrome");
        //WebDriverManager.chromedriver().version("79").setup();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
       // driver.quit();
    }

}
