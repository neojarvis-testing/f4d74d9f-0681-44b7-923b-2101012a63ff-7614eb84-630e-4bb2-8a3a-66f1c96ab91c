package pages;

import java.time.Duration;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.chainLocatorsAtish;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class chainActionAtish {

    public ExtentTest test;

    public chainActionAtish(ExtentTest test) {
        this.test = test;
    }

    WebDriverHelper helper = new WebDriverHelper(Base.driver, test);

 
    public void VerifyLogo() {
        
            LoggerHandler.info("Verifying Reliance Jewels logo is displayed.");
            test.log(Status.INFO, "Verifying Reliance Jewels logo is displayed.");
            String expectedtitle = "Online Shopping in India";
            helper.verifyEquals(Base.driver.findElement(chainLocatorsAtish.logo).getAttribute("title"), expectedtitle, "Verified logo");
      
    }


    public void hoverOnChain() {
  
            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            LoggerHandler.info("Hovering on Chain.");
            test.log(Status.INFO, "Hovering on Chain.");
        
            helper.hoverOnElement(chainLocatorsAtish.ChainHover);

    }

    public void clickOnSilver() {
     
            LoggerHandler.info("Clicking on Silver.");
            test.log(Status.INFO, "Clicking on Silver.");
            helper.waitUntilElementIsVisible(chainLocatorsAtish.SilverClick, 3);
            helper.clickElement(chainLocatorsAtish.SilverClick);
  
    }

    public void verifyCategoriesKeyword() {
       
            LoggerHandler.info("Verifying the keyword 'Categories'.");
            test.log(Status.INFO, "Verifying the keyword 'Categories'.");
            boolean condition = Base.driver.findElement(chainLocatorsAtish.CategoriesVerify).getText().contains("Categories");
            helper.verifyTrue(condition, "Keyword 'Categories' is verified.");
     
    }

    public void selectGender() {
     
            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            LoggerHandler.info("Clicking on Gender filter.");
            test.log(Status.INFO, "Clicking on Gender filter.");
            helper.clickElement(chainLocatorsAtish.Gender);
            LoggerHandler.info("Selecting Women under Gender filter.");
            test.log(Status.INFO, "Selecting Women under Gender filter.");
            helper.clickElement(chainLocatorsAtish.women);
      
    }


    public void clickOnMoreFilters() {

            LoggerHandler.info("Clicking on More Filters.");
            test.log(Status.INFO, "Clicking on More Filters.");
            helper.clickElement(chainLocatorsAtish.moreFilters);
 
    }

    public void clickOnTryOnAvailable() {

            LoggerHandler.info("Clicking on Try on Available.");
            test.log(Status.INFO, "Clicking on Try on Available.");
            helper.clickElement(chainLocatorsAtish.tryOnAvailable);
    
    }

    public void clickOnYes() {
   
            LoggerHandler.info("Clicking on Yes.");
            test.log(Status.INFO, "Clicking on Yes.");
            helper.clickElement(chainLocatorsAtish.yesButton);
   
    }

    public void selectFirstProduct() {

            Base.driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
            LoggerHandler.info("Clicking on the first product.");
            test.log(Status.INFO, "Clicking on the first product.");
            helper.clickElement(chainLocatorsAtish.firstProductClick);
     
    }

    public void clickOnBuyNow() {
    
            LoggerHandler.info("Clicking on Buy Now.");
            test.log(Status.INFO, "Clicking on Buy Now.");
            helper.clickElement(chainLocatorsAtish.buyNow);
        } 
   

    public void verifyProductCodeAndRecordLogs() {
  
            LoggerHandler.info("Verifying the keyword 'Product Code' and recording logs.");
            test.log(Status.INFO, "Verifying the keyword 'Product Code' and recording logs.");
            boolean condition = Base.driver.findElement(chainLocatorsAtish.productCodeVerify).getText().contains("Product Code");
            helper.verifyTrue(condition, "Verified Product Code");
    
    }

    public void takeScreenshot() {
        try {
            LoggerHandler.info("Taking a screenshot of the product page.");
            test.log(Status.INFO, "Taking a screenshot of the product page.");
            Screenshot.takePageScreenShot("Product screenshot");
            Reporter.addScreenshotToReport("Buy Now clicked ", test, "Buy now clicked ");
        } catch (Exception e) {
            LoggerHandler.error("Failed to take screenshot: " + e.getMessage());
            test.log(Status.FAIL, "Failed to take screenshot: " + e.getMessage());
        }
    }

    public void chainAction() {
    
            LoggerHandler.info("Starting chainAction sequence.");
            test.log(Status.INFO, "Starting chainAction sequence.");
            
            VerifyLogo();
            hoverOnChain();
            clickOnSilver();
            verifyCategoriesKeyword();
            selectGender();
        
            clickOnMoreFilters();
            clickOnTryOnAvailable();
            clickOnYes();
         
            selectFirstProduct();
        //     clickOnBuyNow();
            verifyProductCodeAndRecordLogs();
            takeScreenshot();
            LoggerHandler.info("Completed chainAction sequence.");
            test.log(Status.INFO, "Completed chainAction sequence.");
     
    }
}



