package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ByMultipleOpt {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.creatDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select language = new Select(driver.findElement(By.name("Languages")));
        boolean isMul = language.isMultiple();
        System.out.println(isMul);
        BrowserUtils.wait(3);
        language.selectByVisibleText("Java");
        BrowserUtils.wait(3);
        language.selectByVisibleText("JavaScript");
        BrowserUtils.wait(3);
        language.selectByVisibleText("Python");
        BrowserUtils.wait(3);
        List <WebElement> allSel = language.getAllSelectedOptions();
        for (WebElement webElement : allSel) {
            System.out.println(webElement.getText());
        }





        driver.quit();

    }
}
