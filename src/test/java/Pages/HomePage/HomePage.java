package Pages.HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static Pages.HomePage.HomePageLocators.*;
import static utilities.Locators.lContinueShopping;

public class HomePage extends TestBase {


    public void navigateToSite() {
        driver.get(HomePageLocators.url);
    }

    public void verifyMainPage(){
     verifyVisibility(lmainPage);
    }

    public void TopBarClicks(TopBars topBar){
        switch (topBar){
            case HOME:
                click(HomePageLocators.lHome);
                break;
            case PRODUCTS:
                click(HomePageLocators.lProductsTopBar);
                break;
            case CART:
                click(HomePageLocators.lCart);
                break;
            case SIGNUP_LOGIN:
                click(HomePageLocators.lSignup_Login);
                break;
            case LOGOUT:
                click(HomePageLocators.lLogout);
                break;
            case DELETE_ACCOUNT:
                click(HomePageLocators.lDeleteAccount);
                break;
            case TEST_CASES:
                click(HomePageLocators.lTestCases);
                break;
            case API_TESTING:
                click(HomePageLocators.lApiTesting);
                break;
            case VIDEO_TUTORIALS:
                click(HomePageLocators.lVideoTutorials);
                break;
            case CONTACT_US:
                click(HomePageLocators.lContactUs);
                break;
        }

    }
    public void deleteAccount(){
        click(lDeleteAccount);
        verifyVisibility(lAccountDeletedTxt);
    }
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
    public void clickFirstViewItem(){
        click(lMainPageFirstItemViewProd);
    }
    public void addProductsToCart(int numberOfProduct){
        for (int i = 1; i <numberOfProduct*2 ; i+=2) {
            WebElement element1 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])["+i+"]"));
            jse.executeScript("arguments[0].scrollIntoView();",element1);
            element1.click();
            click(lContinueShopping);
        }
    }
}
