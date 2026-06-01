package com.QA.Pages;

import com.QA.Base.TestBase;
import com.QA.ExtentReport.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class DashboardTest extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    ExtentReports extent;
    ExtentTest test;
    ClientPage clientPage;



    public DashboardTest() {
        super();
    }

    @BeforeTest
    public void startReport() {
        extent = ExtentManager.getReportObject();
    }



    @BeforeClass
    public void setUp() throws InterruptedException {

        intialization();

        loginPage = new LoginPage();

        dashboardPage = loginPage.login(
                prop.getProperty("username"),
                prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void dashboardTest() {
        test = extent.createTest(" Verify Dashboard page");
        boolean flag = dashboardPage.verifyDashboardPage();
        Assert.assertTrue(flag);
        test.pass("Dashboard page displayed successfully");
    }

    @Test(priority = 2)
    public void dashboardTest2() {
        test = extent.createTest(" Verify Total Devices Card");
        boolean flag = dashboardPage.verifyTotalDevicesPage();
        Assert.assertTrue(flag);
    }
    @Test(priority = 5)
    public void dashboardCountTestSub1(){
        test = extent.createTest(" Verify Total Devices count");

        String devices = dashboardPage.getTotalDevicesCount();

        System.out.println("Total Devices: " + devices);
        test.info("Total Devices : " + devices);

        test.pass("Count fetched successfully");
    }




    @Test(priority = 3)
    public void dashboardTest3() {
        test = extent.createTest(" Verify Total Device Assignments Card");
        boolean flag=dashboardPage.verifyDeviceAssignmentsPage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 6)
    public void dashboardTestAssignCount(){
        test = extent.createTest(" Verify Total Device Assignments count for Assigned && UnAssigned");
        String devices = dashboardPage.getDeviceAssignmentsCount();

        System.out.println(":" + devices);



    }
    @Test(priority = 4)
    public void dashboardTest4() {
        test=extent.createTest(" Verify Total Clients Card");
        boolean flag=dashboardPage.verifyTotalClientsPage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 7)
    public void dashboardTest5() {
        test = extent.createTest(" Verify Total Clients Count");
        String totalClients = dashboardPage.getTotalClientsCount();

        System.out.println(":" + totalClients);


    }

    @Test(priority = 8)
    public void dashboardTest6() {
        test = extent.createTest(" Verify Mini map Card");
        boolean flag=dashboardPage.verifyMiniMapPage();
        Assert.assertTrue(flag);
    }






    @Test(priority = 11)

    public void verifyAllModulesNavigationTest() {
        test = extent.createTest("Verify All Modules Navigation");

        dashboardPage.clickOnClientMenu();
        test.pass("Clients Module Opened");

        dashboardPage.clickOnDeviceMenu();
        test.pass("Devices Module Opened");

        dashboardPage.clickOnFotaMenu();
        test.pass("FOTA Module Opened");

        dashboardPage.clickOnOnGoingOperationsMenu();
        test.pass("Operations Module Opened");

        dashboardPage.clickOnUsersMenu();
        test.pass("Users Module Opened");

        dashboardPage.clickOnClientLogsMenu();
        test.pass("Client Logs Module Opened");

        dashboardPage.clickOnProductsMenu();
        test.pass("Products Module Opened");

        dashboardPage.clickOnDashboardMenu();

    }

    @Test(priority = 9)
    public void verifyBellIcon() throws InterruptedException {
        dashboardPage.clickBellIcon();
        Thread.sleep(2000);
        dashboardPage.printNotifications();
        dashboardPage.closeBellIcon();
        Thread.sleep(2000);

    }

    @Test(priority = 10)
    public void verifyViewAllLink() throws InterruptedException {
        test = extent.createTest("Verify Notifications");
        dashboardPage.clickBellIcon();
        test.info("Clicked Bell Icon");
        Thread.sleep(2000);
        dashboardPage.clickOnViewAllLink();
        test.pass("Logs page displayed displayed successfully");
        dashboardPage.clickOnDashboardMenu();






    }

    @Test(priority = 12)
    public void navigateToClientPageTest() {

        test = extent.createTest("Navigate to Client Page from Dashboard");
        clientPage = dashboardPage.clickOnClientMenu();
        System.out.println("Successfully navigated to Client Page");
        test.pass("Successfully navigated to Client Page");
        dashboardPage.clickOnDashboardMenu();

    }

    @AfterMethod

    public void getResult(org.testng.ITestResult result) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass(result.getName() + " Passed");
        }
        else if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        }
        else if (result.getStatus() == ITestResult.SKIP) {
            test.skip(result.getName() + " Skipped");

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