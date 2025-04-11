package pages;
 
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.BuyNowPageLocator;
import uistore.HomepageEarringsLocator;
import uistore.DropsPageLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;
 
public class HomepageEarringsAction {
 
    public ExtentTest test;
    WebDriverHelper helper;
 
    public HomepageEarringsAction(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
        LoggerHandler.info("Initialized TestFiveAction with ExtentTest and WebDriverHelper");
    }
 
    public void hoverOnEarrings() {
       
        test.log(Status.INFO, "Starting hoverOnEarrings test case");
        LoggerHandler.info("Starting hoverOnEarrings test case");
        helper.waitUntilElementIsVisible(HomepageEarringsLocator.earrings, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Earrings element is visible");
        helper.hoverOnElement(HomepageEarringsLocator.earrings);
        LoggerHandler.info("Hovered on earrings");
    }
 
    public void clicksOnDrops() {
        helper.waitUntilElementIsVisible(HomepageEarringsLocator.drops, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Drops element is visible");
        helper.clickElement(HomepageEarringsLocator.drops);
        LoggerHandler.info("Clicked on drops");
        test.log(Status.PASS, "Successfully clicked on earrings and drops");
    }
 
    public void verifiesUrl() {
        test.log(Status.INFO, "Starting verifies Url test case");
        LoggerHandler.info("Starting verifies Url test case");
        String currentURL = Base.driver.getCurrentUrl();
        LoggerHandler.info("Current URL: " + currentURL);
 
        String value = ExcelReader.readCellValue("Earrings Drops", "1", "data");
 
        boolean condition = currentURL.contains(value);
        helper.verifyTrue(condition, "check verification");
        LoggerHandler.info("Verified URL contains 'Drops'");
    }
 
    public void clicksOnCategories() {
        helper.waitUntilElementIsVisible(DropsPageLocator.categories, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.clickElement(DropsPageLocator.categories);
        LoggerHandler.info("Clicked on categories");
        helper.clickElement(DropsPageLocator.gold);
        LoggerHandler.info("Clicked on gold");
        test.log(Status.PASS, "Successfully clicked on categories and gold");
    }
 
    public void clicksOnMoreFilters() {
        test.log(Status.INFO, "Starting clicksOnMoreFilters test case");
        LoggerHandler.info("Starting clicksOnMoreFilters test case");
        helper.clickElement(DropsPageLocator.morefilter);
        LoggerHandler.info("Clicked on more filters");
    }
 
    public void clicksOnMetal() {
        helper.clickElement(DropsPageLocator.metalpurity);
        LoggerHandler.info("Clicked on metal purity");
        helper.waitUntilElementIsVisible(DropsPageLocator.twentytwokt, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("22kt element is visible");
        helper.clickElement(DropsPageLocator.twentytwokt);
        LoggerHandler.info("Clicked on 22kt");
        test.log(Status.PASS, "Successfully clicked on more filters and 22kt metal purity");
    }
 
    public void clicksOnProduct() {
        test.log(Status.INFO, "Starting clicksOnProduct test case");
        LoggerHandler.info("Starting clicksOnProduct test case");
        helper.waitUntilElementIsVisible(DropsPageLocator.firstproduct,Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("First product element is visible");
        helper.clickElement(DropsPageLocator.firstproduct);
        LoggerHandler.info("Clicked on the first product");
        test.log(Status.PASS, "Successfully clicked on the first product");
    }
 
    public void buyNowProduct() {
        test.log(Status.INFO, "Starting buyNowProduct test case");
        LoggerHandler.info("Starting buyNowProduct test case");
        helper.waitUntilElementIsVisible(BuyNowPageLocator.buyNow, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Buy Now element is visible");
        helper.clickElement(BuyNowPageLocator.buyNow);
        LoggerHandler.info("Clicked on Buy Now");
    }
 
    public void verifiesFeatures() {
        String keyfeature = Base.driver.findElement(BuyNowPageLocator.productname).getText();
        LoggerHandler.info("Product name: " + keyfeature);
 
        String value = ExcelReader.readCellValue("Earrings Drops", "2", "data");
 
        boolean condition = keyfeature.contains(value);
        helper.verifyTrue(condition, "match name");
        LoggerHandler.info("Verified product name contains 'Gold'");
        test.log(Status.PASS, "Successfully verified product name contains 'Gold'");
        test.log(Status.INFO, "Key feature: " + keyfeature);
        LoggerHandler.info("Key Features");
        Screenshot.takePageScreenShot("Buy Now Product");
    }
 
    public void allFunctionality() {
        hoverOnEarrings();
        clicksOnDrops();
        verifiesUrl();
        clicksOnCategories();
        clicksOnMoreFilters();
        clicksOnMetal();
        clicksOnProduct();
        buyNowProduct();
        verifiesFeatures();
    }
}