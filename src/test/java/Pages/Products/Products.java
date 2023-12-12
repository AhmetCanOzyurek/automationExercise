package Pages.Products;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase;

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


}
