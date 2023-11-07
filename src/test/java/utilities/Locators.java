package utilities;

import org.openqa.selenium.By;

public interface Locators {
    By lmainPage = By.xpath("//div[@class='logo pull-left']");
     By lProductButton = By.xpath("//*[text()=' Products']");
By lAddToCartButton = By.xpath("(//a[@data-product-id='1'])[1]");
By lAddToCartButton2 = By.xpath("(//a[@data-product-id='2'])[1]");
By lContinueShopping = By.xpath("//*[.='Continue Shopping']");
By lWievCart = By.xpath("//*[text()='View Cart']");

}
