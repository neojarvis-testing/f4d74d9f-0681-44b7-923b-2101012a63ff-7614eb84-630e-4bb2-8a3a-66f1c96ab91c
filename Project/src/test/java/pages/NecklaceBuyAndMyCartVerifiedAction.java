package pages;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.NecklaceBuyAndMyCartVerifiedLocator;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class NecklaceBuyAndMyCartVerifiedAction {
    
    public ExtentTest test;
    WebDriverHelper helper ;

    public NecklaceBuyAndMyCartVerifiedAction(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
    }

   

    public void VerifyLogoOfRelianceJewels(){
        LoggerHandler.info("Inside browser");
        test.log(Status.INFO, "Inside browser");
        helper.waitUntilElementIsVisible(NecklaceBuyAndMyCartVerifiedLocator.logo, Integer.parseInt(Base.prop.getProperty("ewait")));
        String title = ExcelReader.readCellValue("Necklace and Add Cart", "1","value" );
        helper.verifyEquals(title,Base.driver.findElement(NecklaceBuyAndMyCartVerifiedLocator.logo).getAttribute("Title"), "Verified Logo");
    }

    public void searchOperation(){
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.search);
        LoggerHandler.info("Clicked on search bar");
        test.log(Status.INFO, "Clicked on search bar");
        helper.typeIntoElement(NecklaceBuyAndMyCartVerifiedLocator.search, ExcelReader.readCellValue("Necklace and Add Cart", "2","value" )); //"Necklace"
        LoggerHandler.info("Entered text into search bar");
        test.log(Status.INFO, "Entered text into search bar");
        helper.pressEnterKey(NecklaceBuyAndMyCartVerifiedLocator.search);
        LoggerHandler.info("Enter action on search bar");
        test.log(Status.INFO, "Enter action on search bar");
    }

    public void NecklaceResultPage(){
        LoggerHandler.info("Necklace Result Page");
        test.log(Status.INFO, "Necklace Result Page");
    }

    public void popUpActions(){
        helper.hoverOnElement(NecklaceBuyAndMyCartVerifiedLocator.hover);
        LoggerHandler.info("Hover over the element");
        test.log(Status.INFO, "Hover over the element");
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.quickView);
        LoggerHandler.info("View Quick start");
        test.log(Status.INFO, "View Quick start");
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.close);
        LoggerHandler.info("Closed pop-up");
        test.log(Status.INFO, "Closed pop-up");
    }

    public void clickAndVerifyTheFirstProduct(){
        String first = helper.retrieveElementText(NecklaceBuyAndMyCartVerifiedLocator.firstProduct);
        //LoggerHandler.warn(first);
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.firstProduct);
        //LoggerHandler.warn(Base.driver.getTitle());
        helper.verifyTrue(Base.driver.getTitle().contains(first), "Verifyed the redirected to first product page");
        test.log(Status.PASS,"Verifyed the redirected to first product page");
    }

    public void FirstNecklaceDetailsPage(){
        helper.waitUntilElementIsVisible(NecklaceBuyAndMyCartVerifiedLocator.dropdown, 10);
        Select objSelect = new Select(Base.driver.findElement(NecklaceBuyAndMyCartVerifiedLocator.dropdown));
        objSelect.selectByIndex(1);
        LoggerHandler.info("first product weight");
        test.log(Status.INFO, "first product weight");
        helper.clickElement(NecklaceBuyAndMyCartVerifiedLocator.buyNow);
    }

    public void verifyMyCart(){
        helper.verifyEquals(helper.retrieveElementText(NecklaceBuyAndMyCartVerifiedLocator.Cart), ExcelReader.readCellValue("Necklace and Add Cart", "3","value" ), "Verified My Card");
        test.log(Status.PASS,"Verified My Card");
        Screenshot.takePageScreenShot("My Cart");
        Reporter.addScreenshotToReport("My Cart", test, "Verified My Card");
        LoggerHandler.info("Exit browser");
        test.log(Status.INFO, "Exit browser");
    }

    public void executeAll(){
        VerifyLogoOfRelianceJewels();
        searchOperation();
        NecklaceResultPage();
        popUpActions();
        clickAndVerifyTheFirstProduct();
        FirstNecklaceDetailsPage();
        verifyMyCart();
    }
}
