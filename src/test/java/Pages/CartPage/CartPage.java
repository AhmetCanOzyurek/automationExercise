package Pages.CartPage;

import utilities.TestBase;

import static Pages.HomePage.HomePageLocators.*;
import static Pages.HomePage.HomePageLocators.lSubsSuccessMessage;

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
}
