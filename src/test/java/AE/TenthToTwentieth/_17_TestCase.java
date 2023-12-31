package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;
public class _17_TestCase extends TestBase {
    @Test
    public void removeFromCart(){
        HomePage homePage = new HomePage();
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
       //4. Add products to cartPage
        addProductsToCart(7);
       //5. Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
       //6. Verify that cartPage page is displayed
        verifyVisibility(lShoppingCartTxt);
       //7. Click 'X' button corresponding to particular product
        click(lRemoveProductFrmCart);
       //8. Verify that product is removed from the cartPage
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tbody"),3));
    }
}
