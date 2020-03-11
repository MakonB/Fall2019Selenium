package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDowns {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.creatDriver("chrome");
        BrowserUtils.wait(3);
        driver.get("http://practice.cybertekschool.com/dropdown");
       Select simpleDr = new Select(driver.findElement(By.id("dropdown")));

       simpleDr.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);
       Select year = new Select(driver.findElement(By.id("year")));

       year.selectByVisibleText("1985");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("February");
        Select date = new Select(driver.findElement(By.id("day")));
        date.selectByVisibleText("15");

        List<WebElement>months = month.getOptions();
        for (WebElement eachMonth : months){
            System.out.println(eachMonth.getText());
            month.selectByVisibleText(eachMonth.getText());
            //BrowserUtils.wait(2);

        }

        System.out.println(months.size());

        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByVisibleText("Florida");
        String expected = "Florida";
        //              returns       text
        String actual = state.getFirstSelectedOption().getText();
        if (expected.equals(actual)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }

                BrowserUtils.wait(4);
        driver.quit();


    }
}
