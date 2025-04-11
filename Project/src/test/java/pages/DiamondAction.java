package pages;
 
import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
 
import uistore.DiamondLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;
 
public class DiamondAction {
 
    public ExtentTest test;
    WebDriverHelper helper;

    public DiamondAction(ExtentTest test)
    {
        this.test = test;
        helper = new WebDriverHelper(Base.driver,test);
    }
 
   
    public void VerifyLogo() {
       
            LoggerHandler.info("Verifying Reliance Jewels logo is displayed.");
            test.log(Status.INFO, "Verifying Reliance Jewels logo is displayed.");
            String expectedtitle = ExcelReader.readCellValue("Diamond and Chain", "1", "data");
            helper.verifyEquals(Base.driver.findElement(DiamondLocators.logo).getAttribute("title"), expectedtitle, "Verified logo");
    }
 
    public void hoverOnEarrings() {
       
           
            LoggerHandler.info("Hovering on Earrings.");
            test.log(Status.INFO, "Hovering on Earrings.");
            helper.waitUntilElementIsVisible(DiamondLocators.EarringHover, Integer.parseInt(Base.prop.getProperty("ewait")));
            helper.hoverOnElement(DiamondLocators.EarringHover);
   
    }
 
 
    public void clickOnDiamond() {
   
            LoggerHandler.info("Clicking on Diamond.");
            test.log(Status.INFO, "Clicking on Diamond.");
            helper.waitUntilElementIsVisible(DiamondLocators.DiamondClick, Integer.parseInt(Base.prop.getProperty("ewait")));
            helper.clickElement(DiamondLocators.DiamondClick);
     
    }
 
    public void verifyDiamondKeyword() {
     
            LoggerHandler.info("Verifying the keyword 'Diamond'.");
            test.log(Status.INFO, "Verifying the keyword 'Diamond'.");
            String DiamondVerify = ExcelReader.readCellValue("Diamond and Chain", "3", "data");
            helper.verifyTrue(Base.driver.findElement(DiamondLocators.DiamondVerify).getText().contains(DiamondVerify),"diamond keyword verify");
   
    }
 
    public void selectGender() {
       
           
            LoggerHandler.info("Clicking on Gender filter.");
            test.log(Status.INFO, "Clicking on Gender filter.");
            helper.clickElement(DiamondLocators.Gender);
            LoggerHandler.info("Selecting Women under Gender filter.");
            test.log(Status.INFO, "Selecting Women under Gender filter.");
            helper.waitUntilElementIsVisible(DiamondLocators.women, Integer.parseInt(Base.prop.getProperty("ewait")));
            helper.clickElement(DiamondLocators.women);
           
           
        }
       
       
       
        public void sortByNewArrivals() {
 
           
            LoggerHandler.info("Hovering on Popularity.");
            test.log(Status.INFO, "Hovering on Popularity.");
            helper.hoverOnElement(DiamondLocators.popularity);
            LoggerHandler.info("Clicking on New Arrivals.");
            test.log(Status.INFO, "Clicking on New Arrivals.");
            helper.hoverOnElement(DiamondLocators.newArrivals);
            helper.clickElement(DiamondLocators.newArrivals);
 
    }
 
    public void selectFirstProduct() {
 
            LoggerHandler.info("Clicking on the first product.");
            test.log(Status.INFO, "Clicking on the first product.");
       
            helper.clickElement(DiamondLocators.firstproductclick);
 
    }
 
 
 
    public void addToCart() {
     
            LoggerHandler.info("Clicking on Add to Cart.");
            test.log(Status.INFO, "Clicking on Add to Cart.");
            helper.clickElement(DiamondLocators.addtocart);
     
    }
 
 
 
    public void takeScreenshot() {
 
            LoggerHandler.info("Taking a screenshot of the product page.");
            test.log(Status.INFO, "Taking a screenshot of the product page.");
            Screenshot.takePageScreenShot("Product screenshot");
            Reporter.addScreenshotToReport("productadded", test, "Product added to the cart");
 
    }
 
    public void diamondAction( ) {
        try {
            LoggerHandler.info("Starting diamondAction sequence.");
            test.log(Status.INFO, "Starting diamondAction sequence.");
            VerifyLogo();
            hoverOnEarrings();
            clickOnDiamond();
            verifyDiamondKeyword();
            selectGender();
            sortByNewArrivals();
            selectFirstProduct();
            addToCart();
            takeScreenshot();
            LoggerHandler.info("Completed diamondAction sequence.");
            test.log(Status.INFO, "Completed diamondAction sequence.");
        } catch (Exception e) {
            LoggerHandler.error("Failed to complete diamondAction sequence: " + e.getMessage());
            test.log(Status.FAIL, "Failed to complete diamondAction sequence: " + e.getMessage());
        }
    }
}