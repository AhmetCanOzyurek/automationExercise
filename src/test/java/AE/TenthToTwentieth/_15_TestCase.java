package AE.TenthToTwentieth;

import Pages.CartPage.CartPage;
import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Signup_LoginPage.SUpLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _15_TestCase extends TestBase {
    HomePage homePage;
    CartPage cartPage;
    SUpLogin sUpLogin;

    @BeforeTest
    public void initial() {
        homePage = new HomePage();
        cartPage = new CartPage();
        sUpLogin = new SUpLogin();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }

    @Test
    public void addProductsAndVerifyCart () {
        // 4. Add products to cartPage
        homePage.addProductsToCart(3);
        // 5. Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
        // 6. Verify that cartPage page is displayed
        cartPage.verifyCartPage();
    }
    @Test(dependsOnMethods = "addProductsAndVerifyCart")
    public void createNewUser() {
        // 7. Click Proceed To Checkout
        cartPage.clickProceedToCheckOut();
        // 8. Click 'Register / Login' button
        cartPage.clickRegisterLoginAfterProceed();
        // 9. Fill all details in Signup and create account
        sUpLogin.newUserSignUp();
        // 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        sUpLogin.verifyAccountCreated();
        // 11. Verify ' Logged in as username' at top
        sUpLogin.verifyloggedAsUN();
    }
    @Test(dependsOnMethods = "createNewUser")
    public void clickCartAndVerifyAdressDetails(){
        // 12.Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
        // 13. Click 'Proceed To Checkout' button
        cartPage.clickProceedToCheckOut();
        // 14. Verify Address Details and Review Your Order
        sUpLogin.verifyAdressDetails();
    }
    @Test(dependsOnMethods = "clickCartAndVerifyAdressDetails")
    public void writeADescription() {
        // 15. Enter description in comment text area and click 'Place Order'
        cartPage.writeADescription("helaVelaVelvela");
    }
    @Test(dependsOnMethods = "writeADescription")
    public void fillPaymentDetailsAndVerify() {
        // 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        cartPage.fillCreditCardCredentials();
        // 17. Click 'Pay and Confirm Order' button
        // 18. Verify success message 'Your order has been placed successfully!'
        cartPage.verifyYourOrderHasBeenPlaced();
    }
    @Test(dependsOnMethods = "fillPaymentDetailsAndVerify")
    public void deleteAccount(){
        // 19. Click 'Delete Account' button
        homePage.TopBarClicks(TopBars.DELETE_ACCOUNT);
        // 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        sUpLogin.verifyAccountDeleted();
    }
}
