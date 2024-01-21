package AE.FirstToTenth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static Pages.Signup_LoginPage.SUpLogiLocators.lAlreadyExistTxt;

public class _5_TestCase extends TestBase {

    @Test
    public void initial(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }
    @Test(dependsOnMethods = {"initial"})
    public void ExistingEmail() {
        // 4. Click on 'Signup / Login' button
        TopBarClicks(TopBars.SIGNUP_LOGIN);
        // 5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
        sUpLogin.alreadyExistEmail();
    }
    @Test(dependsOnMethods = {"ExistingEmail"})
    public void ErrorTest(){
        //8. Verify error 'Email Address already exist!' is visible
    verifyVisibility(lAlreadyExistTxt);
    }

}