package AE.FirstToTenth;

import Pages.ContactUs.ContactUs;
import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _6_TestCase extends TestBase {
    HomePage homePage;
    ContactUs cu;
    @BeforeTest
    public void setup(){
        cu = new ContactUs();
        homePage = new HomePage();
    }
    @Test
    public void initial(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }
    @Test(dependsOnMethods = {"initial"})
    public void contactUsFrom() {
        // 4. Click on 'Contact Us' button
        homePage.TopBarClicks(TopBars.CONTACT_US);
        // 5. Verify 'GET IN TOUCH' is visible
        cu.verifyGetInTouch();
        // 6. Enter name, email, subject and message
        cu.enterCredentialsAndMessage();
        // 7. Upload file
        cu.uploadFile();
        // 8. Click 'Submit' button
        cu.submit();
    }
    @Test(dependsOnMethods = {"contactUsFrom"})
    public void verifySuccesNBackHome(){
       // 9. Click OK button
        cu.acceptAlert();
       // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        cu.verifySuccessText();
       // 11. Click 'Home' button and verify that landed to home page successfully
     homePage.TopBarClicks(TopBars.HOME);
        homePage.verifyMainPage();
    }
}
