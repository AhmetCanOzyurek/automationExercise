package Pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utilities.TestBase;

import java.util.List;

import static Pages.Products.ProductsLocators.*;

public class Products extends TestBase {

    public void verifyAllProductsTxt(){
        verifyVisibility(lAllproductsTxt);
    }
    public void verifyProductsList(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lAllPrductsList,0));
    }
    public void clickFIViewProduct(){
        scrollIntoWiev(lViewProduct);
        click(lViewProduct);
    }
    public void verifyProductsDetailPage(){
        verifyVisibility(lProductDetails);
    }

    public void verifyProductDetails(String text){
        By lProductDetails = By.xpath("//*[contains(text(),'"+text+"')]");
        verifyVisibility(lProductDetails);
    }
    public void veriyfSearchedProducts(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(lSearchRelatedProducts,0));
    }
    public void verifySearchRelatedProducts(String queryText){
        List<WebElement> searchProducts = driver.findElements(lSearchRelatedProducts);
        String queryTextFletterBig ="";
        int sayac =0;
        for (WebElement e : searchProducts) {
            String eTxt = e.getText();
            queryTextFletterBig = queryText.substring(0,1).toUpperCase()+queryText.substring(1);

            if(eTxt.contains(queryTextFletterBig) || eTxt.contains(queryText.toUpperCase())||eTxt.contains(queryText.toLowerCase())){
                sayac++;
            }
        }
        Assert.assertEquals(sayac,searchProducts.size());
    }

    public void productSearching(String productName){
        sendKeys(lProductSearchBox,productName);
        click(lProductSearchSubmit);
    }


}
