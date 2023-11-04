package AE;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _11_TestCase {

public static void main(String[] args) throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    WebDriverManager.chromedriver().setup();

//2. Navigate to url 'http://automationexercise.com'
    driver.get("http://automationexercise.com");
    driver.manage().window().maximize();
//3. Verify that home page is visible successfully
    WebElement anasayfaLogosu = driver.findElement(By.xpath("//*[@alt='Website for automation practice']"));
    /*if(anasayfaLogosu.isDisplayed()) System.out.println("Anasayfa logo görünürlügü Test Passed");
    else System.out.println("Anasayfa logo görünürlügü Test Failed");
    */
    Assert.assertTrue(anasayfaLogosu.isDisplayed());
//4. Click 'Cart' button
    WebElement cartButton = driver.findElement(By.xpath("//*[text()=' Cart']"));
    cartButton.click();
//5. Scroll down to footer
    WebElement subsBox = driver.findElement(By.xpath("//input[@type='email']"));
    JavascriptExecutor jse = (JavascriptExecutor) driver;
    jse.executeScript("arguments[0].click();",subsBox);
//6. Verify text 'SUBSCRIPTION'
    WebElement subsLogo = driver.findElement(By.xpath("//*[text()='Subscription']"));
    Assert.assertTrue(subsLogo.isDisplayed());
//7. Enter email address in input and click arrow button
    subsBox.sendKeys("sdflkjsdflkj@gmail.com");
    driver.findElement(By.xpath("//*[@class='fa fa-arrow-circle-o-right']")).click();
//8. Verify success message 'You have been successfully subscribed!' is visible,
    WebElement successfulSubsText = driver.findElement(By.cssSelector("div[class='alert-success alert']"));
    Assert.assertTrue(successfulSubsText.isDisplayed());

Thread.sleep(3000);
    driver.quit();

}


}
