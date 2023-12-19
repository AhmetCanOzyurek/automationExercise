package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Products.Products;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _12_TestCase extends TestBase {
    @Test
    public void AddProductsInCart() {

        HomePage homePage = new HomePage();
        Products products = new Products();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        // 4. Click 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
        // 5. Hover over first product and click 'Add to cartPage'
        products.addFirstProductToCart();
        // 6. Click 'Continue Shopping' button
        products.continueAfterAdding();
        // 7. Hover over second product and click 'Add to cartPage'
        products.addSecondProductToCart();
        // 8. Click 'View CartPage' button
        products.viewCartAfterAdding();
        // 9. Verify both products are added to CartPage
        products.verifyAddedItemsInCart(2);
        // 10. Verify their prices, quantity and total price
       products.verifyItemDetails("Rs.");
       products.verifyItemDetails("1");

    }
}
