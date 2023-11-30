package AE.Pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.TestBase;
import utility.Driver;

import static utilities.Locators.lmainPage;
import static utilities.Locators.url;

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


}
