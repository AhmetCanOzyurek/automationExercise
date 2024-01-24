package Pages.HomePage;

import org.openqa.selenium.By;

public interface HomePageLocators {
    String url =  "https://automationexercise.com/";
    By lmainPage = By.xpath("//div[@class='logo pull-left']");
    //Main Page

    By lSubsTextDownPage = By.xpath("//*[text()='Subscription']");
    By lUpwardArrow = By.cssSelector("#scrollUp");
    By lFullFledgedtxt = By.xpath("(//*[contains(text(),'Full-Fledged')])[1]");
    By lAddsDownButton = By.cssSelector("#dropShadowTop");
    By lShadowRootAdds = By.xpath("//div[@class='grippy-host']");

    By lRecommendItemsTxt = By.xpath("//*[text()='recommended items']");
    //RecommendedItems
    By lRecommendedAddToCart = By.xpath("//div[@id='recommended-item-carousel']//a[@data-product-id='1']");

    //SideBar
    By lCategoryLeftSide = By.xpath("//h2[text()='Category']");
        By lWomenCategoru = By.xpath("(//span[@class='badge pull-right'])[1]");
        //Women Category
             By lWomenDress = By.xpath("(//a[contains(text(),'Dress')])[1]");
             //Women dress page
                  By lWomenDressText = By.xpath("//*[contains(text(),'Women > Dress')]");
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

    By lSubscriptionEmailBox = By.cssSelector("#susbscribe_email");
    By lSubscriptionTxt = By.xpath("//*[text()='Subscription']");
    By lSubsSubmit = By.cssSelector("#subscribe");
    By lSubsSuccessMessage = By.cssSelector("div[class='alert-success alert']");



    ///////////
    // TOPBAR

    By lHome = By.xpath("(//ul[@class='nav navbar-nav']//li)[1]");
    By lProductsTopBar = By.xpath("(//ul[@class='nav navbar-nav']//li)[2]");
    By lCart = By.xpath("(//ul[@class='nav navbar-nav']//li)[3]");
    By lSignup_Login = By.xpath("(//ul[@class='nav navbar-nav']//li)[4]");
    By lLogout = By.xpath("(//ul[@class='nav navbar-nav']//li)[4]");
    By lDeleteAccount = By.xpath("//*[text()=' Delete Account']");
        By lAccountDeletedTxt = By.xpath("//*[text()='Account Deleted!']");
    By lTestCases = By.xpath("(//ul[@class='nav navbar-nav']//li)[5]");
    By lApiTesting = By.xpath("(//ul[@class='nav navbar-nav']//li)[6]");
    By lVideoTutorials = By.xpath("(//ul[@class='nav navbar-nav']//li)[7]");
    By lContactUs = By.xpath("(//ul[@class='nav navbar-nav']//li)[8]");
    By lTestCaseSign = By.xpath("//b[text()='Test Cases']");

    By lMainPageFirstItemViewProd =By.xpath("(//*[text()='View Product'])[1]");
    By lContinueShopping = By.xpath("//*[.='Continue Shopping']");



}
