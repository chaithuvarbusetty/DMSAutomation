package com.QA.Pages;

import com.QA.Base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    public LoginPage loginPage;
    public DashboardPage dashboardPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp(){
        intialization();
        loginPage = new LoginPage();
    }
    @Test
    public void loginTest() throws InterruptedException {
        dashboardPage = loginPage.login(
                prop.getProperty("username"),
                prop.getProperty("password")
        );
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
