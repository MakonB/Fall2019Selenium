package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToWindows {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");

        Thread.sleep(2000);

        String windowHandle = driver.getWindowHandle();
        System.out.println(driver.getCurrentUrl());

        System.out.println(windowHandle);

        Set<String>windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(windowHandle)){
                driver.switchTo().window(window);
            }

        }
        System.out.println(driver.getCurrentUrl());

        driver.close();  //will close only one (current) window
        driver.quit();  //will close all windows

    }

    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}
