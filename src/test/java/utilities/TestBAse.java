package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class TestBAse {
    public static WebDriver driver;
@BeforeTest
    public  void  setUp(){
        driver = new ChromeDriver();
        WebDriverManager.chromedriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterTest
    public  void tearDown () throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

    }
}
