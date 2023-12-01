package AE.TenthToTwentieth;

import Pages.HomePage.HomePage;
import Pages.HomePage.TopBars;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

import static utilities.Locators.*;

public class _15_TestCase extends TestBase {
@Test
    public void placeOrder(){
    HomePage homePage = new HomePage();
    // 1. Launch browser
    // 2. Navigate to url 'http://automationexercise.com'
    homePage.navigateToSite();
    // 3. Verify that home page is visible successfully
    homePage.verifyMainPage();
   // 4. Add products to cart
    String dynmaicXpath;
    for (int i = 1; i <=4 ; i++) {
        dynmaicXpath = "(//a[@data-product-id='"+i+"'])[1]";
        element = driver.findElement(By.xpath(dynmaicXpath));
        click(element);
        click(lContinueShopping);
    }
   // 5. Click 'Cart' button
    homePage.TopBarClicks(TopBars.CART);
   // 6. Verify that cart page is displayed
    verifyVisibility(lShoppingCartTxt);
   // 7. Click Proceed To Checkout
    click(driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")));
   // 8. Click 'Register / Login' button
    click(driver.findElement(By.xpath("//*[text()='Register / Login']")));
   // 9. Fill all details in Signup and create account
    String fakerEmail = faker.internet().emailAddress();
    String fakerUsername = faker.rickAndMorty().character();
    String fakerPassword = faker.internet().password();

    sendKeys(lNewUserSignupNameBox, fakerUsername);
    sendKeys(lNewUserSignupEmailBox, fakerEmail);
    click(lNewUserSignupButton);

    ///////////
    WebElement DDMdays = driver.findElement(By.cssSelector("#days"));
    WebElement DDMmonths = driver.findElement(By.cssSelector("#months"));
    WebElement DDMyears = driver.findElement(By.cssSelector("#years"));

   WebElement ePasswordBox = driver.findElement(lPasswordBox);
click(lGenderRadioMr);


    actions.click(ePasswordBox)
            .sendKeys(fakerPassword).perform();
select = new Select(DDMdays);
select.selectByValue("1");
select = new Select(DDMmonths);
select.selectByValue("1");
select = new Select(DDMyears);
select.selectByVisibleText("2000");

WebElement eCheckBox1  = driver.findElement(lCheckBox1);
WebElement eCheckbox2 = driver.findElement(lCheckBox2);
actions.click(eCheckBox1).click(eCheckbox2)
        .sendKeys(Keys.TAB)
        .sendKeys(faker.name().firstName()+ Keys.TAB )
        .sendKeys(faker.name().lastName() + Keys.TAB)
        .sendKeys("muz" + Keys.TAB)
        .sendKeys(faker.rickAndMorty().location() + Keys.TAB)
        .sendKeys(faker.rickAndMorty().location() + Keys.TAB)
        .perform();

WebElement countryDDM = driver.findElement(lCountryDDM);
select = new Select(countryDDM);
select.selectByVisibleText("Canada");

actions.sendKeys( Keys.TAB + "hela"+ Keys.TAB)
        .sendKeys(faker.rickAndMorty().location() + Keys.TAB)
        .sendKeys("ankarara"+ Keys.TAB)
        .sendKeys(faker.address().countryCode()+ Keys.TAB)
        .sendKeys(faker.phoneNumber().cellPhone()+ Keys.ENTER).perform();

   // 10. Verify 'ACCOUNT CREATED!' and click 'Continue' button
verifyVisibility(By.xpath("//*[text()='Account Created!']"));
   // 11. Verify ' Logged in as username' at top
    verifyVisibility(By.xpath("//*[text()='Account Created!']"));
   // 12.Click 'Cart' button
    click(lCart);
   // 13. Click 'Proceed To Checkout' button
    click(driver.findElement(By.xpath("//*[text()='Proceed To Checkout']")));
   // 14. Verify Address Details and Review Your Order
    WebElement adressBox = driver.findElement(By.cssSelector("#address_delivery"));
    String actualAdressStr = adressBox.getText();
    String expectedAdress = "Canada";

    softAssert.assertTrue(actualAdressStr.contains(expectedAdress));

   // 15. Enter description in comment text area and click 'Place Order'
    sendKeys(lDescription, "bana tokanma");
    click(lPlaceOrder);
   // 16. Enter payment details: Name on Card, Card Number, CVC, Expiration date
WebElement eNameOnCardBox = driver.findElement(lNameOnCard);
actions.click(eNameOnCardBox)
        .sendKeys(faker.rickAndMorty().character() + Keys.TAB)
        .sendKeys(faker.business().creditCardNumber() + Keys.TAB)
        .sendKeys("234" + Keys.TAB)
        .sendKeys("11" + Keys.TAB)
        .sendKeys("29" + Keys.ENTER).perform();
    bekle(3);
    // 17. Click 'Pay and Confirm Order' button
   // 18. Verify success message 'Your order has been placed successfully!'
    driver.navigate().back();
    verifyVisibility(By.cssSelector("div[id = 'success_message']"));
    click(By.cssSelector("#submit"));
   bekle(3);
    click(By.xpath("//*[text()='Continue']"));
   // 19. Click 'Delete Account' button
    click(By.xpath("//*[text()=' Delete Account']"));
   // 20. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     click(By.xpath("//*[text()='Account Deleted!']"));

}
}
