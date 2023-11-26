package AE.Pages;

import org.openqa.selenium.WebDriver;
import utilities.TestBase;
import utility.Driver;

public class HomePage extends TestBase {
    public HomePage(WebDriver givenDriver){

    }
    public HomePage(){
        this(Driver.getDriver());
    }
    public  void open(String url){
        driver.get(url);
    }

}
