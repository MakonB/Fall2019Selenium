package com.automation.tests.day28Excel;

import com.automation.utilities.DriverFactory;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


public class WrightIntoExcel {


    @Test
    public void wrightIntoExcel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("VytrackTestUsers.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        fileInputStream.close();
        Sheet sheet = workbook.getSheet("QA3-short");
        Row row = sheet.getRow(1);
        Cell cell = row.getCell(5);

        System.out.println("before " + cell.getStringCellValue());
        cell.setCellValue("Failed");
        System.out.println("after" + cell.getStringCellValue());


        Row firstRow = sheet.getRow(0);   //get first roe
        Cell newCell = firstRow.createCell(6);  //create new cell
        newCell.setCellValue("Data of execution");   //give name to cell


        Row secondRow = sheet.getRow(1);
        Cell newcell2 = secondRow.createCell(6);
        newcell2.setCellValue(LocalDateTime.now().toString());
        System.out.println(newcell2.getStringCellValue());


        FileOutputStream fileOutputStream = new FileOutputStream("VytrackTestUsers.xlsx");
        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

    }


    @Test
    public void switchWindows() throws InterruptedException {

        WebDriver driver = DriverFactory.creatDriver("chrome");
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='product']//tr"));
        System.out.println(rows.size());

        System.out.println(driver.findElements(By.xpath("//table[@id='product']//tr[2]/td")).size());

        System.out.println(driver.findElement(By.xpath("//table[@id='product']//tr[3]")).getText());


    }


}
