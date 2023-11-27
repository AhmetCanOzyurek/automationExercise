package AE;

import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _25_TestCase extends TestBase {
        @Test
        public void goToSite(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
            navigateToSite();
//        3. Verify that home page is visible successfully
            verifyMainPage();
        }
        @Test(dependsOnMethods = {"goToSite"})
    public void scrollDown() {
//        4. Scroll down page to bottom
            scrollIntoWiev(lSubsTextDownPage);
//        5. Verify 'SUBSCRIPTION' is visible
            verifyVisibility(lSubsTextDownPage);
        }
        @Test(dependsOnMethods = {"scrollDown"})
    public void moveUpward(){
//        6. Click on arrow at bottom right side to move upward

            //sometimes there will be an adds in a shadowRoot you must open that.Then click to the down for the below add;

            click(lUpwardArrow);
//        7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
            verifyVisibility(lFullFledgedtxt);
    }
}
