package AE.FirstToTenth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static Pages.HomePage.HomePageLocators.lTestCaseSign;

public class _7_testCase extends TestBase {

    
    @Test(dependsOnMethods = {"initial"})
    public void testCasesPage(){
      //4. Click on 'Test Cases' button
        TopBarClicks(TopBars.TEST_CASES);
      //5. Verify user is navigated to test cases page successfully
       verifyVisibility(lTestCaseSign);
    }
}
