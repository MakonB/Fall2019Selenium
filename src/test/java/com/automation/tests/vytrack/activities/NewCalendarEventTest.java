package com.automation.tests.vytrack.activities;

import com.automation.pages.LoginPage;
import com.automation.pages.activities.CalenderEventsPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.DateTimeUtilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.Arrays;
import java.util.List;

public class NewCalendarEventTest extends AbstractTestBase {




    @Test
    public void defaultOptionsTest(){

        LoginPage loginPage  = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        calenderEventsPage.clickToCreCalEve();
        Assert.assertEquals(calenderEventsPage.getOwnerName(),calenderEventsPage.getCurrentUserName());


        String exp = calenderEventsPage.getStartDate();
        String act = DateTimeUtilities.getCurrentDate("MMM d, yyyy");
        Assert.assertEquals(act,exp);

    }

    LoginPage loginPage  = new LoginPage();
    CalenderEventsPage calenderEventsPage = new CalenderEventsPage();




    /**
     * not working must check
     *
     */
    @Test
    public void timeDifference(){
        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        calenderEventsPage.clickToCreCalEve();

        String startTime = calenderEventsPage.getStartTime();
        String endTime = calenderEventsPage.getEndTime();

        String format = "h:mm a";

        long actual = DateTimeUtilities.getTimeDifference(startTime,endTime,format);
        Assert.assertEquals(actual,0 );

    }


    /**
     * have to check
     * something wrong
     */

    @Test
    public void verifyColumnNames(){
       loginPage.login();
       calenderEventsPage.navigateTo("Activities", "Calendar Events");

        List<String> expected = Arrays.asList("TITLE", "CALENDAR", "START", "END", "RECURRENT", "RECURRENCE", "INVITATION STATUS");
        Assert.assertEquals(calenderEventsPage.getColumnNames(), expected);
    }


    @Test(dataProvider = "calendarEvents")
    public void createCalEvents(String title, String description){

        LoginPage loginPage  = new LoginPage();
        CalenderEventsPage calenderEventsPage = new CalenderEventsPage();

        test = report.createTest("Create calendar event "+ title);
        loginPage.login();
        calenderEventsPage.navigateTo("Activities", "Calendar Events");
        calenderEventsPage.clickToCreCalEve();
        calenderEventsPage.enterTitle(title);
        calenderEventsPage.enterDescription(description);
        calenderEventsPage.clickOnSaveAndClose();

        Assert.assertEquals(calenderEventsPage.getGenInfoDescriptionText(),description);
        Assert.assertEquals(calenderEventsPage.getGeneralInfoTitleText(),title);

        test.pass("Calendar event was created successfully");

    }


    @DataProvider
    public Object[][]calendarEvents(){
        return new Object[][]{
                {"Daily stand-up", "This is meeting"},
                {"Sprint review", "Discussing last sprint"},
                {"Sprint demo", "Demonstration"}
        };
    }


}
