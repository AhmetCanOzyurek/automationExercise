package AE.TenthToTwentieth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;
public class _14_TestCase extends TestBase {

    @Test
    public void addProductsAndVerifyCartPAge() {
//        4. Add products to cartPage
        homePage.addProductsToCart(3);
//        5. Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
//        6. Verify that cartPage page is displayed
        cartPage.verifyCartPage();
//        7. Click Proceed To Checkout
    }
    @Test(dependsOnMethods = "addProductsAndVerifyCartPAge")
    public void proceedAndCheckout() {
        cartPage.clickProceedToCheckOut();
//        8. Click 'Register / Login' button
        cartPage.clickRegisterLoginAfterProceed();
//        9. Fill all details in Signup and create account
        sUpLogin.newUserSignUp();
//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        sUpLogin.verifyAccountCreated();
//        11. Verify ' Logged in as username' at top
        sUpLogin.verifyloggedAsUN();
    }
    @Test(dependsOnMethods = "proceedAndCheckout")
    public void clickCartPageAndVerifyLoggedIn() {
//        12.Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
//        13. Click 'Proceed To Checkout' button
        cartPage.clickProceedToCheckOut();
//        14. Verify Address Details and Review Your Order
        sUpLogin.verifyAdressDetails();
    }
    @Test(dependsOnMethods = "clickCartPageAndVerifyLoggedIn")
    public void writeADescription() {
//        15. Enter description in comment text area and click 'Place Order'
        cartPage.writeADescription("bana tokanma");
    }
    @Test(dependsOnMethods = "writeADescription")
    public void EnterCardDetailsAndPlaceOrder() {
//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.fillCreditCardCredentials();
//        17. Click 'Pay and Confirm Order' button
//        18. Verify success message 'Your order has been placed successfully!'
        cartPage.verifyYourOrderHasBeenPlaced();
    }
    @Test(dependsOnMethods = "EnterCardDetailsAndPlaceOrder")
    public void deleteAccount(){
//       19. Click 'Delete Account' button
        homePage.TopBarClicks(TopBars.DELETE_ACCOUNT);
//        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        sUpLogin.verifyAccountDeleted();
    }
}
