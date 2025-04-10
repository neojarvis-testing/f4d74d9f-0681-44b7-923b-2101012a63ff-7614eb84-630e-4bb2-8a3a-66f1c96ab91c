package pages;

import java.time.Duration;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomePageLocatorsGautam;
import uistore.RingPageLocatorsGautam;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class BuyRingsActionGautam {

    public ExtentTest test;
    public BuyRingsActionGautam(ExtentTest test){
        this.test = test;
    }
    
    WebDriverHelper helper = new WebDriverHelper(Base.driver, test);

    public void clickOnSerchBar() {
        try {
            helper.clickElement(HomePageLocatorsGautam.searchBarLocator);
            LoggerHandler.info("Clicked on search bar");
            test.log(Status.INFO, "Clicked on search bar");

            String data = ExcelReader.readCellValue("Gautam", "1", "Items");
            helper.typeIntoElement(HomePageLocatorsGautam.searchBarLocator, data);
            LoggerHandler.info("Typed into search bar: " + data);
            test.log(Status.INFO, "Typed into search bar: " + data);

            helper.pressEnterKey(HomePageLocatorsGautam.searchBarLocator);
            LoggerHandler.info("Pressed Enter key");
            test.log(Status.INFO, "Pressed Enter key");

            

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL , e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnGender() {
        try {
            helper.clickElement(RingPageLocatorsGautam.Gender);
            LoggerHandler.info("Clicked on Gender filter");
            test.log(Status.INFO, "Clicked on Gender filter");

            helper.clickElement(RingPageLocatorsGautam.Mens);
            LoggerHandler.info("Selected Mens filter");
            test.log(Status.INFO, "Selected Mens filter");
            String title = Base.driver.getTitle().toLowerCase();
            String actual = "men | rings - reliancejewels.com";
            String description="Rings For MenPage";
            helper.verifyEquals(title,actual,description);
            
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnMetals() {
        try {
            helper.clickElement(RingPageLocatorsGautam.Metal);
            LoggerHandler.info("Clicked on Metal filter");
            test.log(Status.INFO, "Clicked on Metal filter");

            helper.clickElement(RingPageLocatorsGautam.Gold);
            LoggerHandler.info("Selected Gold filter");
            test.log(Status.INFO, "Selected Gold filter");

        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            test.log(Status.FAIL, e.getMessage());
            e.printStackTrace();
        }
    }

    public void clickOnFirstProduct() {
        try {
            helper.waitUntilElementIsVisible(RingPageLocatorsGautam.firstProduct, 10);
            LoggerHandler.info("Waited until first product is visible");
            test.log(Status.INFO, "Waited until first product is visible");

            helper.clickElement(RingPageLocatorsGautam.firstProduct);
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
            helper.clickElement(RingPageLocatorsGautam.AddtoCart);
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
