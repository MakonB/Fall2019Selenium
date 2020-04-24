package com.automation.homework5;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalenderEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CalendarEventsPageTest extends AbstractTestBase {

    @Test
    public void testCase1(){
        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        test = report.createTest("Verify view, edit and delete options are available");
        loginPage.login();
        calenderEventsPage.navigateTo("Activities","Calendar Events");
        calenderEventsPage.hoverOnThreeDots();
        Assert.assertTrue(calenderEventsPage.verifyViewsIsDisplayed());
        test.pass("Views was verified");

    }

    @Test
    public void testCase2(){
        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        test = report.createTest("Verify title column");
        loginPage.login();
        calenderEventsPage.navigateTo("Activities","Calendar Events");
        calenderEventsPage.clickGridSettings();
        calenderEventsPage.deSelect();

        Assert.assertTrue(calenderEventsPage.verifyTitleColumn());

        test.pass("Title column was verified");

    }


    @Test
    public void testCase3(){
        LoginPage loginPage = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();
        test = report.createTest("Verify three s");
        loginPage.login();
        calenderEventsPage.navigateTo("Activities","Calendar Events");
        calenderEventsPage.clickToCreCalEve();
        calenderEventsPage.clickExpand();

        Assert.assertTrue(calenderEventsPage.verifySaveAndClose2());
        Assert.assertTrue(calenderEventsPage.verifySave());
        Assert.assertTrue(calenderEventsPage.verifySaveAndNew());

        test.pass("Three s was verified");
    }

}
