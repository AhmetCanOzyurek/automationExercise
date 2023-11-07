package AE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

public class _7_testCase extends TestBase {
    @Test
    public void testCasesPage(){
      //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
      //3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayed());
      //4. Click on 'Test Cases' button
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
      //5. Verify user is navigated to test cases page successfully
        WebElement testCasesSign = driver.findElement(By.xpath("//b[text()='Test Cases']"));
        softAssert.assertTrue(testCasesSign.isDisplayed());


        softAssert.assertAll();
    }
}
