package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

import static utilities.Locators.*;
public class _12_TestCase extends TestBase {
    @Test
    public void AddProductsInCart(){

        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        // 4. Click 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
        // 5. Hover over first product and click 'Add to cartPage'
        WebElement element = driver.findElement(lAddToCartButton);
        scrollIntoWiev(element);
        click(lAddToCartButton);
        // 6. Click 'Continue Shopping' button
        click(lContinueShopping);
        // 7. Hover over second product and click 'Add to cartPage'
        click(lAddToCartButton2);
        // 8. Click 'View CartPage' button
        click(lWievCart);
        // 9. Verify both products are added to CartPage
        softAssert.assertTrue(driver.findElement(By.cssSelector("#product-1")).isDisplayed());
        softAssert.assertTrue(driver.findElement(By.cssSelector("#product-2")).isDisplayed());
        // 10. Verify their prices, quantity and total price
        List<WebElement> cartVerifying =driver.findElements(By.cssSelector("tbody"));

        for (WebElement e : cartVerifying) {
            softAssert.assertTrue(e.isDisplayed());
        }

        softAssert.assertAll();
    }
}
