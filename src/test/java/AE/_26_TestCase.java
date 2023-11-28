package AE;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;
public class _26_TestCase extends TestBase {
ExtentSparkReporter html;
ExtentReports extentReport;
ExtentTest test1;
ExtentTest test2;
ExtentTest test3;

    @BeforeTest
    public void extentTester(){
        html = new ExtentSparkReporter(System.getProperty("user.dir")+"test-output/ExtentReport.html");
        extentReport =  new ExtentReports();
        extentReport.attachReporter(html);
        test1 = extentReport.createTest("Test 1","Test tanimi-1");
        test2 = extentReport.createTest("Test 2","Test tanimi-2");
        test3 = extentReport.createTest("Test 3","Test tanimi-3");
    }
    @AfterTest
    public void tearDown(){
        extentReport.setSystemInfo("Tester","Ahmet");
        extentReport.setSystemInfo("OS",System.getProperty("os.name"));
        extentReport.setSystemInfo("Project Dir",System.getProperty("user.dir"));
        extentReport.flush();
    }
    @Test
    public void first() {
        test1.info("Sayfa acilis testi basladi");
//    2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//            3. Verify that home page is visible successfully
        try {
            verifyMainPage();
            test1.pass("Test 1 Passed");
        } catch (AssertionError e) {
            test1.fail("Test1 failed, "+ e.getMessage());
            Assert.fail(e.getMessage());
        }
        test1.info("Sayfa acilis testi bitti");
    }
    @Test(dependsOnMethods = {"first"})
public void scrollDownBottom(){
        test2.info("scroll down to bottom test initialized");
//4. Scroll down page to bottom
        scrollIntoWiev(lSubsTextDownPage);
//5. Verify 'SUBSCRIPTION' is visible
        try {
            verifyVisibility(lSubsTextDownPage);
            test2.pass("Test 2 Passed");
        } catch (AssertionError e) {
            test2.fail("Test 2 failed, "+ e.getMessage());
            Assert.fail(e.getMessage());
        }
        test2.info("Scroll down to bottom test finished");
    }
    @Test(dependsOnMethods = {"scrollDownBottom"})
    public void scrollUp() {
        test3.info("scroll up to top test initialized");
//6. Scroll up page to top
        scrollIntoWiev(lmainPage);
//7. Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen
        try {
            verifyVisibility(lFullFledgedtxt);
            test3.pass("Test 3 Passed");
        } catch (AssertionError e) {
            test3.fail("Test 3 failed, "+ e.getMessage());
            Assert.fail(e.getMessage());
        }
        test3.info("Scroll up to top test finished");

    }
}
