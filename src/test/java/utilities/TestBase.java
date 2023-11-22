package utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import utility.Driver;

import java.time.Duration;
import java.util.List;

import static utilities.Locators.*;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert;
    protected static Actions actions;
    public static JavascriptExecutor jse;
    protected static Faker faker;
    protected static WebElement element;
    protected static Select select;
@BeforeTest
    public  void  setUp(){
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        softAssert = new SoftAssert();
        wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);
        faker = new Faker();
    }
    public void navigateToSite() {
        driver.get("http://automationexercise.com");
    }
    public void verifyMainPage(By locator){
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator){
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.click();
    }
    public void click(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void scrollIntoWiev(WebElement element){
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    protected void verifyVisibility(By locator){
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void sendKeys(By locator, String text){
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.clear();
    element.sendKeys(text);
}
    protected void onMouse( By locator){
    WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    actions.moveToElement(element).perform();
}
protected void verifyYourOrderHasBeenPlaced(){
    driver.navigate().back();
    verifyVisibility(By.cssSelector("div[id = 'success_message']"));
    click(By.cssSelector("#submit"));
    bekle(3);
    click(By.xpath("//*[text()='Continue']"));
}
protected void newUserSignUp(){
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

}
protected void addProductsToCart(int numberOfProduct){

    actions.scrollByAmount(0,300).build().perform();

    for (int i = 1; i <numberOfProduct*2 ; i+=2) {
      WebElement element1 = driver.findElement(By.xpath("(//a[@class='btn btn-default add-to-cart'])["+i+"]"));
      jse.executeScript("arguments[0].scrollIntoView();",element1);
      element1.click();
      click(lContinueShopping);
    }

}
protected void verifyAdressDetails(){

    WebElement adressBox = driver.findElement(By.cssSelector("#address_delivery"));
    String actualAdressStr = adressBox.getText();
    String expectedAdress = "Canada";

    softAssert.assertTrue(actualAdressStr.contains(expectedAdress));
}
protected void fillCreditCardCredentials(){
    WebElement eNameOnCardBox = driver.findElement(lNameOnCard);
    actions.click(eNameOnCardBox)
            .sendKeys(faker.rickAndMorty().character() + Keys.TAB)
            .sendKeys(faker.business().creditCardNumber() + Keys.TAB)
            .sendKeys("234" + Keys.TAB)
            .sendKeys("11" + Keys.TAB)
            .sendKeys("29" + Keys.ENTER).perform();
    bekle(3);
}
protected  void bekle(int saniye){
    try {
        Thread.sleep(saniye*1000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
}
protected void verifyAllProducts(By locator){

    List<WebElement> allProducts = driver.findElements(locator);
        wait.until(ExpectedConditions.visibilityOfAllElements(allProducts));

}
protected void searchAProductOnProductPage(String productName){
WebElement element = driver.findElement(lSearchProductBox);
WebElement element1 = driver.findElement(lSearchButton);
    new Actions(driver).click(element)
            .sendKeys(productName)
            .click(element1)
            .build()
            .perform();

}
protected void verifyAmountOfAddedProductsOnCart(int numberOfProductToAssert){
    wait.until(ExpectedConditions.numberOfElementsToBe(lProductsInCart,numberOfProductToAssert));
}

    @AfterTest
    public  void tearDown() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    driver.quit();

    }

}
