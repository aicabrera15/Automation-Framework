package us.piit;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.awt.datatransfer.SystemFlavorMap;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static jdk.nashorn.internal.objects.NativeJava.type;

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
//    public WebDriver getDriver(String os, String browserName){
//        if(browserName.equalsIgnoreCase("chrome")){
//            if(os.equalsIgnoreCase("windows")){
//                System.setProperty("webdriver.chrome.driver", path+"C:\SeleniumDrivers\chromedriver_win32\chromedriver.exe");
//            }else if(os.equalsIgnoreCase("mac")){
//                System.setProperty("webdriver.chrome.driver", path+"C:\SeleniumDrivers\chromedriver_win32\chromedriver.exe");
//            }
//            driver = new ChromeDriver();
//        }else if(browserName.equalsIgnoreCase("firefox")){
//            if(os.equalsIgnoreCase("windows")){
//                System.setProperty("webdriver.gecko.driver", path+"C:\SeleniumDrivers\chromedriver_win32\chromedriver.exe");
//            }else if(os.equalsIgnoreCase("mac")){
//                System.setProperty("webdriver.gecko.driver", path+"C:\SeleniumDrivers\chromedriver_win32\chromedriver.exe");
//            }
//            driver = new FirefoxDriver();
//        }
//        return driver;
//    }


    @Test
    public void radioButton(){
        List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@name='radioButton']"));
        for (WebElement radioButton: radioButtons) {
            radioButton.click();


        }
        //driver.findElement(By.xpath("//input[@value=\"radio1\"]")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@value=\"radio2\"]")).click();
        //Thread.sleep(2000);
        //driver.findElement(By.xpath("//input[@value=\"radio3\"]")).click();
        //Thread.sleep(2000);
       }


    @Test
    public void suggestionDropdown() throws InterruptedException {
        driver.findElement(By.cssSelector("#autocomplete")).sendKeys("can");
        List <WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
          for (int i = 0; i<options.size(); i++){
              if (i == 2){
                  options.get(i).click();
              }
//OTHER OPTIONS
//            if(options.get(i).getText().equals("Central Africa Republic")){
//                Thread.sleep(5000);
//                options.get(i).click();
          //  }

        }

    //public void test2() throws InterruptedException {
        // actions.moveToElement(driver.findElement(By.cssSelector("#autocomplete")).sendKeys("can");
        // for(int i = 0; i<4; i++){
        // driver.findElement(By.cssSelector("autocomplete")).sendKeys(Keys.ARROW_DOWN);
        // driver.findElement(By.cssSelector("autocomplete")).sendKeys(Keys.ENTER);
    }

    @Test
    public void staticDropdown() {
        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
        Select sel = new Select(element);
        sel.selectByVisibleText("Option2");
    }

//    public void test3() throws InterruptedException {
//        WebElement element = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
//        Select sel =new Select (element);
//        Actions actions = new Actions(driver);
//
//
//        actions.sendKeys(Keys.ARROW_DOWN);
//        actions.sendKeys(Keys.ARROW_DOWN).click();
//        Thread.sleep(4000);
//        sel.selectByVisibleText("Option1");
//
//        driver.findElement(By.id("dropdown-class-example")).click();
//        actions.sendKeys(Keys.ARROW_DOWN);
//        actions.sendKeys(Keys.ARROW_DOWN);
//        actions.sendKeys(Keys.ARROW_DOWN).click();
//        Thread.sleep(4000);
//        sel.selectByVisibleText("Option2");
//        Thread.sleep(2000);
//
//        driver.findElement(By.id("dropdown-class-example")).click();
//        actions.sendKeys(Keys.ARROW_DOWN);
//        actions.sendKeys(Keys.ARROW_DOWN);
//        actions.sendKeys(Keys.ARROW_DOWN);
//        actions.sendKeys(Keys.ARROW_DOWN).click();
//        Thread.sleep(4000);
//        sel.selectByVisibleText("Option3");Thread.sleep(2000);






    @Test
    public void checkbox(){
        List<WebElement> checkboxes = driver.findElements(By.xpath("//label//input[@type='checkbox']"));
        for (WebElement checkbox: checkboxes) {
            checkbox.click();
        }
        for (int i = 0; i < checkboxes.size(); i++) {
            if(i == 1){
                Assert.assertTrue(checkboxes.get(i).isSelected());
                checkboxes.get(i).click();
                Assert.assertFalse(checkboxes.get(i).isSelected());
            }
        }
    }




