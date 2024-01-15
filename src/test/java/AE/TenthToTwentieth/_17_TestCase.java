package AE.TenthToTwentieth;

import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.lRemoveProductFrmCart;
import static utilities.Locators.lShoppingCartTxt;
public class _17_TestCase extends TestBase {
    @Test
    public void addProductsToCartPage() {
        //4. Add products to cartPage
        addProductsToCart(7);
    }
    @Test(dependsOnMethods = "addProductsToCartPage")
    public void verifyProductsInCartPage() {
        //5. Click 'CartPage' button
        homePage.TopBarClicks(TopBars.CART);
        //6. Verify that cartPage page is displayed
        verifyVisibility(lShoppingCartTxt);
    }
    @Test(dependsOnMethods = "verifyProductsInCartPage")
    public void removeProductsFromCart(){
       //7. Click 'X' button corresponding to particular product
        click(lRemoveProductFrmCart);
       //8. Verify that product is removed from the cartPage
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tbody"),3));
    }
}
