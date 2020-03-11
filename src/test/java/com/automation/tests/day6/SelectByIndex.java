package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByIndex {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver =new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select state = new Select(driver.findElement(By.id("state")));
        state.selectByIndex(9);





        BrowserUtils.wait(2);

        driver.quit();
    }
}
