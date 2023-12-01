package AE.Pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase;
import utility.Driver;
import static AE.Pages.HomePage.HomePageLocators.*;

public class HomePage extends TestBase {
    WebDriver driver;
    public HomePage(WebDriver givenDriver){
        driver = givenDriver;
    }
    public HomePage(){
        this(Driver.getDriver());
    }
    public void navigateToSite() {
        driver.get(url);
    }
    public void verifyMainPage(){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(lmainPage));
    }
    public void TopBarClicks(TopBars topBar){
        switch (topBar){
            case HOME:
                click(lHome);
                break;
            case PRODUCTS:
                click(lProductsTopBar);
                break;
            case CART:
                click(lCart);
                break;
            case SIGNUP_LOGIN:
                click(lSignup_Login);
                break;
            case LOGOUT:
                click(lLogout);
                break;
            case DELETE_ACCOUNT:
                click(lDeleteAccount);
                break;
            case TEST_CASES:
                click(lTestCases);
                break;
            case API_TESTING:
                click(lApiTesting);
                break;
            case VIDEO_TUTORIALS:
                click(lVideoTutorials);
                break;
            case CONTACT_US:
                click(lContactUs);
                break;
        }

    }


}
