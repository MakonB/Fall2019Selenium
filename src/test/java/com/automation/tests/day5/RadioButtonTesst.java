package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTesst {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(1);

        WebElement black = driver.findElement(By.id("black"));


        if (black.isDisplayed() && black.isEnabled()){
            System.out.println("clicked black button");
            black.click();
        }else{
            System.out.println("balck b failed");
        }
        BrowserUtils.wait(2);

        if (black.isSelected()){
            System.out.println("test passed");
        }else{
            System.out.println("failed");
        }


        driver.quit();
    }
}
