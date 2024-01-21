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
