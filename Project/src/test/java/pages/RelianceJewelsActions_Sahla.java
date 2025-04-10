package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.RelianceJewelsLocators_Sahla;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class RelianceJewelsActions_Sahla {

    public ExtentTest test;
    WebDriverHelper helper;

    public RelianceJewelsActions_Sahla(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
    }

    public void hoverRings() {

        String data = ExcelReader.readCellValue("ExcelSheetSahla", "1", "title");
        test.log(Status.INFO, data);
        Reporter.addScreenshotToReport("reliancejewels", test, "ss captured");
        LoggerHandler.info(data);

        String data1 = ExcelReader.readCellValue("ExcelSheetSahla", "1", "actual");
        helper.verifyEquals(data1,
                Base.driver.findElement(RelianceJewelsLocators_Sahla.relianceLogo).getAttribute("title"),
                "Verify logo");

        helper.hoverOnElement(RelianceJewelsLocators_Sahla.hoverRings);

        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.hoverRings));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.hoverRings));

    }

    public void casualWear() {
        helper.waitUntilElementIsVisible(null, 0);
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickCasualWear));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickCasualWear));

        helper.clickElement(RelianceJewelsLocators_Sahla.clickCasualWear);

        String cureentUrl = Base.driver.getCurrentUrl();
        String actualUrl = ExcelReader.readCellValue("ExcelSheetSahla", "5", "actual");

        boolean condition = cureentUrl.contains(actualUrl);
        helper.verifyTrue(condition, "cureentUrl");

    }

    public void categories() {
        helper.waitUntilElementIsVisible(RelianceJewelsLocators_Sahla.clickCategory, 10);
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickCategory));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickCategory));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickCategory);

    }

    public void platinum() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickPlatinum));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickPlatinum));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickPlatinum);

        String platinum = Base.driver.findElement(RelianceJewelsLocators_Sahla.verifyPlatinum).getText();
        String actualPlatinum = ExcelReader.readCellValue("ExcelSheetSahla", "2", "actual");
        boolean condition = platinum.contains(actualPlatinum);
        helper.verifyTrue(condition, "platinum products");

    }

    public void moreFilters() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickMorefilters));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickMorefilters));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickMorefilters);

    }

    public void tryOn() {
        LoggerHandler.info("Clicked on" + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickTryOn));
        test.log(Status.INFO, "Clicked on" + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickTryOn));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickTryOn);

    }

    public void yes() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickYes));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickYes));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickYes);

        String tryOn = Base.driver.findElement(RelianceJewelsLocators_Sahla.verifyTryOn).getText();
        String actualYes = ExcelReader.readCellValue("ExcelSheetSahla", "3", "actual");
        boolean condition = tryOn.contains(actualYes);
        helper.verifyTrue(condition, "Try on available");
    }

    public void firstProduct() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickFirstProduct));
        test.log(Status.INFO,
                "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickFirstProduct));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickFirstProduct);

    }

    public void buyNow() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickBuyNow));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(RelianceJewelsLocators_Sahla.clickBuyNow));
        helper.clickElement(RelianceJewelsLocators_Sahla.clickBuyNow);

        Screenshot.takePageScreenShot("reliancejewels");

        String productCode = Base.driver.findElement(RelianceJewelsLocators_Sahla.verifyProductCode).getText();
        String actualProductCode = ExcelReader.readCellValue("ExcelSheetSahla", "4", "actual");
        boolean condition = productCode.contains(actualProductCode);
        helper.verifyTrue(condition, "Product code");

    }

    public void buyRing() {
        hoverRings();
        casualWear();
        categories();
        platinum();
        moreFilters();
        tryOn();
        yes();
        firstProduct();
        buyNow();
    }

}
