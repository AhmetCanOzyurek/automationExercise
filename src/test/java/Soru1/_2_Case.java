package Soru1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class _2_Case extends TestBase {

    @Test
    public void Test02() throws InterruptedException {
// Trendyol TestCase
        //1."https://www.trendyol.com/" Sayfasına git.
        driver.get("https://www.trendyol.com/");
        String ilkSayfaHandleDegeri = driver.getWindowHandle();
        // 2.Mouse mizi "Erkek"  Katagorisinin üzerine bekletelim.
        WebElement acceptCookies = driver.findElement(By.xpath("//button[text()='KABUL ET']"));
        acceptCookies.click();
        WebElement erkekLocator = driver.findElement(By.xpath("//a[text()='Erkek']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(erkekLocator).perform();
        //3."Tişört" sekmesine tıklayalım.
        WebElement erkekTişörtSekmesi = driver.findElement(By.xpath("(//a[text()='Tişört'])[3]"));
        erkekTişörtSekmesi.click();
        //4."Çıkan  2. ürüne" Tıklayalım.
        WebElement popUpEngelleyici = driver.findElement(By.xpath("//div[@class='overlay']"));
        popUpEngelleyici.click();
        List <WebElement> ikinciUrun =  driver.findElements(By.xpath("//div[@class='p-card-chldrn-cntnr card-border']"));
        ikinciUrun.get(1).click();

        Set<String> tumPencereler =driver.getWindowHandles();
        String ikinciSayfaHandleDegeri = "";
        for(String handle:tumPencereler){
            if(!handle.equals(ilkSayfaHandleDegeri)){
                ikinciSayfaHandleDegeri = handle;
            }
        }
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        //5."AC&Co / Altınyıldız Classics " Yazısı içerdiğini test edelim.
        WebElement anladım = driver.findElement(By.xpath("//div[text()='Anladım']"));
        anladım.click();
        WebElement tişortIsmi = driver.findElement(By.xpath("//a[text()='AC&Co / Altınyıldız Classics']"));
        String expectedTitle = "AC&Co / Altınyıldız Classics";
        String actualTitle = tişortIsmi.getText();
        Assert.assertEquals(expectedTitle,actualTitle);
        //6."Renk seçeneklerinin üzerinde" mousemizi gezdirelim.

        Thread.sleep(3000);
        List<WebElement> renklerElementi = driver.findElements(By.xpath("//div[@class='slicing-attributes']/section//a"));
        for (int i = 0; i < renklerElementi.size(); i++) {
            actions.moveToElement(renklerElementi.get(i)).perform();
        }
        //7."Beden" sekmesinden L bedeni seçelim.
        //8."SEPETE EKLE" Butonuna tıklayalım.
        //9."Sepetim" Butonuna tıkla
        //10.Alttaki "Sepeti Onayla" Butonuna tıklayalım.
    }

}
