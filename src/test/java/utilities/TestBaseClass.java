package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBaseClass {
    static WebDriver driver;
    @BeforeClass
    public static void  setUp(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public  static void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
