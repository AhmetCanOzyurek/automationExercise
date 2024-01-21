package AE.FirstToTenth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static Pages.Signup_LoginPage.SUpLogiLocators.lLoginTxt;

public class _4_TestCAse extends TestBase {

    @Test(dependsOnMethods = {"initial"})
    public void loginTest() {
        //4. Click on 'Signup / Login' button
        TopBarClicks(TopBars.SIGNUP_LOGIN);
        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        sUpLogin.Login();
        //8. Verify that 'Logged in as username' is visible
        sUpLogin.verifyloggedAsUN();
    }
    @Test(dependsOnMethods = {"loginTest"})
    public void logoutTest() {
        //9. Click 'Logout' button
        TopBarClicks(TopBars.LOGOUT);
        //10. Verify that user is navigated to login page
        verifyVisibility(lLoginTxt);
    }
}
