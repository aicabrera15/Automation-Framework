package us.piit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class APPTestCases {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://Target.com/");
        driver.manage().window().maximize();


    }
    @Test
    public void addEmailForLatestDeals() {


    }




    @AfterMethod
    public void afterMethod() {
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
        driver.quit();

    }
}
