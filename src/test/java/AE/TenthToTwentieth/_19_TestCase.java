
package AE.TenthToTwentieth;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;
public class _19_TestCase extends TestBase{
    @Test
    public void viewAndCartBrandProducts(){
//        2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//        3. Click on 'Products' button
        click(lProducts);
//        4. Verify that Brands are visible on left side bar
        verifyVisibility(lBrands);
//        5. Click on any brand name
        WebElement ePoloBrand = driver.findElement(lPoloBrand);
jse.executeScript("arguments[0].scrollIntoView();",ePoloBrand);
        click(ePoloBrand);

//        6. Verify that user is navigated to brand page and brand products are displayed

        verifyVisibility(lPoloBrandPageTxt);
//        7. On left side bar, click on any other brand link
        WebElement eHmBrand = driver.findElement(lHMbrand);
        click(eHmBrand);
//        8. Verify that user is navigated to that brand page and can see products
        verifyVisibility(lHmBrandPageTxt);
    }

}
