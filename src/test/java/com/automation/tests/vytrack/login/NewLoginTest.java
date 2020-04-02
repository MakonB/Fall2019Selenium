package com.automation.tests.vytrack.login;

import com.automation.pages.LoginPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NewLoginTest extends AbstractTestBase {




    @Test
    public void VerifyPageTitle(){

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        //wait.until(ExpectedConditions.titleIs("Dashboard"));
        Assert.assertEquals(Driver.getDriver().getTitle(),"Dashboard");
    }

    @Test
    public void VerifyWarningMessage(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("khkhkh","khkjhkhk");
        Assert.assertEquals(loginPage.getWarningMessage(),"Invalid user name or password.");
    }
}
