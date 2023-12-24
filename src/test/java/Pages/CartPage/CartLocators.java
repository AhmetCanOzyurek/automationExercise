package Pages.CartPage;

import org.openqa.selenium.By;

public interface CartLocators {
    By lShoppingCartTxt = By.xpath("//*[text()='Shopping Cart']");
    By lProceedToChckout =  By.xpath("//*[text()='Proceed To Checkout']");
    By lRegisterLoginChckout = By.xpath("//*[text()='Register / Login']");
    By lDescription = By.cssSelector(".form-control");
    By lPlaceOrder = By.xpath("//*[text()='Place Order']");
    By lNameOnCard = By.xpath("//*[@name='name_on_card']");

}
