package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.creatDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();

        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByValue("DC");
        String exp = "District Of Columbia";
        if (exp.equals(state.getFirstSelectedOption().getText())){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        driver.quit();
    }
}
