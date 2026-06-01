package com.QA.Base;

import com.QA.Utility.TestUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public static WebDriver driver;
    public static Properties prop;


    public TestBase(){
        try{
            prop = new Properties();

            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") +
                            "/src/main/java/com/QA/Config/config.properties");
            prop.load(fis);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void intialization(){
        String browserName = prop.getProperty("browser");

        if (browserName.equals("chrome")) {

            WebDriverManager.chromedriver().setup();

            driver = new ChromeDriver();

        } else {
            System.out.println("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
