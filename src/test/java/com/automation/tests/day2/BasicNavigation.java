package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();

        driver.get("http://google.com");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        String title = driver.getTitle();
        String expectedTitle = "Google";

        if (title.equals(expectedTitle)){
            System.out.println("Test passed");
        }else{
            System.out.println("Failed");
        }




        driver.navigate().to("http://amazon.com");
        Thread.sleep(2000);
        if (driver.getTitle().toLowerCase().equals("amazon")){
            System.out.println("passed");
        }else {
            System.out.println("failed");
        }
        driver.navigate().back();
        verifyEquals(driver.getTitle(),"Google");


        driver.close();






    }

    public static void verifyEquals(String str, String str2){
        if (str.equals(str2)){
            System.out.println("passed");
        }else{
            System.out.println("failed");
        }
    }
}
