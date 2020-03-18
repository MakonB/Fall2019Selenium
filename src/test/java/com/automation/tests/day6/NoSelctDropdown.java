package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NoSelctDropdown {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.creatDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();
        driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(3);

        List<WebElement>allLinks = driver.findElements(By.className("dropdown-item"));
        for (WebElement eachLink : allLinks) {
            System.out.println(eachLink.getText()+" : "+eachLink.getAttribute("href"));
        }



        BrowserUtils.wait(3);
        driver.findElement(By.linkText("Amazon")).click();






        BrowserUtils.wait(2);
        driver.quit();
    }
}
