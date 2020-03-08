package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(1);

        List<WebElement>checkBox = driver.findElements(By.tagName("input"));
        BrowserUtils.wait(2);
        //checkBox.get(0).click();

            if (!checkBox.get(0).isSelected()&& checkBox.get(1).isSelected()){
                System.out.println("Test passed");
        }else{
                System.out.println("Failed");
            }

        BrowserUtils.wait(2);



        driver.quit();
    }
}
