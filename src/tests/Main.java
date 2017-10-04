package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.*;
import org.openqa.selenium.*;

public class Main {
    private static WebDriver driver;
    private String baseUrl = "https://www.google.com.ua/";

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\tools\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        ChromeDriver chromeDriver = new ChromeDriver(options);
        driver = new EventFiringWebDriver(chromeDriver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
                getDriver().get(baseUrl + "/?gfe_rd=cr&dcr=0&ei=6LC6Wf3LLMSv8weBl5qQBA&gws_rd=ssl");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public static void waitInSeconds(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getUniqueString(){
        return new java.util.Date().toString();
    }


}