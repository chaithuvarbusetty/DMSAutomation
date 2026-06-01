package com.QA.Pages;

import com.QA.Base.TestBase;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@Slf4j
public class ClientPage extends TestBase {

    @FindBy(xpath = "//h1[normalize-space()='Clients Management']")
    WebElement clientPageHeader;

    @FindBy(xpath="//button[contains(text(),' Add New Client')]")
    WebElement addClientButton;

    @FindBy(xpath = "//input[@id='clientName']")
    WebElement clientName;

    @FindBy(xpath = "//input[@id='contactName']")
    WebElement contactPerson;

    @FindBy(xpath = "//input[@id='contactEmail']")
    WebElement email;

    @FindBy(xpath="//input[@id='pinCode']")
    WebElement pinCode;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath="//textarea[@id='address']")
    WebElement address;

    @FindBy(xpath = "//input[@id='phone']")
    WebElement mobileNo;

    @FindBy(xpath = "//select[@formcontrolname='country']")
    WebElement countryDropdown;



    @FindBy(xpath = "//select[@formcontrolname='productCategoryId']")
    WebElement productCategoryDropdown;

    @FindBy(xpath = "//select[@formcontrolname='productSeriesId']")
    WebElement productSeries;

    @FindBy(xpath = "//select[@formcontrolname='state']")
    WebElement stateDropdown;

    @FindBy(xpath = "//select[@formcontrolname='city']")
    WebElement cityDropdown;


    @FindBy(xpath = "//button[.//span[contains(text(),'Next')]]")
    WebElement createClientBtn;


    @FindBy(xpath = "//button[contains(@class,'btn-primary') and .//span[contains(text(),'Onboarding Client')]]")
    WebElement onboardingClientBtn;



    public ClientPage() {
        PageFactory.initElements(driver, this);
    }



    public boolean verifyClientPage(){
        log.info("Verify Client Page");
        return clientPageHeader.isDisplayed();

    }

    public void  AddNewClient(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Wait for loader to disappear

        wait.until(ExpectedConditions.invisibilityOfElementLocated(

                By.xpath("//div[contains(@class,'ngx-overlay')]")));

        // Wait for Add Client button

        wait.until(ExpectedConditions.elementToBeClickable(addClientButton));

        addClientButton.click();

    }

    public void enterClientName(String name) {

        clientName.sendKeys(name);

    }

    public void enterContactPerson(String name) {
        contactPerson.sendKeys(name);

    }

    public void enterEmail(String mail) {
        email.sendKeys(mail);

    }

    public void enterPinCode(String PinCode) {
        pinCode.sendKeys(PinCode);
    }

    public void enterAddress(String Address) {
        address.sendKeys(Address);
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);

    }
    public void enterMobile(long mobile){
        mobileNo.sendKeys(String.valueOf(mobile));
    }

    public void selectProductCategory(String category) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.elementToBeClickable(productCategoryDropdown));

        Select select = new Select(productCategoryDropdown);

        select.selectByVisibleText(category);

    }

    public void selectProductSeries(String series) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(productSeries));

        Select select = new Select(productSeries);

        select.selectByVisibleText(series);

    }



    public void selectCountry(String countryName) {

        Select countrySelect = new Select(countryDropdown);

        for (WebElement option : countrySelect.getOptions()) {

            String text = option.getText().trim();

            if (text.startsWith(countryName)) {

                option.click();

                return;

            }

        }

        throw new RuntimeException("Country not found : " + countryName);

    }

    public void selectState(String state) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(stateDropdown));

        Select select = new Select(stateDropdown);

        select.selectByVisibleText(state);

    }
    public void selectCity(String city) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.elementToBeClickable(cityDropdown));

        Select select = new Select(cityDropdown);

        select.selectByVisibleText(city);

    }



    public void clickNext() throws InterruptedException {


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement nextBtn = wait.until(

                ExpectedConditions.presenceOfElementLocated(

                        By.xpath("//button[contains(.,'Next')]")));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", nextBtn);


        Thread.sleep(3000);

        System.out.println("Current URL : " + driver.getCurrentUrl());

        System.out.println("Page Title : " + driver.getTitle());
    }

    public void addClient(String client,

                          String category,

                          String series,

                          String Country,

                          String State,

                          String City,

                          String contact,

                          String emailId,

                          String pin,

                          String addr,

                          String pwd,

                          long mobile) throws InterruptedException {

        AddNewClient();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOf(clientName));

        enterClientName(client);



        selectProductCategory(category);

        // Wait for series to load

        selectProductSeries(series);

        enterContactPerson(contact);


        selectCountry(Country);

        selectState(State);

        selectCity(City);

        enterEmail(emailId);

        enterPinCode(pin);

        enterAddress(addr);

        enterPassword(pwd);

        enterMobile(mobile);

        clickNext();

    }


    



}
