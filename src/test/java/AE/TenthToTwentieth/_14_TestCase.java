package AE.TenthToTwentieth;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;
public class _14_TestCase extends TestBase {
    @Test
    public void RegisterWhileCheckout(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'

        navigateToSite();
//        3. Verify that home page is visible successfully
        verifyVisibility(lmainPage);
//        4. Add products to cart
        addProductsToCart(3);
//        5. Click 'Cart' button
        click(lCart);
//        6. Verify that cart page is displayed
        verifyVisibility(lShoppingCartTxt);
//        7. Click Proceed To Checkout
        click(lProceedToChckout);
//        8. Click 'Register / Login' button
        click(lRegisterLoginChckout);
//        9. Fill all details in Signup and create account
        newUserSignUp();
//        10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        verifyVisibility(lAccountCreatedText);
//        11. Verify ' Logged in as username' at top
        verifyVisibility(lLoggedAsUsernameTxt);
//        12.Click 'Cart' button
        click(lCart);
//        13. Click 'Proceed To Checkout' button
        click(lProceedToChckout);
//        14. Verify Address Details and Review Your Order
        verifyAdressDetails();
//        15. Enter description in comment text area and click 'Place Order'
        WebElement eCommentTxtArea = driver.findElement(lDescription);
        eCommentTxtArea.sendKeys("Bana tokanma");
        click(lPlaceOrder);
//        16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        fillCreditCardCredentials();
//        17. Click 'Pay and Confirm Order' button
//        18. Verify success message 'Your order has been placed successfully!'
        verifyYourOrderHasBeenPlaced();
//        19. Click 'Delete Account' button
        click(lDeleteAccount);
//        20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
verifyVisibility(lAccountDeletedTxt);    }
}
