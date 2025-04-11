package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.PlatinumRingLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Screenshot;
import utils.WebDriverHelper;

public class PlatinumRingActions {

    public ExtentTest test;
    WebDriverHelper helper;

    public PlatinumRingActions(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
    }

    public void hoverRings() {

        String data = ExcelReader.readCellValue("Platinum Ring details", "1", "title");
        test.log(Status.INFO, data);
        LoggerHandler.info(data);

        String data1 = ExcelReader.readCellValue("Platinum Ring details", "1", "actual");
        helper.verifyEquals(data1,
                Base.driver.findElement(PlatinumRingLocators.relianceLogo).getAttribute("title"),
                "Verify logo");

        helper.hoverOnElement(PlatinumRingLocators.hoverRings);

        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.hoverRings));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.hoverRings));

    }

    public void casualWear() {
        //helper.waitUntilElementIsVisible(null, 0);
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCasualWear));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCasualWear));

        helper.clickElement(PlatinumRingLocators.clickCasualWear);

        String cureentUrl = Base.driver.getCurrentUrl();
        String actualUrl = ExcelReader.readCellValue("Platinum Ring details", "5", "actual");

        boolean condition = cureentUrl.contains(actualUrl);
        helper.verifyTrue(condition, "cureentUrl");

    }

    public void categories() {
        helper.waitUntilElementIsVisible(PlatinumRingLocators.clickCategory, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCategory));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickCategory));
        helper.clickElement(PlatinumRingLocators.clickCategory);

    }

    public void platinum() {
        helper.waitUntilElementIsVisible(PlatinumRingLocators.clickCategory, Integer.parseInt(Base.prop.getProperty("ewait")));
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickPlatinum));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickPlatinum));
        try {
            Thread.sleep(3000);
            helper.clickElement(PlatinumRingLocators.clickPlatinum);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String platinum = Base.driver.findElement(PlatinumRingLocators.verifyPlatinum).getText();
        String actualPlatinum = ExcelReader.readCellValue("Platinum Ring details", "2", "actual");
        boolean condition = platinum.contains(actualPlatinum);
        helper.verifyTrue(condition, "platinum products");

    }

    public void moreFilters() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickMorefilters));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickMorefilters));
        helper.clickElement(PlatinumRingLocators.clickMorefilters);

    }

    public void tryOn() {
        LoggerHandler.info("Clicked on" + helper.retrieveElementText(PlatinumRingLocators.clickTryOn));
        test.log(Status.INFO, "Clicked on" + helper.retrieveElementText(PlatinumRingLocators.clickTryOn));
        helper.clickElement(PlatinumRingLocators.clickTryOn);

    }

    public void yes() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickYes));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickYes));
        helper.clickElement(PlatinumRingLocators.clickYes);

        String tryOn = Base.driver.findElement(PlatinumRingLocators.verifyTryOn).getText();
        String actualYes = ExcelReader.readCellValue("Platinum Ring details", "3", "actual");
        boolean condition = tryOn.contains(actualYes);
        helper.verifyTrue(condition, "Try on available");
    }

    public void firstProduct() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickFirstProduct));
        test.log(Status.INFO,
                "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickFirstProduct));
        helper.clickElement(PlatinumRingLocators.clickFirstProduct);

    }

    public void buyNow() {
        LoggerHandler.info("Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickBuyNow));
        test.log(Status.INFO, "Clicked on " + helper.retrieveElementText(PlatinumRingLocators.clickBuyNow));
        helper.clickElement(PlatinumRingLocators.clickBuyNow);

        Screenshot.takePageScreenShot("Platium Ring added to cart");

        String productCode = Base.driver.findElement(PlatinumRingLocators.verifyProductCode).getText();
        String actualProductCode = ExcelReader.readCellValue("Platinum Ring details", "4", "actual");
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
