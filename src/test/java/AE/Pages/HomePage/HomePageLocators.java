package AE.Pages.HomePage;

import org.openqa.selenium.By;

public interface HomePageLocators {
    By lmainPage = By.xpath("//div[@class='logo pull-left']");
    //Main Page
    //SideBar
    By lCategoryLeftSide = By.xpath("//h2[text()='Category']");
    By lWomenCategoru = By.xpath("(//span[@class='badge pull-right'])[1]");
    //Women Category
    By lWomenDress = By.xpath("(//a[contains(text(),'Dress')])[1]");
    //Women dress page
    By lWomenDressText = By.xpath("//*[contains(text(),'Women > Dress')]");
    By lSubsTextDownPage = By.xpath("//*[text()='Subscription']");
    By lUpwardArrow = By.cssSelector("#scrollUp");
    By lFullFledgedtxt = By.xpath("(//*[contains(text(),'Full-Fledged')])[1]");
    By lAddsDownButton = By.cssSelector("#dropShadowTop");
    By lShadowRootAdds = By.xpath("//div[@class='grippy-host']");

    By lRecommendItemsTxt = By.xpath("//*[text()='recommended items']");
    //RecommendedItems
    By lRecommendedAddToCart = By.xpath("//div[@id='recommended-item-carousel']//a[@data-product-id='1']");
    By lMenCategoru = By.xpath("(//span[@class='badge pull-right'])[2]");
    //Men category
    By lMenTshirt = By.xpath("//a[contains(text(),'Tshirts')]");
    //Men TshirtPage
    By lMenTshirtPageTxt = By.xpath("//*[contains(text(),'Men > Tshirts')]");
    By lBrands = By.xpath("//*[text()='Brands']");
    By lPoloBrand = By.cssSelector("ul li a[href = '/brand_products/Polo']");
    By lPoloBrandPageTxt = By.xpath("(//*[text()='Polo'])[1]");
    By lHMbrand = By.cssSelector("ul li a[href = '/brand_products/H&M']");
    By lHmBrandPageTxt = By.xpath("//*[text()='Brand - H&M Products']");
}
