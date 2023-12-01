package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _5_TestCase extends TestBase {
    @Test
    public void ExistingEmail() {
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        // 4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
        // 5. Verify 'New User Signup!' is visible
        WebElement newUserSign = driver.findElement(By.xpath("//*[text() ='New User Signup!']"));
        softAssert.assertTrue(newUserSign.isDisplayed());
//6. Enter name and already registered email address
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
nameBox.sendKeys("Colin Weissnat");
        WebElement emailBox =driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailBox.sendKeys("email@gmail.com");
//7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
//8. Verify error 'Email Address already exist!' is visible
        WebElement alreadyExistText = driver.findElement(By.xpath("//p[text()='Email Address already exist!']"));;
        softAssert.assertTrue(alreadyExistText.isDisplayed());



        softAssert.assertAll();
    }
}