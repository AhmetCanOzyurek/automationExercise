package AE.FirstToTenth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;
import java.util.List;
public class _9_TestCase extends TestBase {

    @Test
    public void searchProduct(){
      // 1. Launch browser
      // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        // 3. Verify that home page is visible successfully
        WebElement homePage = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isDisplayed());
      // 4. Click on 'Products' button
        driver.findElement(By.xpath("//*[text()=' Products']")).click();
      // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsPage = driver.findElement(By.xpath("//input[@placeholder='Search Product']"));
        softAssert.assertTrue(allProductsPage.isDisplayed());
      // 6. Enter product name in search input and click search button
        WebElement searchBox = driver.findElement(By.xpath("//*[@placeholder='Search Product']"));
        searchBox.sendKeys("blue ");
        driver.findElement(By.xpath("//*[@id='submit_search']")).click();
      // 7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement searchedProducts = driver.findElement(By.xpath("//*[text()='Searched Products']"));
        softAssert.assertTrue(searchedProducts.isDisplayed());
      // 8. Verify all the products related to search are visible

        List<WebElement> relatedProducts = driver.findElements(By.xpath("//div[@class='col-sm-4']"));
        int sayac = 0;
        for (WebElement each: relatedProducts
             ) {
            softAssert.assertTrue(each.isDisplayed(),sayac+". assert passed");
            sayac++;
        } /////////? hocaya sor



softAssert.assertAll();
    }
}
