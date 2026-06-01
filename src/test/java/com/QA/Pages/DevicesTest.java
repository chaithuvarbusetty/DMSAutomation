package com.QA.Pages;

import com.QA.Base.TestBase;
import com.QA.ExtentReport.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

import static com.QA.Base.TestBase.*;
import static com.QA.ExtentReport.ExtentManager.extent;

public class DevicesTest extends TestBase {

    LoginPage loginPage;

    DashboardPage dashboardPage;

    DevicesPage devicesPage;



    @BeforeTest
    public void startReport() {
        extent = ExtentManager.getReportObject();
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        intialization();

        loginPage = new LoginPage();

        dashboardPage = loginPage.login(
                prop.getProperty("username"),
                prop.getProperty("password"));

        new WebDriverWait(driver, Duration.ofSeconds(30))

                .until(ExpectedConditions.invisibilityOfElementLocated(

                        By.xpath("//div[contains(@class,'ngx-overlay')]")));

    }

    @Test
    public void devicesPageDisplayTest() throws InterruptedException {
       devicesPage=dashboardPage.clickOnDeviceMenu();
       Thread.sleep(2000);

        boolean flag =devicesPage.getDeviceHeader();
        Assert.assertTrue(flag);

        String textt=devicesPage.deviceHeader.getText();
        System.out.println("Header Text: " + textt);



    }

    @Test
    public void verifyDeviceGroupTabTest() throws InterruptedException {
        devicesPage = dashboardPage.clickOnDeviceMenu();

        Thread.sleep(2000);

        devicesPage.clickDeviceGroups();

        System.out.println("Clicked Device Groups");

        Thread.sleep(2000);

        devicesPage.clickProductionBatch();

        System.out.println("Clicked Production Batch");
    }

    @Test
    public void verifyCompleteDataTest() throws InterruptedException {
        devicesPage = dashboardPage.clickOnDeviceMenu();
        Thread.sleep(2000);

        devicesPage.clickDeviceGroups();
        Thread.sleep(2000);

        devicesPage.dataRetrieveDeviceGroup();


    }

    @Test
    public void verifyCreateDeviceGroupTabTest() throws InterruptedException {
        devicesPage = dashboardPage.clickOnDeviceMenu();
        Thread.sleep(2000);
        devicesPage.clickDeviceGroups();
        Thread.sleep(2000);
        devicesPage.clickCreateGroupButton();
        devicesPage.enterGroupName("QA Script");
        devicesPage.openAddDevicesDropdown();
//        devicesPage.selectDeviceById("860710088980696");
//        devicesPage.selectDeviceById("860710088971042");
//        devicesPage.selectDeviceById("869742082609733");

        List<WebElement> devices = driver.findElements(

                By.xpath("//div[contains(@class,'dropdown-item')]//label"));

        for (WebElement device : devices) {

            System.out.println(device.getText());

//        devicesPage.closeAddDevicesDropdown();
//
//        devicesPage.clickCreateGroupButton();

        }

    }




    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }
}
