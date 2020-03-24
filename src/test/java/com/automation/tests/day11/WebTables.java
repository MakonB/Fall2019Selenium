package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.*;

public class WebTables {

    private WebDriver driver;



    @Test
    public void test6(){

       driver.findElement(By.xpath("//table[1]//span[text()='Last Name']")).click();
       List<WebElement>lastNames = driver.findElements(By.xpath("//table[1]//tr//td[1]"));

        List<String>last = BrowserUtils.getTextWeb(lastNames);


        Collections.sort(last);
        List<String> sortedLastNames= Arrays.asList("Bach","Conway","Doe","Smith");
        Assert.assertEquals(last,sortedLastNames);



    }


    /**
     * Go to http://practice.cybertekschool.com/tables
     * Click on "Last name" column name
     * Verify that table is sorted by last name in alphabetic order.
     *
     * The Java String compareTo() method is used for comparing two strings lexicographically.
     * Each character of both the strings is converted into a Unicode value for comparison.
     * If both the strings are equal then this method returns 0 else it returns positive or negative value.
     * The result is positive if the first string is lexicographically greater than
     * the second string else the result would be negative.
     *
     *  This method is coming from Comparable interface.
     *  If you want ot be able to sort collection of some class
     *  you need to implement this interface
     *  and override compareTo method
     *
     "a".compareTo("b") = -1
     61 - 62 = -1
     a is before b
     "a".compareTo("a")
     61 - 61 = 0
     0 means 2 strings are equals
     *
     */
    @Test
    public void test8() {

        //click on column name
        driver.findElement(By.xpath("//table[1]//*[text()='Last Name']")).click();
        BrowserUtils.wait(2);
        //collect all values from the first column
        List<WebElement> column = driver.findElements(By.xpath("//table[1]//tbody//td[1]"));
        for (int i = 0; i < column.size() - 1; i++) {
            //take a string
            String value = column.get(i).getText();
            //take a following string
            String nextValue = column.get(i + 1).getText();

            System.out.println(value.compareTo(nextValue));

            //if difference is negative - order value is before nextValue in alphabetic order
            //if difference is positive - order value is after nextValue in alphabetic order
            //if difference is 0 - value and nextValue are equals
            Assert.assertTrue(value.compareTo(nextValue) <= 0);
        }
        driver.quit();
    }



    @Test
    public  void test1(){
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }

        Assert.assertEquals(BrowserUtils.getTextWeb(columnNames),expected);
    }

    @Test
    public  void test2(){

        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(rows.size(),4);

    }

    @Test
    public void tset3(){
        List<WebElement>comumns = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextWeb(comumns));
    }


    @Test
    public void test4(){
       driver.findElement(By.xpath("//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']")).click();
       BrowserUtils.wait(2);
        List<WebElement>comumns = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        Assert.assertEquals(comumns.size(),3);

//        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
//        driver.findElement(By.xpath(xpath)).click();
//        BrowserUtils.wait(3);
//        //get count of rows
//        int rowCount = driver.findElements(By.xpath("//table[1]//tbody//tr")).size();
//        Assert.assertEquals(rowCount, 3);
//        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());

    }

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.creatDriver("chrome");
        //WebDriverManager.chromedriver().version("79").setup();
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }


    @Test
    public void test5() {

        driver.findElement(By.xpath("//table[2]//td[text()='fbach@yahoo.com']/..//a[text()='delete']")).click();
        int num  = driver.findElements(By.xpath("//table[2]//tbody//tr")).size();
        Assert.assertEquals(num,3);
        Assert.assertTrue(driver.findElements(By.xpath("//table[2]//td[text()='fbach@yahoo.com']")).isEmpty());

    }

    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));
        int index = 0;
        for (int i = 0; i < columnNames.size(); i++) {
            if (columnNames.get(i).getText().equals(columnName)) {
                index = i + 1;
            }
        }
        Assert.assertEquals(index, 3);
    }

    @Test
    public void getSpecificCell() {
        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;
        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(cell.getText(), expected);
    }



    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(3);
        driver.quit();
    }


}
