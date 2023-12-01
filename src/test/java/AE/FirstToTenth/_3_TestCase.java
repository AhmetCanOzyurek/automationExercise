package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _3_TestCase extends TestBase {
    @Test
    public void incorrectUser(){
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
        //6. Enter incorrect email address and password
        WebElement emailBoxLogin = driver.findElement(By.xpath("(//*[@placeholder='Email Address'])[1]"));
        emailBoxLogin.sendKeys("asdlfjslkdfjfdl@gmail.com");
        WebElement passwordLogin = driver.findElement(By.xpath("(//*[@placeholder='Password'])[1]"));
        passwordLogin.sendKeys("132456");
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[@data-qa='login-button']")).click();
        //8. Verify error 'Your email or password is incorrect!' is visible
        WebElement errorIncorrect = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        softAssert.assertTrue(errorIncorrect.isDisplayed());



        softAssert.assertAll();
    }

}
