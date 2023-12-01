package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _2_CaseAX extends TestBase {
    @Test
    public void secCase() {


        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        //4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
        //5. Verify 'Login to your account' is visible
        WebElement loginText = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        softAssert.assertTrue(loginText.isDisplayed());
        //6. Enter correct email address and password
        Faker faker = new Faker();
        WebElement emailBox1 = driver.findElement(By.xpath("(//input[@placeholder='Email Address'])[1]"));
        emailBox1.sendKeys("email@gmail.com");
        WebElement passwordBox1 = driver.findElement(By.xpath("(//input[@placeholder='Password'])[1]"));
        passwordBox1.sendKeys("email.gmail");
        //7. Click 'login' button
        driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
        //8. Verify that 'Logged in as username' is visible
        WebElement loggedText = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        softAssert.assertTrue(loggedText.isDisplayed());
        //9. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
        //10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement deletedSign = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        softAssert.assertTrue(deletedSign.isDisplayed());

        softAssert.assertAll();
    }
}
