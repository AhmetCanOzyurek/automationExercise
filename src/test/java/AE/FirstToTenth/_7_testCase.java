package AE.FirstToTenth;

import AE.Pages.HomePage.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _7_testCase extends TestBase {
    @Test
    public void testCasesPage(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
      //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
      //5. Verify user is navigated to test cases page successfully
        WebElement testCasesSign = driver.findElement(By.xpath("//b[text()='Test Cases']"));
        softAssert.assertTrue(testCasesSign.isDisplayed());


        softAssert.assertAll();
    }
}
