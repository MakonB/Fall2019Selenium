package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class VehicleTest {

    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";
    private By userName = By.id("prependedInput");
    private String userName1 = "storemanager85";
    private By passWord = By.id("prependedInput2");
    private String passWord1 = "UserUser123";
    private By subTitle = By.className("oro-subtitle");
    private By pageNumberBy = By.cssSelector("input[type='number']");



    @Test
    public void loginManager() {
        driver.findElement(userName).sendKeys(userName1);
        driver.findElement(passWord).sendKeys(passWord1, Keys.ENTER);
        BrowserUtils.wait(3);
        String title = driver.getTitle();
        String expected = "Dashboard";
        assertEquals(expected, title);
        BrowserUtils.wait(3);

        List<WebElement>span = driver.findElements(By.xpath("//span[@class='title title-level-1']"));
        span.get(1).click();
        BrowserUtils.wait(3);

       // driver.findElement(By.linkText("Vehicles")).click();
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.linkText("Vehicles"))).perform();
        BrowserUtils.wait(3);

        WebElement subTitle1 = driver.findElement(subTitle);
        System.out.println(subTitle1.getText());

        String exp = "1";
        String act = driver.findElement(pageNumberBy).getAttribute("value");
        Assert.assertEquals(exp,act);




    }


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
