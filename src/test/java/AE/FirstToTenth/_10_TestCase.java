package AE.FirstToTenth;

import org.testng.annotations.Test;
import utilities.TestBase;

public class _10_TestCase extends TestBase {

    @Test
    public void subscriptionTest(){
       //4. Scroll down to footer
        homePage.scrollDownToEnd();
       //5. Verify text 'SUBSCRIPTION'
        homePage.verifySubsTxt();
       //6. Enter email address in input and click arrow button
        homePage.enterEmailtoSubsBox();
       //7. Verify success message 'You have been successfully subscribed!' is visible
        homePage.verifySubsSuccessAlert();
    }
}
