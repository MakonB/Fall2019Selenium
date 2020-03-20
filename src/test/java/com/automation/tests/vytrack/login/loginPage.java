package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class loginPage {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By userName = By.id("prependedInput");
    private String userName1 = "storemanager85";
    private By passWord = By.id("prependedInput2");
    private String passWord1 = "UserUser123";

    private By warningMessage  = By.cssSelector("[class='alert alert-error'] > div");


    @Test
    public void invalidUsername(){
        driver.findElement(userName).sendKeys("invalid");
        driver.findElement(passWord).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessage);
        assertTrue(warningElement.isDisplayed());
        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual,expected);


    }


    @Test
    public void loginManafer(){
        driver.findElement(userName).sendKeys(userName1);
        driver.findElement(passWord).sendKeys(passWord1,Keys.ENTER);
        BrowserUtils.wait(3);
        String title = driver.getTitle();
        String expected = "Dashboard";
        assertEquals(expected,title);
        BrowserUtils.wait(3);

    }





    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
