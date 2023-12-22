package utilities;

import org.openqa.selenium.By;

public interface Locators {
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
        //TopBar
            By lCart = By.xpath("//a[text()=' CartPage']");
                // cart page
                     By lProceedToChckout =  By.xpath("//*[text()='Proceed To Checkout']");
                     //Checkout
                          By lRegisterLoginChckout = By.xpath("//*[text()='Register / Login']");
                          By lRemoveProductFrmCart = By.xpath("(//i[@class='fa fa-times'])[1]");
                          By lProductsInCart = By.cssSelector(".cart_product");
                          By lBillingAdressDetailBox =By.cssSelector("#address_invoice");
                          By lDownloadInvoice = By.xpath("//*[.='Download Invoice']");
            By lDeleteAccount = By.xpath("//*[text()=' Delete Account']");
            //accountDeleted
                By lAccountDeletedTxt = By.xpath("//*[text()='Account Deleted!']");
                //product page
                By lProducts = By.xpath("//div[@class='features_items']//div[@class='col-sm-4']");
                By lSearchProductBox =By.cssSelector("#search_product");
                By lSearchButton = By.cssSelector("#submit_search");
                By lSearchedProductsText = By.xpath("//*[text()='Searched Products']");
                By lSearchedProducts = By.cssSelector(".features_items .col-sm-4");
                By lAllProductsTxt = By.xpath("//*[text()='All Products']");


            By lSignupLogin = By.xpath("//*[text()=' Signup / Login']");
    By lContinueShopping = By.xpath("//*[.='Continue Shopping']");
    By lShoppingCartTxt = By.xpath("//*[text()='Shopping CartPage']");
    By lWievCart = By.xpath("//*[text()='View CartPage']");
    By lviewProduct = By.xpath("(//*[text()='View Product'])[1]");
        //viewProductPage
        By lWriteYourReviewtxt = By.xpath("//a[text()='Write Your Review']");
            //reviewArea
            By lReviewNameBox= By.cssSelector("#review-form #name");
            By lReviewEmailBox= By.cssSelector("#review-form #email");
            By lReviewBox= By.cssSelector("#review-form #review");
            By lReviewSubmit = By.cssSelector("#button-review");
            By lReviewSuccessTxt = By.cssSelector("#review-section");


    By lNewUserSignupNameBox = By.xpath("//*[@*='signup-name']");
By lNewUserSignupEmailBox = By.xpath("//*[@*='signup-email']");
By lNewUserSignupButton = By.xpath("//*[text()='Signup']");
//Enter Account Info
By lGenderRadioMr = By.cssSelector("#id_gender1");
By lPasswordBox = By.xpath("//input[@name='password']");
By lCheckBox1 = By.xpath("(//input[@type='checkbox'])[1]");
By lCheckBox2 = By.xpath("(//input[@type='checkbox'])[2]");
By lCountryDDM = By.cssSelector("#country");
By lAccountCreatedText = By.xpath("//*[text()='Account Created!']");
By lLoggedAsUsernameTxt = By.xpath("//*[text()=' Logged in as ']");
    By lContinueAfterAccountCreated = By.xpath("//*[text()='Continue']");
// Checkout
    By lDescription = By.cssSelector(".form-control");
By lPlaceOrder = By.xpath("//*[text()='Place Order']");



//Payment
    By lNameOnCard = By.xpath("//*[@name='name_on_card']");

    By lOrderPlacedTxt = By.xpath("//*[.='Order Placed!']");
//Products
    By lBlueTop = By.xpath("//*[text()='Blue Top']");

}
