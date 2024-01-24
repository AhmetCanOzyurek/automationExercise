package AE.TwentyFirstToTwentySixth;

import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.lBlueTop;

public class _22_TestCase extends TestBase {
    @Test
    public void scrollDownAndVerifyRecommendedItems(){
//        3. Scroll to bottom of page
        homePage.scrollDownToEnd();
//        4. Verify 'RECOMMENDED ITEMS' are visible
        homePage.verifyRecommendedItems();}

    /**
     * (add To Cart Recommended Items And Verify Product Is Visible In Cart Page)
     */
        @Test
        public void addToCartRecommendedItemsAndVerifyProductIsVisibleInCartPage(){
//        5. Click on 'Add To CartPage' on Recommended product
        homePage.addToCartRecommmendedItem();
//        6. Click on 'View CartPage' button
        homePage.clickViewCart();
//        7. Verify that product is displayed in cart page
        homePage.assertItemNames("Blue Top", lBlueTop);
    }
}
