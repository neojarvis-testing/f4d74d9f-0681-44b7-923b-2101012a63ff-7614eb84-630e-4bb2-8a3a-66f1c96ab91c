package pages;

import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.diamondLocatorsAtish;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class diamondActionAtish {

    public ExtentTest test;

    public diamondActionAtish(ExtentTest test)
    {
        this.test = test;
    }

    WebDriverHelper helper = new WebDriverHelper(Base.driver,test);
    
    public void VerifyLogo() {
        
            LoggerHandler.info("Verifying Reliance Jewels logo is displayed.");
            test.log(Status.INFO, "Verifying Reliance Jewels logo is displayed.");
            String expectedtitle = "Online Shopping in India";
            helper.verifyEquals(Base.driver.findElement(diamondLocatorsAtish.logo).getAttribute("title"), expectedtitle, "Verified logo");
    }

    public void hoverOnEarrings() {
       
            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            LoggerHandler.info("Hovering on Earrings.");
            test.log(Status.INFO, "Hovering on Earrings.");
            helper.waitUntilElementIsVisible(diamondLocatorsAtish.EarringHover, 3);
            helper.hoverOnElement(diamondLocatorsAtish.EarringHover);
    
    }


    public void clickOnDiamond() {
   
            LoggerHandler.info("Clicking on Diamond.");
            test.log(Status.INFO, "Clicking on Diamond.");
            helper.waitUntilElementIsVisible(diamondLocatorsAtish.DiamondClick, 3);
            helper.clickElement(diamondLocatorsAtish.DiamondClick);
      
    }

    public void verifyDiamondKeyword() {
     
            LoggerHandler.info("Verifying the keyword 'Diamond'.");
            test.log(Status.INFO, "Verifying the keyword 'Diamond'.");
            helper.verifyTrue(Base.driver.findElement(diamondLocatorsAtish.DiamondVerify).getText().contains("Diamond"),"diamond keyword verify");
    
    }

    public void selectGender() {
       
            // Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            LoggerHandler.info("Clicking on Gender filter.");
            test.log(Status.INFO, "Clicking on Gender filter.");
            helper.clickElement(diamondLocatorsAtish.Gender);
            LoggerHandler.info("Selecting Women under Gender filter.");
            test.log(Status.INFO, "Selecting Women under Gender filter.");
            helper.waitUntilElementIsVisible(diamondLocatorsAtish.women, 3);
            helper.clickElement(diamondLocatorsAtish.women);
            
            
        }
        
        
        
        public void sortByNewArrivals() {

            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            LoggerHandler.info("Hovering on Popularity.");
            test.log(Status.INFO, "Hovering on Popularity.");
            helper.hoverOnElement(diamondLocatorsAtish.popularity);
            LoggerHandler.info("Clicking on New Arrivals.");
            test.log(Status.INFO, "Clicking on New Arrivals.");
            helper.hoverOnElement(diamondLocatorsAtish.newArrivals);
            helper.clickElement(diamondLocatorsAtish.newArrivals);

    }

    public void selectFirstProduct() {

            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            LoggerHandler.info("Clicking on the first product.");
            test.log(Status.INFO, "Clicking on the first product.");
        //     helper.waitUntilElementIsVisible(testcasefourlocators.firstproductclick, 2);
            helper.clickElement(diamondLocatorsAtish.firstproductclick);

    }

    // public void verifyEarringsKeyword() {
    //     try {
    //         LoggerHandler.info("Verifying the keyword 'Earrings'.");
    //         test.log(Status.INFO, "Verifying the keyword 'Earrings'.");
    //         helper.verifyTrue(Base.driver.findElement(testcasefourlocators.keywordEarring).getText().contains("Earrings"), "Earrings Verified");
    //     } catch (Exception e) {
    //         LoggerHandler.error("Failed to verify the keyword 'Earrings': " + e.getMessage());
    //         test.log(Status.FAIL, "Failed to verify the keyword 'Earrings': " + e.getMessage());
    //     }
    // }

    public void addToCart() {
      
            LoggerHandler.info("Clicking on Add to Cart.");
            test.log(Status.INFO, "Clicking on Add to Cart.");
        //     helper.waitUntilElementIsVisible(testcasefourlocators.addtocart, 3);
            helper.clickElement(diamondLocatorsAtish.addtocart);
     
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
            // VerifyLogo();
            hoverOnEarrings();
            clickOnDiamond();
            verifyDiamondKeyword();
            selectGender();
            
            sortByNewArrivals();
            selectFirstProduct();
            // verifyEarringsKeyword();
            addToCart();
            // verifyOtherKeywordAndRecordLogs();
            takeScreenshot();
            LoggerHandler.info("Completed diamondAction sequence.");
            test.log(Status.INFO, "Completed diamondAction sequence.");
        } catch (Exception e) {
            LoggerHandler.error("Failed to complete diamondAction sequence: " + e.getMessage());
            test.log(Status.FAIL, "Failed to complete diamondAction sequence: " + e.getMessage());
        }
    }
}
