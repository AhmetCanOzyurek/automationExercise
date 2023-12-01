package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import  utilities.TestBase;
import static utilities.Locators.*;
public class _16_TestCase extends TestBase {

    @Test
    public void placeOrderCheckout(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
       //4. Click 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
       //5. Fill all details in Signup and create account
        newUserSignUp();
       //6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
        verifyVisibility(lAccountCreatedText);
click(By.linkText("Continue"));
       //7. Verify ' Logged in as username' at top
verifyVisibility(By.partialLinkText("Logged"));
       //8. Add products to cart
addProductsToCart(3);
       //9. Click 'Cart' button
        click(lCart);
       //10. Verify that cart page is displayed
        verifyVisibility(lShoppingCartTxt);
        //11. Click Proceed To Checkout
        click(lProceedToChckout);
       //12. Verify Address Details and Review Your Order
        verifyAdressDetails();
       //13. Enter description in comment text area and click 'Place Order'
        sendKeys(lDescription, "bana tokanma");
        click(lPlaceOrder);
       //14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
        fillCreditCardCredentials();
       //15. Click 'Pay and Confirm Order' button,
       //16. Verify success message 'Your order has been placed successfully!'
        driver.navigate().back();
        verifyVisibility(By.cssSelector("div[id = 'success_message']"));
        click(By.cssSelector("#submit"));
        bekle(3);
        click(By.xpath("//*[text()='Continue']"));
       //17. Click 'Delete Account' button
        click(By.xpath("//*[text()=' Delete Account']"));
       //18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
        click(By.xpath("//*[text()='Account Deleted!']"));
    }

}
