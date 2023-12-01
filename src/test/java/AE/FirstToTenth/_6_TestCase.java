package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _6_TestCase extends TestBase {
    @Test
    public void contactUsFrom(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
       // 4. Click on 'Contact Us' button
        homePage.TopBarClicks(TopBars.CONTACT_US);
       // 5. Verify 'GET IN TOUCH' is visible
        WebElement getInTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        softAssert.assertTrue(getInTouch.isDisplayed());
       // 6. Enter name, email, subject and message
        WebElement nameBox= driver.findElement(By.xpath("//*[@placeholder='Name']"));
        WebElement emailBox= driver.findElement(By.xpath("//*[@placeholder='Email']"));
        WebElement subjectBox= driver.findElement(By.xpath("//*[@placeholder='Subject']"));
        WebElement messageBox= driver.findElement(By.xpath("//*[@placeholder='Your Message Here']"));
        Faker faker = new Faker();
        nameBox.sendKeys("Colin Weissnat");
        emailBox.sendKeys("email@gmail.com");
        subjectBox.sendKeys("love from Yozgat");
        messageBox.sendKeys(faker.rickAndMorty().quote());
       // 7. Upload file
WebElement uploadButton = driver.findElement(By.xpath("//*[@name='upload_file']"));
String dosyaYolu = "/Users/enesoncu/IdeaProjects/automationExercise/src/test/java/AE/TestDosyası";
uploadButton.sendKeys(dosyaYolu);
       // 8. Click 'Submit' button
driver.findElement(By.xpath("//*[@name='submit']")).click();
       // 9. Click OK button
        driver.switchTo().alert().accept();
       // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        WebElement successText = driver.findElement(By.xpath("//*[@class='status alert alert-success']"));
       // 11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("//*[text()=' Home']")).click();
         WebElement homePageSign = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        softAssert.assertTrue(homePageSign.isDisplayed());

        softAssert.assertAll();
    }
}
