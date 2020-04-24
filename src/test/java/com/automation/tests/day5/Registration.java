package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Registration {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

       driver.get("https://rahulshettyacademy.com/AutomationPractice/");
       driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
       Assert.assertTrue(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).click();
        Assert.assertFalse(driver.findElement(By.xpath("//input[@id='checkBoxOption1']")).isSelected());
        driver.findElements(By.xpath("//input[@type='checkbox']")).size();




    }
}
