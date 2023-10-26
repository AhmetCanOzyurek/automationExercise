package AE;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBAse;

public class _3_TestCase extends TestBAse {
    @Test
    public void incorrectUser(){
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
