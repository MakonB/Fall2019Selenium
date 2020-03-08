package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class RadioButtons {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
        BrowserUtils.wait(1);

        List<WebElement>radBut = driver.findElements(By.tagName("input"));
        for (WebElement webElement : radBut) {

            String id = webElement.getAttribute("id");

            boolean isSel = webElement.isSelected();
            System.out.println(id +" is selected ? "+ isSel);

            if (webElement.isEnabled()){
                webElement.click();
                System.out.println("Clicked on : "+ id);
                BrowserUtils.wait(1);
            }else{
                System.out.println("Buton is disabled " + id);

            }


        }




        driver.quit();
    }
}
