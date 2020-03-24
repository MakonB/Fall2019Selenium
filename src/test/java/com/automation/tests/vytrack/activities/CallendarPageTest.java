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

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CallendarPageTest {


    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

    private WebDriver driver;
    private Actions actions;

    private String userName1 = "storemanager85";
    private String passWord1 = "UserUser123";

    //Css selector
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");
    private By ownerBy = By.className("select2-chosen");

    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");

    private By currentUserBy = By.cssSelector("#user-menu > a");


    @Test
    public void verCalBtn(){
        WebElement calbtn = driver.findElement(By.cssSelector("a[title='Create Calendar event']"));
        Assert.assertTrue(calbtn.isDisplayed());

    }


    @Test
    public void verifyDefaultValues(){
        //Click on Create Calendar Event
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtils.wait(4);

        //Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);

//        Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());


        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        Assert.assertEquals(actualDate , expectedDate);

        String expectedTime = LocalTime.now().format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");




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

        driver.findElement(By.linkText("Calendar Events")).click();


        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void teardown(){
        //driver.quit();
    }
}
