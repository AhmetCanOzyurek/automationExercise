package AE.FirstToTenth;

import AE.Pages.HomePage.HomePage;
import AE.Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _4_TestCAse extends TestBase {
    @Test
    public void logoutUserTest(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        //4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
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
