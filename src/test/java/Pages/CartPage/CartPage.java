package Pages.CartPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase;

import static Pages.CartPage.CartLocators.*;
import static Pages.HomePage.HomePageLocators.*;
import static utilities.Locators.lNameOnCard;
import static utilities.Locators.lOrderPlacedTxt;

public class CartPage extends TestBase {

    public void scrollDownToEnd(){
        scrollIntoWiev(lSubscriptionEmailBox);
    }
    public void verifySubsTxt(){
        verifyVisibility(lSubscriptionTxt);
    }
    public void enterEmailtoSubsBox(){
        sendKeys(lSubscriptionEmailBox,faker.internet().emailAddress());
        click(lSubsSubmit);
    }
    public void verifySubsSuccessAlert(){
        verifyVisibility(lSubsSuccessMessage);
    }

    public void verifyCartPage(){
        verifyVisibility(lShoppingCartTxt);
    }
    public void clickProceedToCheckOut(){
     click(lProceedToChckout);
    }
    public void clickRegisterLoginAfterProceed(){
        click(lRegisterLoginChckout);
    }
    public void writeADescription(String comment){
      wait.until(ExpectedConditions.elementToBeClickable(lDescription)).sendKeys(comment);
      click(lPlaceOrder);
    }
    public void fillCreditCardCredentials(){
        WebElement eNameOnCardBox = driver.findElement(lNameOnCard);
        actions.click(eNameOnCardBox)
                .sendKeys(faker.rickAndMorty().character() + Keys.TAB)
                .sendKeys(faker.business().creditCardNumber() + Keys.TAB)
                .sendKeys("234" + Keys.TAB)
                .sendKeys("11" + Keys.TAB)
                .sendKeys("29" + Keys.ENTER).perform();
        bekle(3);
    }
    public void verifyYourOrderHasBeenPlaced(){

        verifyVisibility(lOrderPlacedTxt);

        click(By.xpath("//*[text()='Continue']"));
    }
}
