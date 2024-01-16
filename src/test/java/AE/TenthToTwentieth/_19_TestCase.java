
package AE.TenthToTwentieth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _19_TestCase extends TestBase {
    @Test
    public void verifyProductPage() {
//        3. Click on 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
//        4. Verify that Brands are visible on left side bar
        products.verifySideBrandBar();
//        5. Click on any brand name
        products.clickABrand("Polo");
//        6. Verify that user is navigated to brand page and brand products are displayed
        products.verifyBrandPage();
    }

    @Test(dependsOnMethods = "verifyProductPage")
    public void verifyBrands() {
//        7. On left side bar click on any other brand link
        products.clickABrand("H&M");
//        8. Verify that user is navigated to that brand page and can see products
        products.verifyBrandPage();
    }
}
