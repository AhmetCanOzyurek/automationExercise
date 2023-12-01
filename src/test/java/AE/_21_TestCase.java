package AE;

import AE.Pages.HomePage.HomePage;
import AE.Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _21_TestCase extends TestBase {
    @Test
    public void addReviewOnProduct(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
//        3. Click on 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
//        4. Verify user is navigated to ALL PRODUCTS page successfully
        verifyVisibility(lAllProductsTxt);
//        5. Click on 'View Product' button
        scrollIntoWiev(lviewProduct);
        click(lviewProduct);
//        6. Verify 'Write Your Review' is visible
//        7. Enter name, email and review
//        8. Click 'Submit' button
//        9. Verify success message 'Thank you for your review.'
        writeAReview("Ahmet","a@gmail.com","thanks for the beatiful product");

    }
}
