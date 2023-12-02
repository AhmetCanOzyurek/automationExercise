package Pages.Signup_LoginPage;

import org.openqa.selenium.By;

public interface SUpLogiLocators {
    By lNewUserSignupTxt = By.xpath("//*[text() ='New User Signup!']");
    By lNewUserSignupNameBox = By.xpath("//*[@*='signup-name']");
    By lNewUserSignupEmailBox = By.xpath("//*[@*='signup-email']");
    By lNewUserSignupButton = By.xpath("//*[text()='Signup']");


    //Enter Account Info
    By lEnterAccounInformationTxt =By.xpath("(//h2[@class='title text-center'])[1]");
    By lGenderRadioMr = By.cssSelector("#id_gender1");
    By lPasswordBox = By.xpath("//input[@name='password']");
    By lCheckBox1 = By.xpath("(//input[@type='checkbox'])[1]");
    By lCheckBox2 = By.xpath("(//input[@type='checkbox'])[2]");
    By lCountryDDM = By.cssSelector("#country");
    By lAccountCreatedText = By.xpath("//*[text()='Account Created!']");
    By lLoggedAsUsernameTxt = By.xpath("//*[text()=' Logged in as ']");
    By lContinueAfterAccountCreated = By.xpath("//*[text()='Continue']");
}
