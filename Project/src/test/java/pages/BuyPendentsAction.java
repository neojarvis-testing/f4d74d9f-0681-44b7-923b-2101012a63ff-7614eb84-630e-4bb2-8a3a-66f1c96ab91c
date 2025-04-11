package pages;

import java.time.Duration;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsRingsAndPendent;
import uistore.PendentsPageLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;

public class BuyPendentsAction {

    public ExtentTest test;
    WebDriverHelper helper;

    public BuyPendentsAction(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
    }


    public void hoverOverPendents() {
        try {
            helper.hoverOnElement(HomePageLocatorsRingsAndPendent.pendent);
            LoggerHandler.info("hover on " + helper.retrieveElementText(HomePageLocatorsRingsAndPendent.pendent).toLowerCase());
            LoggerHandler.info("hover on pendants");
            test.log(Status.INFO, "hover on " + helper.retrieveElementText(HomePageLocatorsRingsAndPendent.pendent).toLowerCase());

            
            helper.clickElement(HomePageLocatorsRingsAndPendent.gift);
            LoggerHandler.info("Clicked on: " + helper.retrieveElementText(HomePageLocatorsRingsAndPendent.gift));
            test.log(Status.PASS, "Clicked on: " + helper.retrieveElementText(HomePageLocatorsRingsAndPendent.gift));

            String data=ExcelReader.readCellValue("RingsAndPendant","4","Items");
            String url = Base.driver.getCurrentUrl();
            String keyword = data.toLowerCase();
            String description = ExcelReader.readCellValue("RingsAndPendant","4","Description");
            boolean condition = url.contains(keyword);
            helper.verifyTrue(condition,description);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void genderFilter() {
        try {
            LoggerHandler.info("Clicked on Gender filter: " + helper.retrieveElementText(PendentsPageLocators.Gender));
            test.log(Status.INFO, "Clicked on Gender filter: " + helper.retrieveElementText(PendentsPageLocators.Gender));
            helper.clickElement(PendentsPageLocators.Gender);
            
            helper.waitUntilElementIsVisible(PendentsPageLocators.kids,10);
            LoggerHandler.info("Selected Kids filter: " + helper.retrieveElementText(PendentsPageLocators.kids));
            test.log(Status.INFO, "Selected Kids filter: " + helper.retrieveElementText(PendentsPageLocators.kids));
            helper.clickElement(PendentsPageLocators.kids);
            
            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant","5","Actual");
            String description=ExcelReader.readCellValue("RingsAndPendant","5","Description");
            helper.verifyEquals(title,actual,description);
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void moreFilter() {
        try {
            helper.clickElement(PendentsPageLocators.moreFilter);
            LoggerHandler.info("Clicked on More filter: " + helper.retrieveElementText(PendentsPageLocators.moreFilter));
            test.log(Status.INFO, "Clicked on More filter: " + helper.retrieveElementText(PendentsPageLocators.moreFilter));
            
            helper.clickElement(PendentsPageLocators.type);
            LoggerHandler.info("Selected Type filter: " + helper.retrieveElementText(PendentsPageLocators.type));
            test.log(Status.INFO, "Selected Type filter: " + helper.retrieveElementText(PendentsPageLocators.type));
            helper.waitUntilElementIsVisible(PendentsPageLocators.pendentInsideType,10);
            LoggerHandler.info("Selected Pendent inside Type: " + helper.retrieveElementText(PendentsPageLocators.pendentInsideType));
            test.log(Status.INFO, "Selected Pendent inside Type: " + helper.retrieveElementText(PendentsPageLocators.pendentInsideType));
            helper.clickElement(PendentsPageLocators.pendentInsideType);
            
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void firstProductClick() {
        try {

            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant","6","Actual");
            String description=ExcelReader.readCellValue("RingsAndPendant","6","Description");
            helper.verifyEquals(title,actual,description);

            LoggerHandler.info("Clicked on first product: " + helper.retrieveElementText(PendentsPageLocators.firstProductOnPendent));
            test.log(Status.PASS, "click on the first product");
            helper.clickElement(PendentsPageLocators.firstProductOnPendent);
            
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void addToCart() {
        try {
            LoggerHandler.info("Clicked on Add to Cart: " + helper.retrieveElementText(PendentsPageLocators.AddtoCart));
            test.log(Status.INFO, "Clicked on Add to Cart: " + helper.retrieveElementText(PendentsPageLocators.AddtoCart));
            helper.clickElement(PendentsPageLocators.AddtoCart);
            
            Reporter.addScreenshotToReport("reliancejewels", test, "reliancejewels");
            LoggerHandler.info("Screenshot added to report");
            test.log(Status.INFO, "Screenshot added to report");
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void proceetToPay(){
        try{
            LoggerHandler.info("Clicked on " + helper.retrieveElementText(PendentsPageLocators.proceedToPay));
            test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PendentsPageLocators.proceedToPay));
            helper.clickElement(PendentsPageLocators.proceedToPay);
        }catch(Exception e){
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
        proceetToPay();
    }
}
