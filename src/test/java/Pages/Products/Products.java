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
import static utilities.Locators.*;

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
    public void verifyAmountOfAddedProductsOnCart(int numberOfProductToAssert){
        wait.until(ExpectedConditions.numberOfElementsToBe(lProductsInCart,numberOfProductToAssert));
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

    public void verifyItemDetails(String verifierKey, String verifierValue) {
        //headers key
        String[] itemHeadersArr = webelementTextToArray(lCartTableProductsHeaders);

        //item details values
        String[] firstCartItemDetailsArrays = webElementListToStrArray(lCartTableProduct1Details);

        String[] secondCartItemDetailsArrays = webElementListToStrArray(lCartTableProduct2Details);

        Map<String, String> firstItemMap = createMap(itemHeadersArr, firstCartItemDetailsArrays);
        Map<String, String> secondItemMap = createMap(itemHeadersArr, secondCartItemDetailsArrays);


        if (firstItemMap.containsKey(verifierKey)) {
            String trueValue = firstItemMap.get(verifierKey);
            Assert.assertTrue(verifierValue.equals(trueValue));
        }
        if (firstItemMap.containsKey(verifierKey)) {
            String trueValue = secondItemMap.get(verifierKey);
            Assert.assertTrue(verifierValue.equals(trueValue));
        }


    }

    public void increaseQuantity(String increaseNumber) {
        sendKeys(lQuantityBox, increaseNumber);
    }

    public void detailPageAddToCart() {
        click(lAddtoCartButtonPrdctPage);
    }

    public void verifyItemQuantity(String verifier) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(lQuantityNumber, verifier));
    }

    /**
     * @param keys
     * @param values
     * @return
     */
    private static Map<String, String> createMap(String[] keys, String[] values) {
        if (keys.length != values.length)
            throw new IllegalArgumentException("Arrays must have the same length");

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

    public String[] webElementListToStrArray(By locator) {
        List<WebElement> list = driver.findElements(locator);
        String[] arr = new String[list.size() - 1];

        for (int i = 0; i < list.size() - 1; i++) {
            arr[i] = list.get(i).getText();
        }
        arr[0] = arr[1];
        return arr;
    }

    public void verifySideBrandBar() {
        verifyVisibility(lBrands);
    }

    public void clickABrand(String brandName) {
        String dynamicXpath = "//a[contains(.,'" + brandName + "')]";
        By locator = By.xpath(dynamicXpath);
        click(locator);
    }

    public void verifyBrandPage() {
        verifyVisibility(lBrandText);
    }
    public void writeAReview(String name,
                                String email, String review){
        verifyVisibility(lWriteYourReviewtxt);
        WebElement reviewNameBox = driver.findElement(lReviewNameBox);
        WebElement reviewEmailBox = driver.findElement(lReviewEmailBox);
        WebElement reviewBox = driver.findElement(lReviewBox);
        WebElement reviewSubmit = driver.findElement(lReviewSubmit);
        scrollIntoWiev(reviewBox);

        actions.sendKeys(reviewNameBox,name)
                .sendKeys(reviewEmailBox,email)
                .sendKeys(reviewBox,review)
                .scrollToElement(reviewSubmit)
                .click(reviewSubmit)
                .build()
                .perform();
        verifyVisibility(lReviewSuccessTxt);

    }
}
