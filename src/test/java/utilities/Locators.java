package utilities;

import org.openqa.selenium.By;

public interface Locators {
    By lmainPage = By.xpath("//div[@class='logo pull-left']");
    By lProductButton = By.xpath("//*[text()=' Products']");
    By lAddToCartButton = By.xpath("(//a[@data-product-id='1'])[1]");
    By lAddToCartButton2 = By.xpath("(//a[@data-product-id='2'])[1]");
    By lContinueShopping = By.xpath("//*[.='Continue Shopping']");
    By lCart = By.xpath("//a[text()=' Cart']");
    By lShoppingCartTxt = By.xpath("//*[text()='Shopping Cart']");
    By lWievCart = By.xpath("//*[text()='View Cart']");
    By lviewProduct = By.xpath("(//*[text()='View Product'])[1]");
    By lProductDetails = By.xpath("//div[@class = 'product-details']");
    By lQuantityBox = By.cssSelector("#quantity");
    By lIncreaseQuantity = By.cssSelector("#product_id");
    By lAddtoCartButtonPrdctPage = By.xpath("//button[@class ='btn btn-default cart']");
    By  lCartQuantityBox = By.xpath("//*[@class='cart_quantity']");
    By lNewUserSignupNameBox = By.xpath("//*[@*='signup-name']");
By lNewUserSignupEmailBox = By.xpath("//*[@*='signup-email']");
By lNewUserSignupButton = By.xpath("//*[text()='Signup']");
//Enter Account Info
By lGenderRadioMr = By.cssSelector("#id_gender1");
By lPasswordBox = By.xpath("//input[@name='password']");
By lCheckBox1 = By.xpath("(//input[@type='checkbox'])[1]");
By lCheckBox2 = By.xpath("(//input[@type='checkbox'])[2]");
By lCountryDDM = By.cssSelector("#country");

// Checkout
    By lDescription = By.cssSelector(".form-control");
By lPlaceOrder = By.xpath("//*[text()='Place Order']");


//Payment
    By lNameOnCard = By.xpath("//*[@name='name_on_card']");



}
