package com.QA.Pages;

import com.QA.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage extends TestBase {




        // Page Factory

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement dashboardHeader;

    @FindBy(xpath="//div[@id='total-devices']")
    WebElement totalDevices;

    @FindBy(xpath="//div[@id='devices-assignment']")
    WebElement deviceAssignments;

    @FindBy(xpath="//div[@id='total-clients']")
    WebElement totalClients;

    @FindBy(xpath ="//p[@class='value']")
    WebElement totalDevicesCount;

    @FindBy(xpath="//div[@id='mini-map']")
    WebElement miniMap;

    @FindBy(xpath = "//a[contains(@href,'/dms/clients')]")
    WebElement clientMenu;



    @FindBy(xpath = "//a[contains(@href,'/dms/devices')]")
    WebElement devicesMenu;

    @FindBy(xpath = "//a[contains(@href,'/dms/fota_list')]")
    WebElement fotaMenu;

    @FindBy(xpath = "//a[contains(@href,'/dms/ongoing_operations')]")
    WebElement operationsMenu;

    @FindBy(xpath = "//a[contains(@href,'/dms/users')]")
    WebElement usersMenu;

    @FindBy(xpath = "//a[contains(@href,'/dms/client_logs')]")
    WebElement clientLogsMenu;

    @FindBy(xpath = "//a[contains(@href,'/dms/products-and-hardwares')]")
    WebElement productsMenu;

    @FindBy(xpath = "//a[contains(@href,'/dms/dashboard')]")
    WebElement dashboardMenu;

    @FindBy(xpath = "//button[@class='notification-btn position-relative']")
    WebElement bellIcon;

    @FindBy(xpath="//div[@class='sidebar-backdrop']")
    WebElement closebellIcon;

    @FindBy(xpath = "//div[@class='notification-list']")
    WebElement notificationList;


    @FindBy(xpath="//a[contains(text(),'View All')]")
    WebElement viewAllLink;





        // Constructor

    public DashboardPage() {

            PageFactory.initElements(driver, this);
        }

        // Validation Method

        public boolean verifyDashboardPage() {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

            wait.until(ExpectedConditions.visibilityOf(dashboardHeader));

            return dashboardHeader.isDisplayed();
        }

        public boolean verifyTotalDevicesPage() {
            return totalDevices.isDisplayed();
        }

        public String getTotalDevicesCount() {
        return totalDevicesCount.getText();
        }

        public boolean verifyDeviceAssignmentsPage() {
            return deviceAssignments.isDisplayed();
        }
        public String getDeviceAssignmentsCount() {
        return deviceAssignments.getText();
        }
        public boolean verifyTotalClientsPage() {
            return totalClients.isDisplayed();
        }
        public String getTotalClientsCount() {
        return totalClients.getText();
        }

        public boolean verifyMiniMapPage() {
            return miniMap.isDisplayed();
        }

    public void clickMenu(WebElement element) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.invisibilityOfElementLocated(

                By.xpath("//div[contains(@class,'ngx-overlay')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", element);

    }

    public ClientPage clickOnClientMenu() {
        clickMenu(clientMenu);
        return new ClientPage();
    }

    public DevicesPage clickOnDeviceMenu() {
        clickMenu(devicesMenu);
        return new DevicesPage();
    }

    public FOTAListPage clickOnFotaMenu() {
        clickMenu(fotaMenu);
        return new FOTAListPage();
    }

    public UsersPage clickOnUsersMenu() {
        clickMenu(usersMenu);
        return new UsersPage();
    }

    public LogsPage clickOnClientLogsMenu() {
        clickMenu(clientLogsMenu);
        return new LogsPage();
    }

    public ProductsAndHardwaresPage clickOnProductsMenu() {
        clickMenu(productsMenu);
        return new ProductsAndHardwaresPage();
    }

    public OnGoingOperationsPage clickOnOnGoingOperationsMenu() {
        clickMenu(operationsMenu);
        return new OnGoingOperationsPage();
    }

    public DashboardPage clickOnDashboardMenu() {
        clickMenu(dashboardMenu);
        return new DashboardPage();
    }

    public void clickBellIcon() {
        clickMenu(bellIcon);
    }

    public void printNotifications() {
        System.out.println(notificationList.getText());
    }

    public void closeBellIcon(){
        clickMenu(closebellIcon);
    }

    public LogsPage clickOnViewAllLink(){
        clickMenu(viewAllLink);
        return new LogsPage();
    }




















    }

