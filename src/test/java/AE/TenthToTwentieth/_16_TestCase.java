package AE.TenthToTwentieth;

import Pages.CartPage.CartPage;
import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Signup_LoginPage.SUpLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _16_TestCase extends TestBase {
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
    public void signUp() {
        //4. Click 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
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
        homePage.TopBarClicks(TopBars.CART);
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
        homePage.TopBarClicks(TopBars.DELETE_ACCOUNT);
        //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        sUpLogin.verifyAccountDeleted();
    }

}
