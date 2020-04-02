package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "prependedInput")
    private WebElement username;

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;


    @FindBy(linkText = "Forgot your password?")
    private WebElement forgetPassword;


    @FindBy(css="[class='alert alert-error']")
    private WebElement warningMessage;

    public String getWarningMessage(){
        return warningMessage.getText();
    }
    /**
     * Method to login as specific user
     * @param userName
     * @param passWord
     */
    public void login(String userName, String passWord){
        username.sendKeys(userName);
        password.sendKeys(passWord, Keys.ENTER);
        BrowserUtils.wait(3);
    }


    /**
     * Login version 2
     * as default user
     */
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("storeManager"));
        password.sendKeys(ConfigurationReader.getProperty("password"),Keys.ENTER);
        BrowserUtils.wait(3);
    }




}
