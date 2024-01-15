package AE.TenthToTwentieth;

import org.testng.annotations.Test;
import utilities.TestBase;

public class _13_TestCase extends TestBase {

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
