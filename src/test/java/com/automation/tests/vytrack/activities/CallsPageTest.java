package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CallsPageTest {

    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private WebDriver driver;
    private Actions actions;

    private String userName1 = "storemanager85";
    private String passWord1 = "UserUser123";

    //Css selector
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");

    @Test
    public void verifyLogButton(){
        WebElement logBut = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        Assert.assertTrue(logBut.isDisplayed());
        System.out.println(logBut.getText());

    }



    @BeforeMethod
    public void setup(){
        driver = DriverFactory.creatDriver("chrome");
        driver.get("https://app.vytrack.com/user/login");
        driver.manage().window().maximize();

        actions = new Actions(driver);
        BrowserUtils.wait(5);

        driver.findElement(userNameBy).sendKeys(userName1);
        driver.findElement(passwordBy).sendKeys(passWord1, Keys.ENTER);
        BrowserUtils.wait(5);

        //hover over Activities button
        actions.moveToElement(driver.findElement(activitiesBy)).perform();;
        BrowserUtils.wait(5);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}
