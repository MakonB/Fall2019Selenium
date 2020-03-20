package com.automation.tests.practice;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {

    private String Url = "http://practice.cybertekschool.com/registration_form";
    private WebDriver driver;
    private By firstNameBy = By.name("firstname");
    private By lastNameBy = By.name("lastname");
    private By userNameBy = By.name("username");
    private By emailBy = By.name("email");
    private By passwordBy = By.name("password");
    private By phoneNumber = By.name("phone");
    private By maleBy = By.cssSelector("input[value='male']");
    private By femaleBy = By.cssSelector("input[value='female']");
    private By dataBirthBy = By.name("birthday");
    private By departmentBy = By.name("department");
    private By jobTitleBy  = By.name("job_title");

    //XPATH  with sibling
    private By cPlusBy = By.xpath("//label[text()='C++']/preceding-sibling::input");
    private By javaBy = By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy = By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
    private By sighUpBy = By.id("wooden_spoon");


    @Test
    public void test1(){
        driver.findElement(firstNameBy).sendKeys("Patrick");
        BrowserUtils.wait(2);
        driver.findElement(lastNameBy).sendKeys("White");
        BrowserUtils.wait(2);
        driver.findElement(userNameBy).sendKeys("testuser");
        BrowserUtils.wait(2);
        driver.findElement(emailBy).sendKeys("test@email.com");
        BrowserUtils.wait(2);
        driver.findElement(passwordBy).sendKeys("123455678");
        BrowserUtils.wait(2);
        driver.findElement(phoneNumber).sendKeys("234-123-1231");
        BrowserUtils.wait(2);
        driver.findElement(maleBy).click();
        BrowserUtils.wait(2);
        driver.findElement(dataBirthBy).sendKeys("01/02/1940");
        BrowserUtils.wait(2);
        Select departmentSelect = new Select(driver.findElement(departmentBy));
        BrowserUtils.wait(2);
        departmentSelect.selectByVisibleText("Department of Agriculture");
        BrowserUtils.wait(2);
        Select jobTitleSelect = new Select(driver.findElement(jobTitleBy));
        BrowserUtils.wait(2);
        jobTitleSelect.selectByVisibleText("SDET");
        BrowserUtils.wait(2);

        driver.findElement(javaBy).click();
        BrowserUtils.wait(2);
        driver.findElement(sighUpBy).click();
        BrowserUtils.wait(5);

        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actual, expected);

    }




    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(Url);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }
}
