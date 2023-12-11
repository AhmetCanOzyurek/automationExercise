package Pages.ContactUs;

import org.openqa.selenium.WebElement;
import utilities.TestBase;
import static Pages.ContactUs.ContactUsLocators.*;
public class ContactUs extends TestBase {
    public void verifyGetInTouch(){
        verifyVisibility(lGetInTouchTxt);
    }
    public void enterCredentialsAndMessage(){
        sendKeys(lNameBoxCU,nameCU);
        sendKeys(lEmailBoxCU,emailCU);
        sendKeys(lSubjectBoxCU,subjectCU);
        sendKeys(lMessageBoxCU,faker.rickAndMorty().quote());
    }
    public void uploadFile(){
        WebElement uploadButton = driver.findElement(lUploadButton);
        uploadButton.sendKeys(pathFile);
    }
    public void submit(){
        click(lSubmitCU);
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void verifySuccessText(){
        verifyVisibility(lSuccessTxt);
    }
}
