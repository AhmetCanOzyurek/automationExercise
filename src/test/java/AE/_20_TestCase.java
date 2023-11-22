package AE;

import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _20_TestCase extends TestBase {
    @Test
    public void searchProductsAndVerifyCartAfterLogin(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//        3. Click on 'Products' button
        click(lProductsTopBar);
//        4. Verify user is navigated to ALL PRODUCTS page successfully
        verifyAllProducts(lProducts);
//        5. Enter product name in search input and click search button
        searchAProductOnProductPage("Blue");
//        6. Verify 'SEARCHED PRODUCTS' is visible
        verifyVisibility(lSearchedProductsText);
//        7. Verify all the products related to search are visible
        verifyAllProducts(lSearchedProducts);
//        8. Add those products to cart
        addProductsToCart(7);
//        9. Click 'Cart' button and verify that products are visible in cart
        click(lCart);
//        10. Click 'Signup / Login' button and submit login details
        click(lSignupLogin);
        newUserSignUp();
//        11. Again, go to Cart page
        click(lCart);
//        12. Verify that those products are visible in cart after login as well
        verifyAmountOfAddedProductsOnCart(7);
    }
}
