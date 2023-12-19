package Pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.TestBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Pages.Products.ProductsLocators.*;

public class Products extends TestBase {

    public void verifyAllProductsTxt() {
        verifyVisibility(lAllproductsTxt);
    }

    public void verifyProductsList() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lAllPrductsList, 0));
    }

    public void clickFIViewProduct() {
        scrollIntoWiev(lViewProduct);
        click(lViewProduct);
    }

    public void verifyProductsDetailPage() {
        verifyVisibility(lProductDetails);
    }

    public void verifyProductDetails(String text) {
        By lProductDetails = By.xpath("//*[contains(text(),'" + text + "')]");
        verifyVisibility(lProductDetails);
    }

    public void veriyfSearchedProducts() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lSearchRelatedProducts, 0));
    }

    public void verifySearchRelatedProducts(String queryText) {
        List<WebElement> searchProducts = driver.findElements(lSearchRelatedProducts);
        String queryTextFletterBig = "";
        int sayac = 0;
        for (WebElement e : searchProducts) {
            String eTxt = e.getText();
            queryTextFletterBig = queryText.substring(0, 1).toUpperCase() + queryText.substring(1);

            if (eTxt.contains(queryTextFletterBig) || eTxt.contains(queryText.toUpperCase()) || eTxt.contains(queryText.toLowerCase())) {
                sayac++;
            }
        }
        Assert.assertEquals(sayac, searchProducts.size());
    }

    public void productSearching(String productName) {
        sendKeys(lProductSearchBox, productName);
        click(lProductSearchSubmit);
    }

    public void addFirstProductToCart() {
        scrollIntoWiev(lAddToCartButtonOfFirstProduct);
        click(lAddToCartButtonOfFirstProduct);
    }

    public void addSecondProductToCart() {
        scrollIntoWiev(lAddToCartButtonSecondProduct);
        click(lAddToCartButtonSecondProduct);
    }

    public void continueAfterAdding() {
        click(lContinueShoppingAfterAddToCart);
    }

    public void viewCartAfterAdding() {
        click(lWievCartAfterAdding);
    }

    public void verifyAddedItemsInCart(int addedItems) {
        for (int i = 1; i <= addedItems; i++) {
            WebElement e = driver.findElement(By.cssSelector("#product-" + i));
            Assert.assertTrue(e.isDisplayed());
        }
    }

    public void verifyItemDetails(String verifiers) {


        String cartFirstProductDetail = driver.findElement(lCartTableProducts1).getText();
        String cartSecondProductDetail = driver.findElement(lCartTableProducts2).getText();

        Assert.assertTrue(cartFirstProductDetail.contains(verifiers));
        Assert.assertTrue(cartSecondProductDetail.contains(verifiers));


    }



    /**
     * @param keys
     * @param values
     * @return
     */
    private static Map<String, String> createMap(String[] keys, String[] values) {
        //  if(keys.length != values.length)
        //   throw new IllegalArgumentException("Arrays must have the same length");

        Map<String, String> resultMap = new HashMap<>();

        for (int i = 0; i < keys.length; i++) {
            resultMap.put(keys[i], values[i]);
        }
        return resultMap;
    }

    /**
     * @param locator
     * @return an array
     */
    public String[] webelementTextToArray(By locator) {
        WebElement element = driver.findElement(locator);

        String elementText = element.getText();

        String[] arr = elementText.split("\\s+");

        return arr;
    }

}
