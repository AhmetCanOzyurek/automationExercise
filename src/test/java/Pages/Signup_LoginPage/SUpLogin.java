package Pages.Signup_LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import static Pages.Signup_LoginPage.SUpLogiLocators.*;
import static Pages.Signup_LoginPage.SUpLogiLocators.lAccountCreatedText;
import static Pages.Signup_LoginPage.SUpLogiLocators.lCheckBox1;
import static Pages.Signup_LoginPage.SUpLogiLocators.lCheckBox2;
import static Pages.Signup_LoginPage.SUpLogiLocators.lContinueAfterAccountCreated;
import static Pages.Signup_LoginPage.SUpLogiLocators.lCountryDDM;
import static Pages.Signup_LoginPage.SUpLogiLocators.lGenderRadioMr;
import static Pages.Signup_LoginPage.SUpLogiLocators.lLoggedAsUsernameTxt;
import static Pages.Signup_LoginPage.SUpLogiLocators.lNewUserSignupButton;
import static Pages.Signup_LoginPage.SUpLogiLocators.lNewUserSignupEmailBox;
import static Pages.Signup_LoginPage.SUpLogiLocators.lNewUserSignupNameBox;
import static Pages.Signup_LoginPage.SUpLogiLocators.lPasswordBox;
import static utilities.Locators.*;

public class SUpLogin extends TestBase {

    public void newUserSignUp(){
        String fakerEmail = faker.internet().emailAddress();
        String fakerUsername = faker.rickAndMorty().character();
        String fakerPassword = faker.internet().password();

        verifyVisibility(lNewUserSignupTxt);
        sendKeys(lNewUserSignupNameBox, fakerUsername);
        sendKeys(lNewUserSignupEmailBox, fakerEmail);
        click(lNewUserSignupButton);


        ///////////
        verifyVisibility(lEnterAccounInformationTxt);
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
    public  void verifyAccountCreated(){
        verifyVisibility(lAccountCreatedText);
        click(lContinueAfterAccountCreated);
    }
    public void verifyloggedAsUN(){
        verifyVisibility(lLoggedAsUsernameTxt);
    }
    public void Login(){
        verifyVisibility(lLoginTxt);
        sendKeys(lLoginEmail,myUserMail);
        sendKeys(lLoginPassword,myPassowrd);
        click(lLoginButton);
    }
    public void IncorrectLogin(){
        verifyVisibility(lLoginTxt);
        sendKeys(lLoginEmail,myIncorrectMail);
        sendKeys(lLoginPassword,myIncorrectPassword);
        click(lLoginButton);
        verifyVisibility(lIncorrectTxt);
    }
    public void alreadyExistEmail(){
        verifyVisibility(lNewUserSignupTxt);
        sendKeys(lNewUserSignupNameBox, "helaVelaVelvela");
        sendKeys(lNewUserSignupEmailBox, myUserMail);
        click(lNewUserSignupButton);
    }
    public void verifyAdressDetails(){

        WebElement adressBox = driver.findElement(By.cssSelector("#address_delivery"));
        String actualAdressStr = adressBox.getText();
        WebElement billingAdressBox = driver.findElement(lBillingAdressDetailBox);
        String actualBillingAdressStr = billingAdressBox.getText();


        softAssert.assertTrue(actualAdressStr.contains(fakerLocation));
        softAssert.assertTrue(actualBillingAdressStr.contains(fakerLocation));
    }
    public void verifyAccountDeleted(){
        verifyVisibility(lAccountDeletedTxt);
    }
}
