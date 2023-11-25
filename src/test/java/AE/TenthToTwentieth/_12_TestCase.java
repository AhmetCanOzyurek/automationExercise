package AE.TenthToTwentieth;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

import static utilities.Locators.*;
public class _12_TestCase extends TestBase {
    @Test
    public void AddProductsInCart(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
        // 3. Verify that home page is visible successfully
        verifyMainPage();
        // 4. Click 'Products' button
        click(lProducts);
        // 5. Hover over first product and click 'Add to cart'
        WebElement element = driver.findElement(lAddToCartButton);
        scrollIntoWiev(element);
        click(lAddToCartButton);
        // 6. Click 'Continue Shopping' button
        click(lContinueShopping);
        // 7. Hover over second product and click 'Add to cart'
        click(lAddToCartButton2);
        // 8. Click 'View Cart' button
        click(lWievCart);
        // 9. Verify both products are added to Cart
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
