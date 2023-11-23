package AE;

import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _21_TestCase extends TestBase {
    @Test
    public void addReviewOnProduct(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//        3. Click on 'Products' button
        click(lProductsTopBar);
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
