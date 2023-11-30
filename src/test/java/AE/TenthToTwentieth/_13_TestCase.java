package AE.TenthToTwentieth;

import AE.Pages.HomePage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _13_TestCase extends TestBase {
    @Test
    public void productQuantity(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
        //4. Click 'View Product' for any product on home page
        click(lviewProduct);
       //5. Verify product detail is opened
verifyVisibility(lviewProduct);
       //6. Increase quantity to 4
sendKeys(lQuantityBox, "4");
       //7. Click 'Add to cart' button
click(lAddtoCartButtonPrdctPage);
       //8. Click 'View Cart' button
click(lWievCart);
       //9. Verify that product is displayed in cart page with exact quantity
        String expectedQuantity = "4";
        String actualQuantity = driver.findElement(lCartQuantityBox).getText();
        Assert.assertEquals(expectedQuantity,actualQuantity);


    }
}
