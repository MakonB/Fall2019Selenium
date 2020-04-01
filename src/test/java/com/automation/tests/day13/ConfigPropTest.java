package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class ConfigPropTest {


    @Test
    public void readProperty(){
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
    }



}
