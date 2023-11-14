package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert;
    protected static Actions actions;
    public static JavascriptExecutor jse;
    protected static Faker faker;
    protected static WebElement element;
    protected static Select select;
@BeforeTest
    public  void  setUp(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert = new SoftAssert();
        wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        faker = new Faker();
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
    public void click(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void scrollIntoWiev(WebElement element){
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected void verifyVisibility(By locator){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void sendKeys(By locator, String text){
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.clear();
    element.sendKeys(text);
}
    protected void onMouse( By locator){
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    actions.moveToElement(element).perform();
}
protected  void bekle(int saniye){
    try {
        Thread.sleep(saniye*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
    @AfterTest
    public  void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    driver.quit();

    }

}
