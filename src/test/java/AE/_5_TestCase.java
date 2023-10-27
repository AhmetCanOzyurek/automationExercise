package AE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBAse;

public class _5_TestCase extends TestBAse {
    @Test
    public void ExistingEmail() {
        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement homePageTitle = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePageTitle.isDisplayed());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
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