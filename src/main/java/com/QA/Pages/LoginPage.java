package com.QA.Pages;

import com.QA.Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //page factory

    @FindBy(xpath="//input[@id='email']")
    WebElement email;

    @FindBy(xpath="//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement loginButton;


    public LoginPage() {
        PageFactory.initElements(driver, this);

    }
    public DashboardPage login(String username, String pwd) throws InterruptedException {
        email.sendKeys(username);
        Thread.sleep(2000);
        password.sendKeys(pwd);
        Thread.sleep(2000);
        loginButton.click();

        Thread.sleep(2000);

        return new DashboardPage();




    }






}
