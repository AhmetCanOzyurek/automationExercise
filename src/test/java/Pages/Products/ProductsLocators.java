package Pages.Products;

import org.openqa.selenium.By;

public interface ProductsLocators {
    By lAllproductsTxt = By.xpath("//h2[@class='title text-center']");
    By lAllPrductsList = By.xpath("//div[@class='product-image-wrapper']");
    By lViewProduct = By.xpath("(//*[text()='View Product'])[1]");
    By lProductDetails = By.xpath("//div[@class='product-details']");
    By lProductSearchBox = By.xpath("//*[@placeholder='Search Product']");
    By lProductSearchSubmit = By.xpath("//*[@id='submit_search']");
    By lSearchRelatedProducts = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
    By lAddToCartButtonOfFirstProduct = By.xpath("(//a[@data-product-id='1'])[1]");
    By lAddToCartButtonSecondProduct = By.xpath("(//a[@data-product-id='2'])[1]");
    By lContinueShoppingAfterAddToCart = By.xpath("//*[.='Continue Shopping']");
    By lWievCartAfterAdding = By.xpath("//*[text()='View Cart']");
    By lviewProduct = By.xpath("(//*[text()='View Product'])[1]");

    By lCartTableProductsHeaders = By.xpath("(//tr[contains(@id,product-)])[1]");
    By lCartTableProduct1Details = By.xpath("(//tr)[2]//td");
    By lCartTableProduct2Details = By.xpath("(//tr)[3]//td");
    By lProductPageFirstItem = By.xpath("(//div[@class = 'features_items']//div[@class = 'col-sm-4'])[1]");
    By lProductPageSecondItem = By.xpath("(//div[@class = 'features_items']//div[@class = 'col-sm-4'])[2]");

    By lQuantityBox = By.cssSelector("#quantity");
    By lAddtoCartButtonPrdctPage = By.xpath("//button[@class ='btn btn-default cart']");
    By lQuantityNumber = By.xpath("(//tr)[2]//td[4]");
    By lBrands = By.xpath("//*[text()='Brands']");
    By lPoloBrandPageTxt = By.xpath("(//*[text()='Polo'])[1]");
    By lBrandText = By.xpath("//li[@class='active']");


}
