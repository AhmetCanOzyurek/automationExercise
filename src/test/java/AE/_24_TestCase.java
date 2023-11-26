package AE;

import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;
public class _24_TestCase extends TestBase {
    @Test
    public void goToSite(){
        //    2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//    3. Verify that home page is visible successfully
        verifyMainPage();
    }
@Test(dependsOnMethods = {"goToSite"})
    public void addProducts() {
//4. Add products to cart
addProductsToCart(3);
//5. Click 'Cart' button
    click(lCart);
//6. Verify that cart page is displayed
    verifyVisibility(lShoppingCartTxt);
}
@Test(dependsOnMethods = {"addProducts"})
    public void newUserLogin() {
//7. Click Proceed To Checkout
    click(lProceedToChckout);
//8. Click 'Register / Login' button
    click(lRegisterLoginChckout);
//9. Fill all details in Signup and create account
    newUserSignUp();
//10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    verifyVisibility(lAccountCreatedText);
    click(lContinueAfterAccountCreated);
//11. Verify ' Logged in as username' at top
    verifyVisibility(lLoggedAsUsernameTxt);
}
@Test(dependsOnMethods = {"newUserLogin"})
    public void verifyAdress() {
//12.Click 'Cart' button
    click(lCart);
//13. Click 'Proceed To Checkout' button
    click(lProceedToChckout);
//14. Verify Address Details and Review Your Order
    verifyAdressDetails();
//15. Enter description in comment text area and click 'Place Order'
    sendKeys(lDescription,"muz");
    click(lPlaceOrder);
}
@Test(dependsOnMethods = {"verifyAdress"})
    public void payments() {
//16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    fillCreditCardCredentials();
//17. Click 'Pay and Confirm Order' button
//18. Verify success message 'Your order has been placed successfully!'
verifyVisibility(lOrderPlacedTxt);
}
@Test(dependsOnMethods = {"payments"})
public void downloadInvoice() {
//19. Click 'Download Invoice' button and verify invoice is downloaded successfully.
    click(lDownloadInvoice);
    verifyFileDownloaded();
//20. Click 'Continue' button
    click(lContinueAfterAccountCreated);
}
@Test(dependsOnMethods = {"downloadInvoice"})
    public void deleteAccount(){
//21. Click 'Delete Account' button
    click(lDeleteAccount);
//22. Verify 'ACCOUNT DELETED!' and click 'Continue' button
    verifyVisibility(lAccountDeletedTxt);
}

}
