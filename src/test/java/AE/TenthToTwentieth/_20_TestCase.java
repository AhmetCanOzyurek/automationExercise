package AE.TenthToTwentieth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _20_TestCase extends TestBase {
    int productNumber = 7;
    @Test
    public void clickAndVerifyProductPage() {
//        3. Click on 'Products' button
        TopBarClicks(TopBars.PRODUCTS);
//        4. Verify user is navigated to ALL PRODUCTS page successfully
        products.verifyAllProductsTxt();
    }
    @Test
    public void searchProducts(){
//        5. Enter product name in search input and click search button
        products.productSearching("Blue");
//        6. Verify 'SEARCHED PRODUCTS' is visible
        products.veriyfSearchedProducts();
//        7. Verify all the products related to search are visible
        products.verifySearchRelatedProducts("Blue");
    }
    @Test
    public void addProductsToCart() {
//        8. Add those products to cartPage
        homePage.addProductsToCart(productNumber);
    }
    @Test
    public void clickCartPageAndVerify() {
//        9. Click 'CartPage' button and verify that products are visible in cartPage
        TopBarClicks(TopBars.CART);
        cartPage.verifyCartPage();
    }
    @Test
    public void signUp(){
//        10. Click 'Signup / Login' button and submit login details
        TopBarClicks(TopBars.SIGNUP_LOGIN);
        sUpLogin.newUserSignUp();
    }
    @Test
    public void andVerifyProductsNumberIsSame(){
//        11. Again, go to CartPage page
        TopBarClicks(TopBars.CART);
//        12. Verify that those products are visible in cartPage after login as well
        products.verifyAmountOfAddedProductsOnCart(productNumber);
    }
}
