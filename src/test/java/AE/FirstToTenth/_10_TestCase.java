package AE.FirstToTenth;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class _10_TestCase extends TestBase {

    @Test
    public void subscriptionTest(){

       //1. Launch browser
       //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
       //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayed());
       //4. Scroll down to footer
        WebElement subscriptionEmailBox = driver.findElement(By.cssSelector("#susbscribe_email"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",subscriptionEmailBox);
       //5. Verify text 'SUBSCRIPTION'
        WebElement subscriptionText = driver.findElement(By.xpath("//*[text()='Subscription']"));
        Assert.assertTrue(subscriptionText.isDisplayed());
       //6. Enter email address in input and click arrow button
        Faker faker = new Faker();
        subscriptionEmailBox.sendKeys(faker.internet().emailAddress());
        driver.findElement(By.cssSelector("i[class='fa fa-arrow-circle-o-right']")).click();
       //7. Verify success message 'You have been successfully subscribed!' is visible
        WebElement successfulSubsText = driver.findElement(By.cssSelector("div[class='alert-success alert']"));
        Assert.assertTrue(successfulSubsText.isDisplayed());


    }
}
