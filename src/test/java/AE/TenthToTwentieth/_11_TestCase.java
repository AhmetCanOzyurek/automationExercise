package AE.TenthToTwentieth;

import Pages.CartPage.CartPage;
import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _11_TestCase extends TestBase {
    HomePage homePage;
    CartPage cartPage;

    @BeforeTest
    public void initial() {
        cartPage = new CartPage();
        homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }

    @Test
    public void CartNVerify() {
        //4. Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
        //5. Scroll down to footer.
        cartPage.scrollDownToEnd();
        //6. Verify text 'SUBSCRIPTION'
        cartPage.verifySubsTxt();
    }

    @Test(dependsOnMethods = "CartNVerify")
    public void enterEmailNVerify() {
        //7. Enter email address in input and click arrow button
        cartPage.enterEmailtoSubsBox();
        //8. Verify success message 'You have been successfully subscribed!' is visible,
        cartPage.verifySubsSuccessAlert();
    }
}
