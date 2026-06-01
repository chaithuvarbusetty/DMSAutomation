package com.QA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.QA.Base.TestBase.driver;

public class DevicesPage {

    DashboardPage dashboardPage;


    ////a[@class='tab-item active']
    @FindBy(xpath="//h1[normalize-space()='Device Management']")
    WebElement deviceHeader;

    @FindBy(xpath="//a[@href='/dms/device_group']")
    WebElement deviceGroupsTab;

    @FindBy(xpath="//a[@href='/dms/batch-management']")
    WebElement productionBatchTab;

    @FindBy(xpath="//div[contains(@class,'device-groups-grid')]")
    WebElement deviceGroupData;

    @FindBy(xpath="//button[@class='btn btn-primary' and contains(.,'Create New Group')]")
    WebElement createGroupBtn;

    @FindBy(xpath = "//input[@formcontrolname='name']")
    WebElement groupNameField;

    @FindBy(xpath = "//div[contains(@class,'custom-dropdown')]")
    WebElement addDevicesDropdown;


    @FindBy(xpath = "//button[normalize-space()='Create Group']")
    WebElement createGroupButton;




    public DevicesPage(){
        PageFactory.initElements(driver, this);

    }

    public boolean getDeviceHeader(){
        return deviceHeader.isDisplayed();
    }

    public void clickMenu(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(

                By.xpath("//div[contains(@class,'ngx-overlay')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);

    }

    public void clickDeviceGroups() {
        clickMenu(deviceGroupsTab);
    }
    public void clickProductionBatch() {
        clickMenu(productionBatchTab);
    }

    public void dataRetrieveDeviceGroup(){
        clickMenu(deviceGroupsTab);
        String completeData=deviceGroupData.getText();
        System.out.println(completeData);

    }

    public void clickCreateGroupButton() {
        clickMenu(createGroupBtn);

    }

    public void enterGroupName(String groupName) {
        groupNameField.sendKeys(groupName);
    }

    public void openAddDevicesDropdown() {
        clickMenu(addDevicesDropdown);
    }

    public void selectDeviceById(String deviceId) {

        WebElement checkbox = driver.findElement(
                By.xpath("//label[contains(text(),'ID: " + deviceId + "')]/preceding-sibling::input"));

        clickMenu(checkbox);
    }

    public void closeAddDevicesDropdown() {
        clickMenu(addDevicesDropdown);
    }

    public void clickCreateGroup() {
        clickMenu(createGroupButton);
    }











}
