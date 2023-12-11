package Pages.ContactUs;

import org.openqa.selenium.By;

public interface ContactUsLocators {
By lGetInTouchTxt = By.xpath("//*[text()='Get In Touch']");
By lNameBoxCU = By.xpath("//*[@placeholder='Name']");
By lEmailBoxCU = By.xpath("//*[@placeholder='Email']");
By lSubjectBoxCU = By.xpath("//*[@placeholder='Subject']");
By lMessageBoxCU = By.cssSelector("#message");

String nameCU = "Colin Weissnat";
String emailCU = "email@gmail.com";
String subjectCU = "love from Yozgat";

By lUploadButton = By.xpath("//*[@name='upload_file']");
String pathFile =  "/Users/enesoncu/IdeaProjects/automationExercise/src/test/java/AE/TestDosyası";
By lSubmitCU = By.xpath("//*[@name='submit']");
By lSuccessTxt = By.xpath("//*[@class='status alert alert-success']");

}
