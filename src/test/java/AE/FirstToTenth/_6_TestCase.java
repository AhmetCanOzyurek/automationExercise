package AE.FirstToTenth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _6_TestCase extends TestBase {

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
        TopBarClicks(TopBars.CONTACT_US);
        // 5. Verify 'GET IN TOUCH' is visible
        contactUs.verifyGetInTouch();
        // 6. Enter name, email, subject and message
        contactUs.enterCredentialsAndMessage();
        // 7. Upload file
        contactUs.uploadFile();
        // 8. Click 'Submit' button
        contactUs.submit();
    }
    @Test(dependsOnMethods = {"contactUsFrom"})
    public void verifySuccesNBackHome(){
       // 9. Click OK button
        contactUs.acceptAlert();
       // 10. Verify success message 'Success! Your details have been submitted successfully.' is visible
        contactUs.verifySuccessText();
       // 11. Click 'Home' button and verify that landed to home page successfully
     TopBarClicks(TopBars.HOME);
        homePage.verifyMainPage();
    }
}
