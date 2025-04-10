package pages;

import java.time.Duration;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.BuyNowLocatorAkash;
import uistore.HomepageLocatorAkash;
import uistore.RespectivePageLocatorAkash;
import utils.Base;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class TestFiveActionAkash {

    public ExtentTest test;
    WebDriverHelper helper;

    public TestFiveActionAkash(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
        LoggerHandler.info("Initialized TestcaseFiveAction with ExtentTest and WebDriverHelper");
    }

    public void clicksOnEarrings() {
        test.log(Status.INFO, "Starting clicksOnEarrings test case");
        LoggerHandler.info("Starting clicksOnEarrings test case");
       
        helper.waitUntilElementIsVisible(HomepageLocatorAkash.earrings, 10);
        LoggerHandler.info("Earrings element is visible");
        helper.hoverOnElement(HomepageLocatorAkash.earrings);
        LoggerHandler.info("Hovered on earrings");
        helper.waitUntilElementIsVisible(HomepageLocatorAkash.drops, 10);
        LoggerHandler.info("Drops element is visible");
        helper.clickElement(HomepageLocatorAkash.drops);
        LoggerHandler.info("Clicked on drops");
        test.log(Status.PASS, "Successfully clicked on earrings and drops");
    }

    public void clicksOnCategories() {
        test.log(Status.INFO, "Starting clicksOnCategories test case");
        LoggerHandler.info("Starting clicksOnCategories test case");
       
        String currentURL = Base.driver.getCurrentUrl();
        LoggerHandler.info("Current URL: " + currentURL);
        boolean condition = currentURL.contains("Drops");
        helper.verifyTrue(condition, "check verification");
        LoggerHandler.info("Verified URL contains 'Drops'");
        helper.clickElement(RespectivePageLocatorAkash.categories);
        LoggerHandler.info("Clicked on categories");
        helper.clickElement(RespectivePageLocatorAkash.gold);
        LoggerHandler.info("Clicked on gold");
        test.log(Status.PASS, "Successfully clicked on categories and gold");
    }

    public void clicksOnMoreFilters() {
        test.log(Status.INFO, "Starting clicksOnMoreFilters test case");
        LoggerHandler.info("Starting clicksOnMoreFilters test case");
       
        helper.clickElement(RespectivePageLocatorAkash.morefilter);
        LoggerHandler.info("Clicked on more filters");
        helper.clickElement(RespectivePageLocatorAkash.metalpurity);
        LoggerHandler.info("Clicked on metal purity");
        helper.waitUntilElementIsVisible(RespectivePageLocatorAkash.twentytwokt, 20);
        LoggerHandler.info("22kt element is visible");
        helper.clickElement(RespectivePageLocatorAkash.twentytwokt);
        LoggerHandler.info("Clicked on 22kt");
        test.log(Status.PASS, "Successfully clicked on more filters and 22kt metal purity");
    }

    public void clicksOnProduct() {
        test.log(Status.INFO, "Starting clicksOnProduct test case");
        LoggerHandler.info("Starting clicksOnProduct test case");
       
        helper.waitUntilElementIsVisible(RespectivePageLocatorAkash.firstproduct, 15);
        LoggerHandler.info("First product element is visible");
        helper.clickElement(RespectivePageLocatorAkash.firstproduct);
        LoggerHandler.info("Clicked on the first product");
        test.log(Status.PASS, "Successfully clicked on the first product");
    }

    public void buyNowProduct() {
        test.log(Status.INFO, "Starting buyNowProduct test case");
        LoggerHandler.info("Starting buyNowProduct test case");
        
        helper.waitUntilElementIsVisible(BuyNowLocatorAkash.buyNow, 15);
        LoggerHandler.info("Buy Now element is visible");
        helper.clickElement(BuyNowLocatorAkash.buyNow);
        LoggerHandler.info("Clicked on Buy Now");

        String keyfeature = Base.driver.findElement(BuyNowLocatorAkash.productname).getText();
        LoggerHandler.info("product name: " + keyfeature);
        boolean condition = keyfeature.contains("Gold");

        helper.verifyTrue(condition, "match name");
        LoggerHandler.info("Verified product name contains 'Gold'");
        test.log(Status.PASS, "Successfully verified product name contains 'Gold'");
        test.log(Status.INFO, "Key feature: " + keyfeature);
        LoggerHandler.info("Key Features");
        Screenshot.takePageScreenShot("Buy Now Product");
    }
}





























// package pages;

// import java.time.Duration;

// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.Status;

// import uistore.BuyNowPageLocator;
// import uistore.HomepageLocator;
// import uistore.RespectivePageLocator;
// import utils.Base;
// import utils.LoggerHandler;
// import utils.Screenshot;
// import utils.WebDriverHelper;

// public class TestcaseFiveAction {

//     public ExtentTest test;
//     WebDriverHelper helper;

//     public TestcaseFiveAction(ExtentTest test) {
//         this.test = test;
//         helper = new WebDriverHelper(Base.driver, test);
//     }

//     public void clicksOnEarrinhgs() {
//         try {

//             Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//             helper.waitUntilElementIsVisible(HomepageLocator.earrings, 10);
//             helper.hoverOnElement(HomepageLocator.earrings);
//             helper.waitUntilElementIsVisible(HomepageLocator.drops, 10);
//             helper.clickElement(HomepageLocator.drops);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public void clicksOnCategories() {
//         try {

//             Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//             String currentURL = Base.driver.getCurrentUrl();
//             LoggerHandler.warn(currentURL);
//             boolean condition = currentURL.contains("Drops");
//             helper.verifyTrue(condition, "check verification");
//             helper.clickElement(RespectivePageLocator.categories);
//             helper.clickElement(RespectivePageLocator.gold);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public void clicksOnMoreFilters() {
//         try {

//             Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//             // String actual = Base.driver.findElement(RespectivePageLocator.containsgold).getAttribute("title");
//             // System.out.println(actual);
//             // boolean condition = actual.contains("Gold");
//             // helper.verifyTrue(condition, "gold product");

//             helper.clickElement(RespectivePageLocator.morefilter);
//             helper.clickElement(RespectivePageLocator.metalpurity);
//             helper.waitUntilElementIsVisible(RespectivePageLocator.twentytwokt, 20);
//             helper.clickElement(RespectivePageLocator.twentytwokt);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//     }

//     public void clicksOnProduct() {
//         try {

//             Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//             // String actual = Base.driver.findElement(RespectivePageLocator.containsgold).getAttribute("title");
//             // // String actual = Base.driver.findElement(RespectivePageLocator.containsgold).getCssValue("title");
//             // System.out.println(actual);
//             // boolean condition = actual.contains("Gold");
//             // helper.verifyTrue(condition, "gold result page");
//             helper.waitUntilElementIsVisible(RespectivePageLocator.firstproduct, 15);
//             helper.clickElement(RespectivePageLocator.firstproduct);

//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//     }

//     public void buyNowProduct() {

//         try {

//             Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//             helper.waitUntilElementIsVisible(BuyNowPageLocator.buyNow, 20);
//             helper.clickElement(BuyNowPageLocator.buyNow);

//             String keyfeature = Base.driver.findElement(BuyNowPageLocator.productname).getText();
//             boolean condition = keyfeature.contains("Gold");

//             helper.verifyTrue(condition, "match name");
//             test.log(Status.INFO, "keyfeature");
//             LoggerHandler.info("Key Features");
//             Screenshot.takePageScreenShot("Buy Now Product");

//         } catch (Exception e) {
//             e.printStackTrace();
//         }

//     }

// }
