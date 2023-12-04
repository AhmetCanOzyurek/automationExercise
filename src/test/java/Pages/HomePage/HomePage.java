package Pages.HomePage;

import org.openqa.selenium.WebDriver;
import utilities.TestBase;
import utility.Driver;

import static Pages.HomePage.HomePageLocators.*;

public class HomePage extends TestBase {
    WebDriver driver;
    public HomePage(WebDriver givenDriver){
        driver = givenDriver;
    }

    public HomePage(){
        this(Driver.getDriver());
    }

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


}
