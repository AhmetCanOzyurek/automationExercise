package AE.FirstToTenth;

import Pages.HomePage.TopBars;
import org.testng.annotations.Test;
import utilities.TestBase;
public class _9_TestCase extends TestBase {

    @Test
    public void initial(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }
    @Test(dependsOnMethods = {"initial"})
    public void verifyAllProductsTest() {
        // 4. Click on 'Products' button
        homePage.TopBarClicks(TopBars.PRODUCTS);
        // 5. Verify user is navigated to ALL PRODUCTS page successfully
        products.verifyAllProductsTxt();
    }
    @Test(dependsOnMethods = "verifyAllProductsTest")
    public void searchTest()
    {
      // 6. Enter product name in search input and click search button
        products.productSearching("Blue");
      // 7. Verify 'SEARCHED PRODUCTS' is visible
        products.veriyfSearchedProducts();
    }
    @Test(dependsOnMethods = "searchTest")
    public void SearchRelatedProducts()
    {
      // 8. Verify all the products related to search are visible
        products.verifySearchRelatedProducts("blue");
    }
}
