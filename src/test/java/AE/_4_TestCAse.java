package AE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBAse;

public class _4_TestCAse extends TestBAse {
    @Test
    public void logoutUserTest(){
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        softAssert.assertTrue(loginToYourAccountText.isDisplayed());
        //6. Enter correct email address and password
        WebElement emailBox1 = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        emailBox1.sendKeys("email@gmail.com");
        WebElement passwordBox1 = driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]"));
        passwordBox1.sendKeys("email.gmail");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedSign = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedSign.isDisplayed());
        //9. Click 'Logout' button
        driver.findElement(By.xpath("//*[text()=' Logout']")).click();
        //10. Verify that user is navigated to login page
           loginToYourAccountText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        softAssert.assertTrue(loginToYourAccountText.isDisplayed());
        softAssert.assertAll();
    }
}
