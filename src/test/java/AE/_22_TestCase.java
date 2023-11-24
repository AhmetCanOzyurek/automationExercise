package AE;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _22_TestCase extends TestBase {
    @Test
    public void RecommendedItems(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//        3. Scroll to bottom of page
        actions.sendKeys(Keys.END);
//        4. Verify 'RECOMMENDED ITEMS' are visible
        verifyVisibility(lRecommendItemsTxt);
//        5. Click on 'Add To Cart' on Recommended product
        scrollIntoWiev(lRecommendItemsTxt);
        click(lRecommendedAddToCart);
//        6. Click on 'View Cart' button
        click(lWievCart);
//        7. Verify that product is displayed in cart page
        assertItemNames("Blue Top", lBlueTop);
    }
}
