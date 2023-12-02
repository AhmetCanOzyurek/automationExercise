package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Signup_LoginPage.SUpLogin;
import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;

public class _1_Case extends TestBase {
    @Test
    public void Test01() throws InterruptedException {
        HomePage homePage = new HomePage();
      // 1. Launch browser
       // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
       // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
       // 4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
       // 5. Verify 'New User Signup!' is visible
       // 6. Enter name and email address
        // 7. Click 'Signup' button
        //  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //  9. Fill details: Title, Name, Email, Password, Date of birth
        // name and email box already filled cause faker class
        //  10. Select checkbox 'Sign up for our newsletter!'
        //  11. Select checkbox 'Receive special offers from our partners!'
        //  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //  13. Click 'Create Account button'
        /**
         * All in one method
         */
        SUpLogin sUpLogin = new SUpLogin();
        sUpLogin.newUserSignUp();
      //  14. Verify that 'ACCOUNT CREATED!' is visible
      //  15. Click 'Continue' button//*[text()='Continue']
        sUpLogin.verifyAccountCreated();
      //  16. Verify that 'Logged in as username' is visible//*[text()=' Logged in as ']
        sUpLogin.verifyloggedAsUN();
       // 17. Click 'Delete Account' button//*[text()=' Delete Account']
        homePage.TopBarClicks(TopBars.DELETE_ACCOUNT);
         // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        verifyVisibility(lAccountDeletedTxt);
      click(lContinueAfterAccountCreated);
//
    }
}
