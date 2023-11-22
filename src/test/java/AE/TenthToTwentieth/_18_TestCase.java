package AE.TenthToTwentieth;

import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;
public class _18_TestCase extends TestBase {
    @Test
    public void ViewCategoryProducts(){
//        1. Launch browser
//        2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
//        3. Verify that categories are visible on left side bar
        verifyVisibility(lCategoryLeftSide);
//        4. Click on 'Women' category
        click(lWomenCategoru);
//        5. Click on any category link under 'Women' category, for example: Dress
        click(lWomenDress);
//        6. Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS'
        verifyVisibility(lWomenDressText);
//        7. On left side bar, click on any sub-category link of 'Men' category
        click(lMenCategoru);
        click(lMenTshirt);
//        8. Verify that user is navigated to that category page
        verifyVisibility(lMenTshirtPageTxt);
    }

}
