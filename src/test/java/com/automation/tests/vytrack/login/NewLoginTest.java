package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewLoginTest extends AbstractTestBase {




    @Test
    public void VerifyPageTitle(){
        test = report.createTest("Verify page title");
        LoginPage loginPage = new LoginPage();
        loginPage.login();
        test.info("Login as store manager");
        //wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard verified");
    }

    @Test
    public void VerifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("khkhkh","khkjhkhk");
        Assert.assertEquals(loginPage.getWarningMessage(),"Invalid user name or password.");

    }



    @Test(dataProvider = "credentials")
    public void loginWithDDT(String  userName, String  password){
        test = report.createTest("Verify page title as " + userName);
        LoginPage loginPage = new LoginPage();
        loginPage.login(userName,password);
        test.info("Login as " +userName);
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
        test.pass("Page title Dashboard was verified");
    }



    @DataProvider
    public Object[][] credentials(){
        return new Object[][]{
            {"storemanager85","UserUser123"},
            {"salesmanager110","UserUser123"},
            {"user16","UserUser123"},
        };

    }
}
