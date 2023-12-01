package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _8_TestCasse extends TestBase {
    @Test
    public void allProductsDetailPage08 (){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
       // 4. Click on 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
       // 5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement allProductsPage = driver.findElement(By.xpath("//input[@placeholder='Search Product']"));
        softAssert.assertTrue(allProductsPage.isDisplayed());
       // 6. The products list is visible
        WebElement productList = driver.findElement(By.xpath("//h2[text()='Category']"));
        softAssert.assertTrue(productList.isDisplayed());
       // 7. Click on 'View Product' of first product
        driver.findElement(By.xpath("(//*[text()='View Product'])[1]")).click();
       // 8. User is landed to product detail page
        WebElement productInformationDetails = driver.findElement(By.xpath("//div[@class='product-details']"));
        softAssert.assertTrue(productInformationDetails.isDisplayed());
       // 9. Verify that detail is visible: product name, category, price, availability, condition, brand
        WebElement productName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        WebElement category = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        WebElement price = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        WebElement availability = driver.findElement(By.xpath("//*[text()='Availability:']"));
        WebElement condition = driver.findElement(By.xpath("//*[text()='Condition:']"));
        WebElement brand = driver.findElement(By.xpath("//*[text()='Brand:']"));

        softAssert.assertTrue(productName.isDisplayed());
        softAssert.assertTrue(category.isDisplayed());
        softAssert.assertTrue(price.isDisplayed());
        softAssert.assertTrue(availability.isDisplayed());
        softAssert.assertTrue(condition.isDisplayed());
        softAssert.assertTrue(brand.isDisplayed());


        softAssert.assertAll();
    }
}
