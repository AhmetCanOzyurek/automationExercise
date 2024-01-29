package AE.TwentyFirstToTwentySixth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _24_TestCase extends TestBase {


    @Test
    public void addProducts() {
//4. Add products to cart
        homePage.addProductsToCart(3);
//5. Click 'CartPage' button
        TopBarClicks(TopBars.CART);
//6. Verify that cart page is displayed
        cartPage.verifyCartPage();
    }

    @Test(dependsOnMethods = {"addProducts"})
    public void newUserLogin() {
//7. Click Proceed To Checkout
        cartPage.clickProceedToCheckOut();
//8. Click 'Register / Login' button
        cartPage.clickRegisterLoginAfterProceed();
//9. Fill all details in Signup and create account
        sUpLogin.newUserSignUp();
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        sUpLogin.verifyAccountCreated();
//11. Verify ' Logged in as username' at top
        sUpLogin.verifyloggedAsUN();
    }

    @Test(dependsOnMethods = {"newUserLogin"})
    public void verifyAdress() {
//12.Click 'CartPage' button
        TopBarClicks(TopBars.CART);
//13. Click 'Proceed To Checkout' button
        cartPage.clickProceedToCheckOut();
//14. Verify Address Details and Review Your Order
        sUpLogin.verifyAdressDetails();
//15. Enter description in comment text area and click 'Place Order'
        cartPage.writeADescription("muz");
    }

    @Test(dependsOnMethods = {"verifyAdress"})
    public void payments() {
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.fillCreditCardCredentials();
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
        cartPage.verifyYourOrderHasBeenPlaced();
    }

    @Test(dependsOnMethods = {"payments"})
    public void downloadInvoice() {
//19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
     cartPage.downloadAndVerifyFile();
//20. Click 'Continue' button
        sUpLogin.click(lContinueAfterAccountCreated);
    }

    @Test(dependsOnMethods = {"downloadInvoice"})
    public void deleteAccount() {
//21. Click 'Delete Account' button
        TopBarClicks(TopBars.DELETE_ACCOUNT);
//22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        sUpLogin.verifyAccountDeleted();
    }

}
