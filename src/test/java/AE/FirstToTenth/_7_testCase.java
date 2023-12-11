package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;
import static Pages.HomePage.HomePageLocators.*;

public class _7_testCase extends TestBase {
    HomePage homePage;
    @BeforeTest
    public void setup(){
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
    public void testCasesPage(){
      //4. Click on 'Test Cases' button
        homePage.TopBarClicks(TopBars.TEST_CASES);
      //5. Verify user is navigated to test cases page successfully
       verifyVisibility(lTestCaseSign);
    }
}
