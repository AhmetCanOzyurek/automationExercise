package Soru1;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBAse;

import java.time.Duration;

public class _1_Case extends TestBAse {
    @Test
    public void Test01() throws InterruptedException {
        Actions actions = new Actions(driver);
      // 1. Launch browser

       // 2. Navigate to url 'http://automationexercise.com'
       driver.get("http://automationexercise.com");
       // 3. Verify that home page is visible successfully
        WebElement homePageTitle = driver.findElement(By.xpath("//img[@alt='Website for automation practice']"));
        Assert.assertTrue(homePageTitle.isDisplayed());
       // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//i[@class='fa fa-lock']")).click();
       // 5. Verify 'New User Signup!' is visible
        WebElement newUserSign = driver.findElement(By.xpath("//*[text() ='New User Signup!']"));
       Assert.assertTrue(newUserSign.isDisplayed());
       // 6. Enter name and email address
        Faker faker = new Faker();
        WebElement nameBox = driver.findElement(By.xpath("//input[@data-qa='signup-name']"));
        nameBox.sendKeys(faker.name().fullName());
        WebElement emailBox =driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        emailBox.sendKeys(faker.internet().emailAddress());
        // 7. Click 'Signup' button
        driver.findElement(By.xpath("//*[text()='Signup']")).click();
      //  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement EAIYazısı = driver.findElement(By.xpath("(//h2[@class='title text-center'])[1]"));
        Assert.assertTrue(EAIYazısı.isDisplayed());
      //  9. Fill details: Title, Name, Email, Password, Date of birth
WebElement radioTitleButton = driver.findElement(By.xpath("//*[@*='uniform-id_gender1']"));
radioTitleButton.click();
// name and email box already filled cause faker class
        WebElement passwordBox = driver.findElement(By.xpath("//*[@type='password']"));
        passwordBox.click();
        passwordBox.sendKeys(faker.internet().password());
        WebElement dateOfBirth1 = driver.findElement(By.xpath("//*[@id='days']"));
        WebElement dateOfBirth2 = driver.findElement(By.xpath("//*[@id='months']"));
        WebElement dateOfBirth3 = driver.findElement(By.xpath("//*[@id='years']"));

        Select select = new Select(dateOfBirth1);
        select.selectByValue("15");

       Select select1 = new Select(dateOfBirth2);
        select1.selectByValue("6");
        Select select2 = new Select(dateOfBirth3);
        select2.selectByValue("1999");
      //  10. Select checkbox 'Sign up for our newsletter!'
driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
      //  11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
      //  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        Thread.sleep(1000);
        WebElement firstNameTextBox = driver.findElement(By.xpath("//*[@id='first_name']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",firstNameTextBox);
       actions.click(firstNameTextBox).
               sendKeys(faker.name().firstName()).
               sendKeys(Keys.TAB).
               sendKeys(faker.name().lastName()).
               sendKeys(Keys.TAB).
               sendKeys(faker.company().name()).
               sendKeys(Keys.TAB).
               sendKeys(faker.address().fullAddress()).
               sendKeys(Keys.TAB).
               sendKeys(faker.address().fullAddress()).perform();
        WebElement countryDDM = driver.findElement(By.xpath("//*[@id='country']"));
        Select select3 = new Select(countryDDM);
        select3.selectByValue("Canada");
        actions.sendKeys(Keys.TAB).
                sendKeys("muz").
                sendKeys(Keys.TAB).
                sendKeys(faker.rickAndMorty().location()).
                sendKeys(Keys.TAB).
                sendKeys(faker.country().countryCode3()).
                sendKeys(Keys.TAB).
                sendKeys(faker.phoneNumber().cellPhone()).perform();
        //  13. Click 'Create Account button'
       WebElement createAccountButton =  driver.findElement(By.xpath("//button[@data-qa='create-account']"));
        jse.executeScript("arguments[0].scrollIntoView();",createAccountButton);
        createAccountButton.click();
      //  14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreated = driver.findElement(By.xpath("//*[text()='Account Created!']"));
        Assert.assertTrue(accountCreated.isDisplayed());
      //  15. Click 'Continue' button//*[text()='Continue']
        driver.findElement(By.xpath("//*[text()='Continue']")).click();
      //  16. Verify that 'Logged in as username' is visible//*[text()=' Logged in as ']
        WebElement loggedSign = driver.findElement(By.xpath("//*[text()=' Logged in as ']"));
        Assert.assertTrue(loggedSign.isDisplayed());
       // 17. Click 'Delete Account' button//*[text()=' Delete Account']
        driver.findElement(By.xpath("//*[text()=' Delete Account']")).click();
         // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement deletedSign = driver.findElement(By.xpath("//*[text()='Account Deleted!']"));
        Assert.assertTrue(deletedSign.isDisplayed());
        driver.findElement(By.xpath("//*[text()='Continue']")).click();

    }
}
