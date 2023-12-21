package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.Products.Products;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _13_TestCase extends TestBase {
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
    public void VerifyItemDetailPage() {
        //4. Click 'View Product' for any product on home page
        homePage.clickFirstViewItem();
        //5. Verify product detail is opened
        products.verifyProductsDetailPage();
    }
    @Test(dependsOnMethods = "VerifyItemDetailPage")
    public void increaseQuantity() {
        //6. Increase quantity to 4
        products.increaseQuantity("4");
        //7. Click 'Add to cartPage' button
        products.detailPageAddToCart();
        //8. Click 'View CartPage' button
        products.viewCartAfterAdding();
        //9. Verify that product is displayed in cartPage page with exact quantity
        products.verifyItemQuantity("4");
    }
}
