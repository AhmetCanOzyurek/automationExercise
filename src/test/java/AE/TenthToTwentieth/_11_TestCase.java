package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.TestBase;

public class _11_TestCase extends TestBase {

public static void main(String[] args) throws InterruptedException {
    HomePage homePage = new HomePage();
    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    homePage.navigateToSite();
    // 3. Verify that home page is visible successfully
    homePage.verifyMainPage();
//4. Click 'Cart' button
    homePage.TopBarClicks(TopBars.CART);
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
