package com.automation.tests.day13;

import com.automation.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DriverTest {

    @Test
    public void test(){
        Driver.getDriver().get("http://google.com");
        Driver.getDriver().manage().window().maximize();
        Assert.assertEquals(Driver.getDriver().getTitle(),"Google");
        Driver.closeDriver();
    }
}
