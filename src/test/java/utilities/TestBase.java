package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert;
    public static JavascriptExecutor jse;
@BeforeTest
    public  void  setUp(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert = new SoftAssert();
        wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
    }
    public void navigateToSite() {
        driver.get("http://automationexercise.com");
    }
    public void verifyMainPage(By locator){
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.click();
    }
    public void scrollIntoWiev(WebElement element){
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    @AfterTest
    public  void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
