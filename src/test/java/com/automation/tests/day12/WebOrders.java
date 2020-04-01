package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.creatDriver("chrome");
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");

        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
        BrowserUtils.wait(4);

    }


    @Test
    public void checkBoxTest(){

        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        List<WebElement> boxs = driver.findElements(By.cssSelector("input[type='checkbox']"));
        //WebElement boxs = driver.findElement(By.cssSelector("input[type='checkbox']"));

        for (WebElement box : boxs) {
            Assert.assertTrue(box.isSelected());
        }
    }

    /**
     * Webtable practice
     */
    @Test
    public void webTables(){
        WebElement zip =driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));

        Assert.assertTrue(zip.getText().equals("21233"));

        driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td/input")).click();
        BrowserUtils.wait(3);

        WebElement zipCode = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        BrowserUtils.wait(3);
        zipCode.clear();
        zipCode.sendKeys("20002");
        BrowserUtils.wait(3);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        BrowserUtils.wait(3);
         zip =driver.findElement(By.xpath("//td[text()='Steve Johns']//following-sibling::td[7]"));
        BrowserUtils.wait(3);
        Assert.assertTrue(zip.getText().equals("20002"));
    }


    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }
}
