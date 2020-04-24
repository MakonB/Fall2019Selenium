package com.automation.pages.activities;

import com.automation.pages.AbstractPageBase;
import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CalenderEventsPage extends AbstractPageBase {



    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_start']")
    private WebElement startDate;

    @FindBy(css = "[id^='date_selector_oro_calendar_event_form_end']")
    private WebElement endDate;

    @FindBy(css = "[title='Create Calendar event']")
    private WebElement createCalendarEvent;

    @FindBy(className = "select2-chosen")
    private WebElement owner;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_start-uid']")
    private WebElement startTime;

    @FindBy(css = "[id^='time_selector_oro_calendar_event_form_end-uid']")
    private WebElement endTime;

    @FindBy(className = "grid-header-cell__label")
    private List<WebElement>columnNames;


    @FindBy(css = "[id^='oro_calendar_event_form_title-uid']")
    private WebElement title;


    @FindBy(id  = "tinymce")
    private WebElement descriptionTextArea;

    @FindBy(css = "[class='btn-group pull-right'] > button")
    private WebElement saveAndClose;


    @FindBy(xpath = "(//div[@class='control-label'])[1]")
    private WebElement generalInfoTitle;


    @FindBy(xpath = "//label[text()='Description']/following-sibling::div//div")
    private WebElement generalInfoDescription;


    @FindBy(css = "iframe[id^='oro_calendar_event_form_description-uid']")
    private WebElement descriptionFrame;

    @FindBy(xpath = "(//a[text()='...'])[1]")
    private WebElement threeDots;

    @FindBy(css = "i[class='fa-eye hide-text']")
    private WebElement eye;

    @FindBy(css = "i[class='fa-pencil-square-o hide-text']")
    private WebElement edit;


    @FindBy(css ="i[class='fa-trash-o hide-text']")
    private WebElement delete;

    public boolean verifyViewsIsDisplayed(){
        BrowserUtils.wait(3);
        return  (eye.isDisplayed()&& edit.isDisplayed() && delete.isDisplayed());

    }


    public void enterTitle(String titleValue){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.visibilityOf(title)).sendKeys(titleValue);
    }

    public void enterDescription(String description){
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(descriptionFrame));
        descriptionTextArea.sendKeys(description);
        driver.switchTo().defaultContent();         //exit from frame
        BrowserUtils.wait(6);
    }


    public void clickOnSaveAndClose(){

        wait.until(ExpectedConditions.elementToBeClickable(saveAndClose)).click();
    }


    public String getGeneralInfoTitleText(){
        BrowserUtils.waitForPageToLoad(20);
        return generalInfoTitle.getText();
    }


    public String getGenInfoDescriptionText(){
        BrowserUtils.waitForPageToLoad(20);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[text()='Description']/following-sibling::div//div")));

        return generalInfoDescription.getText();
    }


    public List<String>getColumnNames(){
        BrowserUtils.waitForPageToLoad(10);
        return BrowserUtils.getTextWeb(columnNames);
    }

    public String getEndTime() {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endTime));
        return startTime.getAttribute("value");
    }

    public String getStartTime(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startTime));
        return startTime.getAttribute("value");
    }


    public String getEndDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(endDate));
        return endDate.getAttribute("value");
    }


    public String getStartDate(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(startDate));
        return startDate.getAttribute("value");
    }

    public String getOwnerName(){
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(owner));
        return owner.getText().trim();
    }

    public void clickToCreCalEve(){

        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.elementToBeClickable(createCalendarEvent)).click();
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(6);
    }

    public void hoverOnThreeDots(){
        BrowserUtils.waitForPageToLoad(10);
        Actions actions = new Actions(driver);
        actions.moveToElement(threeDots).perform();

    }


    @FindBy(xpath = "//a[@title='Grid Settings']")
    private WebElement gridSettings;


    public void clickGridSettings(){

        wait.until(ExpectedConditions.elementToBeClickable(gridSettings)).click();

    }

    @FindBy(xpath = "//span[text()='Title']")
    private WebElement titleColumn;

    public boolean verifyTitleColumn(){
        return titleColumn.isDisplayed();
    }

    public void deSelect(){
        List<WebElement> options = driver.findElements(By.xpath("//input[contains(@id,'column')]"));
        for (int i = 1; i <options.size() ; i++) {
            options.get(i).click();
        }
    }


    @FindBy(xpath = "//span[@class='caret']")
    private WebElement expandSaveClose;

    public void clickExpand(){
        wait.until(ExpectedConditions.elementToBeClickable(expandSaveClose)).click();
    }

    @FindBy(xpath = "//button[contains(text(),'Save and New')]")
    private  WebElement saveAndNew;

    public boolean verifySaveAndNew(){
        return saveAndNew.isDisplayed();
    }

    @FindBy(xpath = "(//button[contains(text(),'Save')])[4]")
    private WebElement save;

    public boolean verifySave(){
        return save.isDisplayed();
    }

    @FindBy(xpath = "(//button[contains(text(),'Save')])[2]")
    private WebElement saveAndClose2;

    public boolean verifySaveAndClose2(){
        return saveAndClose2.isDisplayed();
    }

}
