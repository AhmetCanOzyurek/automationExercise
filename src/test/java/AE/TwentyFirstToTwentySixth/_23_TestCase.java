package AE.TwentyFirstToTwentySixth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _23_TestCase extends TestBase {
    @Test
    public void openingSignUpPage() {
//        4. Click 'Signup / Login' button
        TopBarClicks(TopBars.SIGNUP_LOGIN);
    }
    @Test(dependsOnMethods = "openingSignUpPage")
    public void createNewUser() {
//        5. Fill all details in Signup and create account
        sUpLogin.newUserSignUp();
//        6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        sUpLogin.verifyAccountCreated();
    }
    @Test(dependsOnMethods = "createNewUser")
    public void verifyUsername(){
//        7. Verify ' Logged in as username' at top
       sUpLogin.verifyloggedAsUN();
    }
    @Test (dependsOnMethods = "verifyUsername")
    public void addProducts() {
//        8. Add products to cart
        homePage.addProductsToCart(3);
//        9. Click 'CartPage' button
        TopBarClicks(TopBars.CART);
    }
    @Test(dependsOnMethods = "addProducts")
    public void verifyCartPage() {
//        10. Verify that cart page is displayed
        cartPage.verifyCartPage();
    }
    @Test(dependsOnMethods = "verifyCartPage")
    public void verifyAddressDetails() {
//        11. Click Proceed To Checkout
        cartPage.clickProceedToCheckOut();
//        12. Verify that the delivery address is same address filled at the time registration of account
//        13. Verify that the billing address is same address filled at the time registration of account
        sUpLogin.verifyAdressDetails();
    }
    @Test(dependsOnMethods = "verifyAddressDetails")
    public void deleteAccount(){
//        14. Click 'Delete Account' button
        TopBarClicks(TopBars.DELETE_ACCOUNT);
//        15. Verify 'ACCOUNT DELETED!' and click 'Continue' button,
        sUpLogin.verifyAccountDeleted();
    }
}
