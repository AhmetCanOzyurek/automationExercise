package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _10_TestCase extends TestBase {

    @Test
    public void subscriptionTest(){

        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
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
