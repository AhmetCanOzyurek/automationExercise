package AE.TenthToTwentieth;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utilities.TestBase;
import static utilities.Locators.*;
public class _17_TestCase extends TestBase {
    @Test
    public void removeFromCart(){
       //2. Navigate to url 'http://automationexercise.com'
        navigateToSite();
       //3. Verify that home page is visible successfully
        verifyMainPage();
       //4. Add products to cart
        addProductsToCart(7);
       //5. Click 'Cart' button
        click(lCart);
       //6. Verify that cart page is displayed
        verifyVisibility(lShoppingCartTxt);
       //7. Click 'X' button corresponding to particular product
        click(lRemoveProductFrmCart);
       //8. Verify that product is removed from the cart
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.tagName("tbody"),3));
    }
}
