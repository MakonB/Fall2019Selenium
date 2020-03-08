package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WarmUp {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox"))
                .sendKeys("Java book", Keys.ENTER);
        if (driver.getTitle().contains("Java book")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        Thread.sleep(2000);

        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("Java book");
        driver.findElement(By.id("gh-btn")).click();
        System.out.println(driver.findElement(By.tagName("h1"))
                .getText().split(" ")[0]);

        Thread.sleep(2000);

        driver.get("http://wikipedia.org");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver",Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();
        if (driver.getCurrentUrl().endsWith("Selenium_(software)")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.quit();


    }
}
