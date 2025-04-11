package pages;

import java.time.Duration;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsRingsAndPendent;
import uistore.RingPageLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class BuyRingsAction {

    public ExtentTest test;
    WebDriverHelper helper;

    public BuyRingsAction(ExtentTest test){
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
    }


    public void clickOnSerchBar() {
        try {
            helper.clickElement(HomePageLocatorsRingsAndPendent.searchBarLocator);
            LoggerHandler.info("Clicked on search bar");
            test.log(Status.INFO, "Clicked on search bar");

            String data = ExcelReader.readCellValue("RingsAndPendant", "1", "Items");
            helper.typeIntoElement(HomePageLocatorsRingsAndPendent.searchBarLocator, data);
            LoggerHandler.info("Typed into search bar: " + data);
            test.log(Status.INFO, "Typed into search bar: " + data);

            helper.pressEnterKey(HomePageLocatorsRingsAndPendent.searchBarLocator);
            LoggerHandler.info("Pressed Enter key");
            test.log(Status.INFO, "Pressed Enter key");

            String title = Base.driver.getTitle().toLowerCase();
            String keyword = data.toLowerCase();
            String description = ExcelReader.readCellValue("RingsAndPendant","1","Description");
            boolean condition = title.contains(keyword);
            helper.verifyTrue(condition,description);

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL , e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnGender() {
        try {
            helper.clickElement(RingPageLocators.Gender);
            LoggerHandler.info("Clicked on Gender filter");
            test.log(Status.INFO, "Clicked on Gender filter");

            helper.clickElement(RingPageLocators.Mens);
            LoggerHandler.info("Selected Mens filter");
            test.log(Status.INFO, "Selected Mens filter");
            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant","2","Actual");
            String description=ExcelReader.readCellValue("RingsAndPendant","2","Description");
            helper.verifyEquals(title,actual,description);
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnMetals() {
        try {
            helper.clickElement(RingPageLocators.Metal);
            LoggerHandler.info("Clicked on Metal filter");
            test.log(Status.INFO, "Clicked on Metal filter");

            helper.clickElement(RingPageLocators.Gold);
            LoggerHandler.info("Selected Gold filter");
            test.log(Status.INFO, "Selected Gold filter");

            String title = Base.driver.getTitle();
            String actual = ExcelReader.readCellValue("RingsAndPendant","3","Actual");
            String description=ExcelReader.readCellValue("RingsAndPendant","3","Description");
            helper.verifyEquals(title,actual,description);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnFirstProduct() {
        try {
            // helper.waitUntilElementIsVisible(RingPageLocators.firstProduct, Integer.parseInt(Base.prop.getProperty("ewait")));
            LoggerHandler.info("Waited until first product is visible");
            test.log(Status.INFO, "Waited until first product is visible");

            helper.clickElement(RingPageLocators.firstProduct);
            LoggerHandler.info("Clicked on first product");
            test.log(Status.INFO, "Clicked on first product");

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void addToCart() {
        try {
            helper.clickElement(RingPageLocators.AddtoCart);
            LoggerHandler.info("Clicked on Add to Cart");
            test.log(Status.INFO, "Clicked on Add to Cart");

            Screenshot.takePageScreenShot("FirstRingScreenshot");
            LoggerHandler.info("Screenshot taken: FirstRingScreenshot");
            test.log(Status.INFO, "Screenshot taken: FirstRingScreenshot");

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void callAllMethod() {
        clickOnSerchBar();
        clickOnGender();
        clickOnMetals();
        clickOnFirstProduct();
        addToCart();
    }
}
