package AE;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBAse;

public class _6_TestCase extends TestBAse {
    @Test
    public void contactUsFrom(){
       // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
       // 3. Verify that home page is visible successfully
        //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayed());
       // 4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
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
        homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        softAssert.assertTrue(homePage.isDisplayed());

        softAssert.assertAll();
    }
}
