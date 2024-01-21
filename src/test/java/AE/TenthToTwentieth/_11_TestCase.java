package AE.TenthToTwentieth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _11_TestCase extends TestBase {

    @Test
    public void CartNVerify() {
        //4. Click 'CartPage' button
        TopBarClicks(TopBars.CART);
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