//        driver.findElement(By.name("checkBoxOption1")).click();
//        driver.findElement(By.name("checkBoxOption2")).click();
//        driver.findElement(By.name("checkBoxOption3")).click();
//        Thread.sleep(4000);
//        System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());
//        Thread.sleep(4000);
//        driver.findElement(By.name("checkBoxOption2")).click();
//        Thread.sleep(4000);
//        System.out.println(driver.findElements(By.xpath("//input[@type='radio']")).size());


    @Test
    public void handleNewWindow() throws InterruptedException {
      driver.findElement(By.xpath("//*[@id='openwindow']")).click();
        Thread.sleep(3000);
        String parentWindow = driver.getWindowHandle();
        Set<String> windowHandle = driver.getWindowHandles();
        for (String window: windowHandle) {
            if(!parentWindow.contentEquals(window)){
                driver.switchTo().window(window);
                break;
            }
        }
        driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();
    }



//    public void test5() throws InterruptedException {//NEED TO FINISH
//        driver.findElement(By.id("openwindow")).click();
//        String fWindow = driver.getWindowHandle();
//
//         driver.findElement(By.xpath("//div[@style='position: absolute; inset: 0px; box-shadow: rgba(0, 0, 0, 0) 0px 0px 0px inset;']")).click() ;
//}

   // @Test
    public void handleTap(){
        driver.findElement(By.cssSelector("#opentab"));
        Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterator = windows.iterator();
        while (iterator.hasNext()){
            String parentTap = iterator.next();
            String newTab = iterator.next();
            driver.switchTo().window(newTab);
            driver.findElement(By.xpath("//*[text()='Login']"));

        }
    }



//    public void test6() throws InterruptedException {
//        //Alert
//        driver.findElement(By.id("name")).sendKeys("Ashley");
//        driver.findElement(By.id("alertbtn")).click();
//        Alert alert0 = driver.switchTo().alert();
//        System.out.println(alert0.getText());
//        Thread.sleep(2000);
//        alert0.accept();
//        Thread.sleep(2000);
//        //Confirmation Alert
//        driver.findElement(By.id("name")).sendKeys("Ashley");
//        driver.findElement(By.id("confirmbtn")).click();
//        Alert alert1 = driver.switchTo().alert();
//        System.out.println(alert1.getText());
//        Thread.sleep(2000);
//        alert1.accept();
//        Thread.sleep(3000);
//        //Cancellation Alert
//        driver.findElement(By.id("name")).sendKeys("Ashley");
//        driver.findElement(By.id("confirmbtn")).click();
//        Alert alert2 = driver.switchTo().alert();
//        System.out.println(alert2.getText());
//        Thread.sleep(2000);
//        alert2.dismiss();
//        Thread.sleep(3000);
//
//
//    }


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


//    }
//    @Test
//    public void radioButton(){
//      List<WebElement> radioButtons = driver.findElements(By.xpath("//*[@name='radioButton']"));
//      for (WebElement radioButton: radioButtons){
//          radioButton.click();
//
//      }

    }

    @Test
    public void textManipulation(){
        //String text = driver.findElement((By.xpath("//div[contains(text(),'Total Amound Collected: 296')]")));
        
    }


    @Test
      public void suggest (){
       // click("#hide-textbox");

}



    @AfterMethod
    public void afterMethod(){
        driver.manage().timeouts().implicitlyWait(50000, TimeUnit.SECONDS);
        driver.quit();

    }


          }
