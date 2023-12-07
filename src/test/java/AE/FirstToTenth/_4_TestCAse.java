package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Signup_LoginPage.SUpLogin;
import org.testng.annotations.Test;
import utilities.TestBase;
import static Pages.Signup_LoginPage.SUpLogiLocators.*;

public class _4_TestCAse extends TestBase {
    @Test
    public void logoutUserTest(){
        HomePage homePage = new HomePage();
        SUpLogin sUpLogin = new SUpLogin();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        //4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
        //5. Verify 'Login to your account' is visible
        //6. Enter correct email address and password
        //7. Click 'login' button
        sUpLogin.Login();
        //8. Verify that 'Logged in as username' is visible
        sUpLogin.verifyloggedAsUN();
        //9. Click 'Logout' button
        homePage.TopBarClicks(TopBars.LOGOUT);
        //10. Verify that user is navigated to login page
        verifyVisibility(lLoginTxt);
    }
}
