package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Products.Products;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _12_TestCase extends TestBase {
    HomePage homePage;
    Products products;

    @BeforeTest
    public void initial() {
        homePage = new HomePage();
        products = new Products();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }

    @Test
    public void AddProductsInCart() {
        // 4. Click 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
        // 5. Hover over first product and click 'Add to cartPage'
        // 6. Click 'Continue Shopping' button
        // 7. Hover over second product and click 'Add to cartPage'
        homePage.addProductsToCart(2);
        products.viewCartAfterAdding();
    }

    @Test(dependsOnMethods = "AddProductsInCart")
    public void VerifyItemDetails() {
        // 8. Click 'View CartPage' button
        products.viewCartAfterAdding();
        // 9. Verify both products are added to CartPage
        products.verifyAddedItemsInCart(2);
        // 10. Verify their prices, quantity and total price
        products.verifyItemDetails("price", "Rs. 500");
        products.verifyItemDetails("quantity", "1");
        products.verifyItemDetails("total", "Rs. 500");
    }
}
