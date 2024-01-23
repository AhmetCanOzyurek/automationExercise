package AE.TwentyFirstToTwentySixth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.lAllProductsTxt;

public class _21_TestCase extends TestBase {
    @Test
    public void clickAndVerifyProductPage() {
//        3. Click on 'Products' button
        TopBarClicks(TopBars.PRODUCTS);
//        4. Verify user is navigated to ALL PRODUCTS page successfully
        verifyVisibility(lAllProductsTxt);
    }
    @Test(dependsOnMethods = "clickAndVerifyProductPage")
    public void viewProduct(){
//        5. Click on 'View Product' button
        products.clickFIViewProduct();
//        6. Verify 'Write Your Review' is visible
//        7. Enter name, email and review
//        8. Click 'Submit' button
//        9. Verify success message 'Thank you for your review.'
        products.writeAReview("Ahmet","a@gmail.com","helavelavelvela");
    }
}
