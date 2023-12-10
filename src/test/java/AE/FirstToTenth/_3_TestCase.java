package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import Pages.Signup_LoginPage.SUpLogin;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _3_TestCase extends TestBase {
    HomePage homePage;
    SUpLogin sUpLogin;
    @BeforeTest
    public void setup(){
    homePage = new HomePage();
    sUpLogin = new SUpLogin();
    }
     @Test(priority = 1)
     public void initial(){
         // 1. Launch browser
         // 2. Navigate to url 'http://automationexercise.com'
         homePage.navigateToSite();
         // 3. Verify that home page is visible successfully
         homePage.verifyMainPage();
     }
    @Test(priority = 2)
    public void incorrectUser(){
        //4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
        //5. Verify 'Login to your account' is visible
      //6. Enter incorrect email address and password
        //7. Click 'login' button
        //8. Verify error 'Your email or password is incorrect!' is visible
        sUpLogin.IncorrectLogin();
    }

}
