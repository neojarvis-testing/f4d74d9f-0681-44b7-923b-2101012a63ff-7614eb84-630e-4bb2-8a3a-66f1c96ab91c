package pages;

import java.time.Duration;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsGautam;
import uistore.PendentsPageLocatorsGautam;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;

public class BuyPendentsActionGautam {

    public ExtentTest test;

    public BuyPendentsActionGautam(ExtentTest test) {
        this.test = test;
    }

    WebDriverHelper helper = new WebDriverHelper(Base.driver, test);

    public void hoverOverPendents() {
        try {
            helper.hoverOnElement(HomePageLocatorsGautam.pendent);
            LoggerHandler.info("Hovered over: " + helper.retrieveElementText(HomePageLocatorsGautam.pendent));
            test.log(Status.INFO, "Hovered over: " + helper.retrieveElementText(HomePageLocatorsGautam.pendent));
            
            helper.clickElement(HomePageLocatorsGautam.gift);
            LoggerHandler.info("Clicked on: " + helper.retrieveElementText(HomePageLocatorsGautam.gift));
            test.log(Status.INFO, "Clicked on: " + helper.retrieveElementText(HomePageLocatorsGautam.gift));

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void genderFilter() {
        try {
            LoggerHandler.info("Clicked on Gender filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.Gender));
            test.log(Status.INFO, "Clicked on Gender filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.Gender));
            helper.clickElement(PendentsPageLocatorsGautam.Gender);
            
            helper.waitUntilElementIsVisible(PendentsPageLocatorsGautam.kids,10);
            LoggerHandler.info("Selected Kids filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.kids));
            test.log(Status.INFO, "Selected Kids filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.kids));
            helper.clickElement(PendentsPageLocatorsGautam.kids);
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void moreFilter() {
        try {
            helper.clickElement(PendentsPageLocatorsGautam.moreFilter);
            LoggerHandler.info("Clicked on More filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.moreFilter));
            test.log(Status.INFO, "Clicked on More filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.moreFilter));
            
            helper.clickElement(PendentsPageLocatorsGautam.type);
            LoggerHandler.info("Selected Type filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.type));
            test.log(Status.INFO, "Selected Type filter: " + helper.retrieveElementText(PendentsPageLocatorsGautam.type));
            helper.waitUntilElementIsVisible(PendentsPageLocatorsGautam.pendentInsideType,10);
            LoggerHandler.info("Selected Pendent inside Type: " + helper.retrieveElementText(PendentsPageLocatorsGautam.pendentInsideType));
            test.log(Status.INFO, "Selected Pendent inside Type: " + helper.retrieveElementText(PendentsPageLocatorsGautam.pendentInsideType));
            helper.clickElement(PendentsPageLocatorsGautam.pendentInsideType);
            
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void firstProductClick() {
        try {
            LoggerHandler.info("Clicked on first product: " + helper.retrieveElementText(PendentsPageLocatorsGautam.firstProductOnPendent));
            test.log(Status.INFO, "Clicked on first product: " + helper.retrieveElementText(PendentsPageLocatorsGautam.firstProductOnPendent));
            helper.clickElement(PendentsPageLocatorsGautam.firstProductOnPendent);
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void addToCart() {
        try {
            LoggerHandler.info("Clicked on Add to Cart: " + helper.retrieveElementText(PendentsPageLocatorsGautam.AddtoCart));
            test.log(Status.INFO, "Clicked on Add to Cart: " + helper.retrieveElementText(PendentsPageLocatorsGautam.AddtoCart));
            helper.clickElement(PendentsPageLocatorsGautam.AddtoCart);
            
            Reporter.addScreenshotToReport("reliancejewels", test, "reliancejewels");
            LoggerHandler.info("Screenshot added to report");
            test.log(Status.INFO, "Screenshot added to report");
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void callAllAction() {
        hoverOverPendents();
        genderFilter();
        moreFilter();
        firstProductClick();
        addToCart();
    }
}
