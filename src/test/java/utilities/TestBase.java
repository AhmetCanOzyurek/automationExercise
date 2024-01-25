package utilities;

import Pages.CartPage.CartPage;
import Pages.ContactUs.ContactUs;
import Pages.HomePage.HomePage;
import Pages.HomePage.HomePageLocators;
import Pages.HomePage.TopBars;
import Pages.Products.Products;
import Pages.Signup_LoginPage.SUpLogin;
import com.github.javafaker.Faker;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;
import utility.Driver;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;

import static utilities.Locators.*;

public class TestBase {
    public static HomePage homePage;
    public static CartPage cartPage ;
    public static SUpLogin sUpLogin;
    public static Products products;
    public static ContactUs contactUs;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SoftAssert softAssert;
    protected static Actions actions;
    public static JavascriptExecutor jse;
    protected static Faker faker = new Faker();
    protected static WebElement element;
    protected static Select select;
    protected static  String fakerLocation =  faker.rickAndMorty().location();
    protected static String fakerLocation2 = faker.rickAndMorty().location();
@BeforeTest
    public  void  setUp(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        softAssert = new SoftAssert();
        wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        jse = (JavascriptExecutor) driver;
        actions = new Actions(driver);

    homePage = new HomePage();
    cartPage = new CartPage();
    sUpLogin = new SUpLogin();
    products = new Products();
    contactUs = new ContactUs();
    }
    @BeforeClass
    public void openingSite(){
        // 1. Launch browser
        // 2. Navigate to url 'http://automationexercise.com'
        homePage.navigateToSite();
        // 3. Verify that home page is visible successfully
        homePage.verifyMainPage();
    }

    public void click(By locator){
    scrollIntoWiev(locator);
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    element.click();
    }
    public void click(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void scrollIntoWiev(WebElement element){
    jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }public void scrollIntoWiev(By locator){
    WebElement element = driver.findElement(locator);
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
    verifyVisibility(lOrderPlacedTxt);
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
            .sendKeys(faker.name().lastName() + Keys.TAB).perform();

             actions.sendKeys("muz" + Keys.TAB)
            .sendKeys(fakerLocation + Keys.TAB)
            .sendKeys(fakerLocation2+ Keys.TAB)
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
    WebElement billingAdressBox = driver.findElement(lBillingAdressDetailBox);
    String actualBillingAdressStr = billingAdressBox.getText();


    softAssert.assertTrue(actualAdressStr.contains(fakerLocation));
    softAssert.assertTrue(actualBillingAdressStr.contains(fakerLocation));
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

protected void verifyFileDownloaded(){
String dynamicFilePath = System.getProperty("user.home")+"/Downloads/invoice.txt";
softAssert.assertTrue(Files.exists(Paths.get(dynamicFilePath)));
}
public void assertItemNames(String expectedItemName, By actualElementLocator){
    String actualItemName = driver.findElement(actualElementLocator).getText();
    softAssert.assertEquals(actualItemName, expectedItemName);


}
protected WebElement getShadowRoots(By shadowRootLocator, By elementLocator){
   WebElement eShadowRoot = wait.until(ExpectedConditions.presenceOfElementLocated(shadowRootLocator));
return eShadowRoot.getShadowRoot().findElement(elementLocator);


}
public void clickViewCart(){
    click(lWievCart);
}
    @AfterTest
    public  void tearDown() {
    softAssert.assertAll();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    driver.quit();

    }

}
