package AE.FirstToTenth;

import Pages.HomePage.TopBars;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class _8_TestCasse extends TestBase {

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
        // 6. The products list is visible
        products.verifyProductsList();
    }
    @Test(dependsOnMethods = {"verifyAllProductsTest"})
    public void verifyProductsDetailPageTest()
    {
       // 7. Click on 'View Product' of first product
        products.clickFIViewProduct();
       // 8. User is landed to product detail page
       products.verifyProductsDetailPage();
    }
    @Test(dataProvider = "productDetails",dependsOnMethods = {"verifyProductsDetailPageTest"})
    public void verifyDetails(String details){
        // 9. Verify that detail is visible: product name, category, price, availability, condition, brand
        products.verifyProductDetails(details);
    }
    @DataProvider
    public Object[][] productDetails(){
        return new Object[][]{
                {"Blue Top"},
                {"Category:"},
                {"Rs. 500"},
                {"Availability:"},
                {"Condition:"},
                {"Brand:"},
        };
    }
}
