package AE.TenthToTwentieth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _16_TestCase extends TestBase {
    @Test
    public void signUp() {
        //4. Click 'Signup / Login' button
        TopBarClicks(TopBars.SIGNUP_LOGIN);
        //5. Fill all details in Signup and create account
        sUpLogin.newUserSignUp();
        //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        sUpLogin.verifyAccountCreated();
        //7. Verify ' Logged in as username' at top
        sUpLogin.verifyloggedAsUN();
    }

    @Test(dependsOnMethods = "signUp")
    public void addProductAndOpenCartPage() {
        //8. Add products to cartPage
        homePage.addProductsToCart(3);
        //9. Click 'CartPage' button
        TopBarClicks(TopBars.CART);
        //10. Verify that cartPage page is displayed
        cartPage.verifyCartPage();
    }

    @Test(dependsOnMethods = "addProductAndOpenCartPage")
    public void proceedToChckout() {
        //11. Click Proceed To Checkout
        cartPage.clickProceedToCheckOut();
        //12. Verify Address Details and Review Your Order
        sUpLogin.verifyAdressDetails();
        //13. Enter description in comment text area and click 'Place Order'
        cartPage.writeADescription("hela vela ");
    }

    @Test(dependsOnMethods = "proceedToChckout")
    public void fillPaymentDetails() {
        //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.fillCreditCardCredentials();
        //15. Click 'Pay and Confirm Order' button,
        //16. Verify success message 'Your order has been placed successfully!'
        cartPage.verifyYourOrderHasBeenPlaced();
    }

    @Test(dependsOnMethods = "fillPaymentDetails")
    public void deleteAccount() {
        //17. Click 'Delete Account' button
        TopBarClicks(TopBars.DELETE_ACCOUNT);
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        sUpLogin.verifyAccountDeleted();
    }

}
