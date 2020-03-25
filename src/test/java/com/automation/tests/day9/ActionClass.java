package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionClass {

    private WebDriver driver;
    private Actions action;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.creatDriver("chrome");
    }

    @Test
    public void hoverOnImage(){
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        action = new Actions(driver);
        action.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        action.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        Assert.assertTrue(imgText1.isDisplayed());

        BrowserUtils.wait(2);
        action.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }


    @Test
    public  void test1(){
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        driver.manage().window().maximize();

        action = new Actions(driver);
        WebElement files = driver.findElement(By.xpath("//a[@id='ui-id-3']"));
        WebElement fiels2 = driver.findElement(By.xpath("//a[@id='ui-id-4']"));
        WebElement fiels3 = driver.findElement(By.xpath("//a[@id='ui-id-5']"));
        action.moveToElement(files).pause(1000).
                moveToElement(fiels2).pause(1000).
                click(fiels3).build().perform();


    }


    @Test
    public void dragAndDrop(){
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        //click on accept cookies
        action = new Actions(driver);

        BrowserUtils.wait(3);
        WebElement earth = driver.findElement(By.id("droptarget"));
        WebElement moon = driver.findElement(By.id("draggable"));

        action.dragAndDrop(moon, earth).perform();

        String expected = "You did great!";
        String actual = earth.getText();

        //Assert.assertEquals(actual, expected);
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
