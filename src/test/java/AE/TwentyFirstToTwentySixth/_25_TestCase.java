package AE.TwentyFirstToTwentySixth;

import org.testng.annotations.Test;
import utilities.TestBase;

public class _25_TestCase extends TestBase {

        @Test
    public void scrollDown() {
//        4. Scroll down page to bottom
            homePage.scrollDownToEnd();
//        5. Verify 'SUBSCRIPTION' is visible
            homePage.verifySubsTxt();
        }
        @Test(dependsOnMethods = {"scrollDown"})
    public void moveUpward(){
//        6. Click on arrow at bottom right side to move upward

            //sometimes there will be an adds in a shadowRoot you must open that.Then click to the down for the below add;
            homePage.scrollUpToTheTop();
//        7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
           homePage.verifyFullFledgedText();
    }
}
