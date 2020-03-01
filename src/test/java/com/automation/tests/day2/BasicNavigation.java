package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);

        String title = driver.getTitle();
        String ectTitle = "Google";

        if (title.equals(ectTitle)){
            System.out.println("Test passed");
        }else{
            System.out.println("Failed");
        }

        driver.close();



    }
}
