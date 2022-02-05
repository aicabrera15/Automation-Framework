package us.piit;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.datatransfer.SystemFlavorMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AppTest {

    WebDriver driver;

    @BeforeMethod
    public void beforeTest() {

        System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();


    }

    @Test
    public void test1() throws InterruptedException{
        driver.findElement(By.xpath("//input[@value=\"radio1\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value=\"radio2\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value=\"radio3\"]")).click();
        Thread.sleep(2000);


       }

    @Test
    public void test2() throws InterruptedException {
        driver.findElement(By.id("autocomplete")).sendKeys("can");
        Thread.sleep(8000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(10000);
    }

    @Test
    public void test3() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select sel =new Select (element);
        Actions actions = new Actions(driver);


        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN).click();
        Thread.sleep(4000);
        sel.selectByVisibleText("Option1");

        driver.findElement(By.id("dropdown-class-example")).click();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN).click();
        Thread.sleep(4000);
        sel.selectByVisibleText("Option2");
        Thread.sleep(2000);

        driver.findElement(By.id("dropdown-class-example")).click();
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN).click();
        Thread.sleep(4000);
        sel.selectByVisibleText("Option3");Thread.sleep(2000);


    }
    @Test
    public void test4() throws InterruptedException{

        driver.findElement(By.name("checkBoxOption1")).click();
        driver.findElement(By.name("checkBoxOption2")).click();
        driver.findElement(By.name("checkBoxOption3")).click();
        Thread.sleep(4000);
        System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());
        Thread.sleep(4000);
        driver.findElement(By.name("checkBoxOption2")).click();
        Thread.sleep(4000);
        System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());

    }

    @Test
    public void test5() throws InterruptedException {//NEED TO FINISH
        driver.findElement(By.id("openwindow")).click();
        String fWindow = driver.getWindowHandle();

         driver.findElement(By.xpath("//div[@style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']")).click() ;
}

    @Test
    public void test6() throws InterruptedException {
        //Alert
        driver.findElement(By.id("name")).sendKeys("Ashley");
        driver.findElement(By.id("alertbtn")).click();
        Alert alert0 = driver.switchTo().alert();
        System.out.println(alert0.getText());
        Thread.sleep(2000);
        alert0.accept();
        Thread.sleep(2000);
        //Confirmation Alert
        driver.findElement(By.id("name")).sendKeys("Ashley");
        driver.findElement(By.id("confirmbtn")).click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        Thread.sleep(2000);
        alert1.accept();
        Thread.sleep(3000);
        //Cancellation Alert
        driver.findElement(By.id("name")).sendKeys("Ashley");
        driver.findElement(By.id("confirmbtn")).click();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert2.getText());
        Thread.sleep(2000);
        alert2.dismiss();
        Thread.sleep(3000);


    }


    @Test
    public void test7() throws InterruptedException { //NEED TO FINISH
        //Another way to scroll
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        // js.executeAsyncScript("window.scrollBy(0,700)","");
        WebElement f =driver.findElement(By.id("product"));
        driver.switchTo().frame(f);

      List  <WebElement> rowelements =  driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr"));
        System.out.println((rowelements.size()));
        int rowsize = rowelements.size();

      List  <WebElement> columnelements =  driver.findElements(By.xpath("//*[@id=\"product\"]/tbody/tr[1]/td"));
        System.out.println((rowelements.size()));
        int colsize = columnelements.size();

        for (int i = 1; i<=rowsize; i++){
            for(int j=1; j<colsize;j++){
                System.out.println(
                driver.findElement(By.xpath("//*[@id=\"product\"]/tbody/tr["+i+"]/td["+j+"]")).getText()+ " ");
            }}
    }

    @Test
    public void test8() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeAsyncScript("window.scrollBy(0,600)","");
        boolean isEnbled = driver.findElement(By.xpath("//*[@id=\"displayed-text\"]")).isEnabled();
        Thread.sleep(3000);
        boolean isDisplayed = driver.findElement(By.xpath("//*[@id=\"displayed-text\"]")).isDisplayed();
        Thread.sleep(3000);

        if(isEnbled){
            System.out.println("btn is Enbled");
        }else{
            System.out.println("btn is not Enbled");
        }
        if (isDisplayed){
            System.out.println("btn is Enbled");
        } else{
            System.out.println("btn is  not Enbled");
        }


    }

        @AfterMethod
    public void afterMethod(){
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
        driver.quit();

    }


          }
