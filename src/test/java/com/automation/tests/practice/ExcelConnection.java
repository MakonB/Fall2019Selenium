package com.automation.tests.practice;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelConnection {


    @Test
    public void test() throws IOException {

    //Which file we are calling
    String path = "ExcelPractice.xlsx";

    //we must load excel file as java file
    FileInputStream excelFile = new FileInputStream(path);

    //Load our workbook as a file
    Workbook workbook = WorkbookFactory.create(excelFile);

    //The sheet that we are working on
    Sheet workSheet = workbook.getSheet("Sheet1");

    Cell cell = workSheet.getRow(0).getCell(0);
        System.out.println(cell);

    }
}
