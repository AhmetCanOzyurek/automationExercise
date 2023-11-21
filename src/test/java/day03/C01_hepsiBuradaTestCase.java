package day03;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class C01_hepsiBuradaTestCase {
    WebDriver driver;


    @BeforeTest

    public void setup (){
        driver = new FirefoxDriver();
        WebDriverManager.firefoxdriver().setup();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));



    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.close();
    }
    @Test
    public void test01(){
        // hepsiburada.com sitesine gidiniz.
        driver.get("https:hepsiburada.com");
        //Kategorilerden Elektronik kısmından dizüstü bilgisayara tıkla
        Actions actions = new Actions(driver);
        WebElement elektronik = driver.findElement(By.xpath("(//span[text()='Elektronik'])[1]"));
        actions.moveToElement(elektronik).perform();
        WebElement bilgisayarTablet = driver.findElement(By.xpath("//*[text()='Bilgisayar/Tablet']"));
        actions.moveToElement(bilgisayarTablet).perform();
        WebElement dizustu = driver.findElement(By.xpath("//*[text()='Dizüstü Bilgisayar']"));
        dizustu.click();
        //Sıralamalardan çok satanlara tıkla
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
         driver.findElement(By.xpath("//*[text()='Sıralama']")).click();

        WebElement cokSatanlar = driver.findElement(By.xpath("//*[text()='Çok satanlar']"));
        cokSatanlar.click();
        //marka olarak Apple markasını seç
        driver.findElement(By.xpath("(//*[text()='Apple'])[1]")).click();
        //İlk çıkan ürüne git
        //ilk çıkan ürüne gittikten sonra ek hizmet ekleye tıkla
        //ürünü sepete ekle
        //sepete git ve sıklıkla birlikte alınanlardan çıkan ilk ürünü sepete ekle.
        //Sepete Git butonuna tıkla
        //Sepetteki ürünün para birimi değerini consolda yazdır
        //Browser ı kapat.
    }
}
