package com.QA.Pages;

import com.QA.Base.TestBase;
import com.QA.ExtentReport.ExtentManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

import static com.QA.Base.TestBase.*;
import static com.QA.ExtentReport.ExtentManager.extent;

public class ClientTest  extends TestBase {

    LoginPage loginPage;

    DashboardPage dashboardPage;
    ClientPage clientPage;

    @BeforeTest
    public void startReport() {
        extent = ExtentManager.getReportObject();
    }

    @BeforeMethod
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
    public void navigateToClientPageTest() {

        clientPage = dashboardPage.clickOnClientMenu();

        Assert.assertTrue(clientPage.verifyClientPage());

    }






    @Test
    public void addClientTest() throws InterruptedException {

        clientPage = dashboardPage.clickOnClientMenu();

        clientPage.addClient(
                "ABC Client",
                "Sound Box",
                "S2",
                "India",
                "Telangana",
                "Andol",
                "John",
                "john@test.com",
                "500081",
                "Hyderabad",
                "Admin@123",
                9876543210L
        );
        clientPage.clickNext();;
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterTest
    public void endReport() {
        extent.flush();
    }
}
