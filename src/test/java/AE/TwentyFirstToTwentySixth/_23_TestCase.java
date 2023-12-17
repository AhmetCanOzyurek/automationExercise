package AE.TwentyFirstToTwentySixth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;

public class _23_TestCase extends TestBase {
    @Test
    public void verifyAdressDetailsTest(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
//        4. Click 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
//        5. Fill all details in Signup and create account
        newUserSignUp();
//        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
verifyVisibility(lAccountCreatedText);
//
    click(lContinueAfterAccountCreated);
//        7. Verify ' Logged in as username' at top
verifyVisibility(lLoggedAsUsernameTxt);
//        8. Add products to cart
        addProductsToCart(3);
//        9. Click 'CartPage' button
        click(lCart);
//        10. Verify that cart page is displayed
        verifyVisibility(lShoppingCartTxt);
//        11. Click Proceed To Checkout
        click(lProceedToChckout);
//        12. Verify that the delivery address is same address filled at the time registration of account
        verifyAdressDetails();
//        13. Verify that the billing address is same address filled at the time registration of account
//        14. Click 'Delete Account' button
        click(lDeleteAccount);
//        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button,
        verifyVisibility(lAccountDeletedTxt);
    }
}
