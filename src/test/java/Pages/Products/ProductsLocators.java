package Pages.Products;

import org.openqa.selenium.By;

public interface ProductsLocators {
    By lAllproductsTxt= By.xpath("//h2[@class='title text-center']");
    By lAllPrductsList = By.xpath("//div[@class='product-image-wrapper']");
By lViewProduct = By.xpath("(//*[text()='View Product'])[1]");
By lProductDetails = By.xpath("//div[@class='product-details']");

}
