package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _20_TestCase extends TestBase {
    @Test
    public void searchProductsAndVerifyCartAfterLogin(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
//        3. Click on 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
//        4. Verify user is navigated to ALL PRODUCTS page successfully
        verifyAllProducts(lProducts);
//        5. Enter product name in search input and click search button
        searchAProductOnProductPage("Blue");
//        6. Verify 'SEARCHED PRODUCTS' is visible
        verifyVisibility(lSearchedProductsText);
//        7. Verify all the products related to search are visible
        verifyAllProducts(lSearchedProducts);
//        8. Add those products to cartPage
        addProductsToCart(7);
//        9. Click 'CartPage' button and verify that products are visible in cartPage
        click(lCart);
//        10. Click 'Signup / Login' button and submit login details
        click(lSignupLogin);
        newUserSignUp();
//        11. Again, go to CartPage page
        click(lCart);
//        12. Verify that those products are visible in cartPage after login as well
        verifyAmountOfAddedProductsOnCart(7);
    }
}
