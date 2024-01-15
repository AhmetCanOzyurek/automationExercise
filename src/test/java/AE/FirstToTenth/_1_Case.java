package AE.FirstToTenth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utilities.TestBase;
import utility.Driver;

import static utilities.Locators.lAccountDeletedTxt;
import static utilities.Locators.lContinueAfterAccountCreated;

public class _1_Case extends TestBase {
    ExtentSparkReporter html;
    ExtentReports extentReport;
    ExtentTest test1;
    ExtentTest test2;
    ExtentTest test3;
    ExtentTest test4;

    @BeforeTest
    public void setUp(){

        html = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport.html");
        extentReport =  new ExtentReports();
        extentReport.attachReporter(html);
        test1 = extentReport.createTest("Test 1","Test tanimi-1");
        test2 = extentReport.createTest("Test 2","Test tanimi-2");
        test3 = extentReport.createTest("Test 3","Test tanimi-3");
        test4 = extentReport.createTest("Test 4","Test tanimi-4");
    }
    @AfterTest
    public void tearDown(){
        extentReport.setSystemInfo("Tester","Ahmet");
        extentReport.setSystemInfo("OS",System.getProperty("os.name"));
        extentReport.setSystemInfo("Project Dir",System.getProperty("user.dir"));
        extentReport.flush();
        Driver.getDriver().quit();
    }
    @Test(priority = 1)
    public void goToSite(){
        test1.info("Sayfa acilis testi basladi");
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        try {
            homePage.verifyMainPage();
            test1.pass("Test 1 Passed");
        } catch (AssertionError e) {
            test1.fail("Test1 failed, "+ e.getMessage());
            Assert.fail(e.getMessage());
        }
        test1.info("Sayfa acilis testi bitti");
    }
    @Test(priority = 1)
    public void accountCreate() {
        test2.info("Account create test initialize");
        // 4. Click on 'Signup / Login' button
        homePage.TopBarClicks(TopBars.SIGNUP_LOGIN);
        // 5. Verify 'New User Signup!' is visible
        // 6. Enter name and email address
        // 7. Click 'Signup' button
        //  8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        //  9. Fill details: Title, Name, Email, Password, Date of birth
        // name and email box already filled cause faker class
        //  10. Select checkbox 'Sign up for our newsletter!'
        //  11. Select checkbox 'Receive special offers from our partners!'
        //  12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //  13. Click 'Create Account button'

        try {
            //all up there is in this method
            sUpLogin.newUserSignUp();
            test2.pass("Test 2 PASSED");
        }catch (AssertionError e){
            test2.fail("Test 2 failed, "+ e.getMessage());
            Assert.fail(e.getMessage());
        }
        test2.info("Account create test finished");

    }
    @Test(priority = 2)
    public void verifyAccount() {
        test3.info("Verify Account test initialize");
        try {
            //  14. Verify that 'ACCOUNT CREATED!' is visible
            //  15. Click 'Continue' button//*[text()='Continue']
            sUpLogin.verifyAccountCreated();
            //  16. Verify that 'Logged in as username' is visible//*[text()=' Logged in as ']
            sUpLogin.verifyloggedAsUN();
            test3.pass("Test 3 PASSED");
        }catch (AssertionError e){
            test3.fail("Test 3 failed, "+ e.getMessage());
            Assert.fail(e.getMessage());
        }
        test3.info("Verify account test finished");

    }
    @Test(priority = 3)
    public void deleteAccount(){
        test4.info("Delete account test initialized");
       // 17. Click 'Delete Account' button//*[text()=' Delete Account']
        homePage.TopBarClicks(TopBars.DELETE_ACCOUNT);

        try {
            // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
            verifyVisibility(lAccountDeletedTxt);
            test4.pass("Test 4 PASSED");
        }catch (AssertionError e){
            test4.fail("Test 4 FAİLED, "+e.getMessage());
            Assert.fail(e.getMessage());
        }
      click(lContinueAfterAccountCreated);
    }
}
