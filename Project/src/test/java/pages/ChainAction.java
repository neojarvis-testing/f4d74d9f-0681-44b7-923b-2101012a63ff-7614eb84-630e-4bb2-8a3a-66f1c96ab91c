package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.ChainLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;

public class ChainAction {

    public ExtentTest test;
    WebDriverHelper helper;

    public ChainAction(ExtentTest test) {
        this.test = test;
        helper = new WebDriverHelper(Base.driver, test);
    }


    public void VerifyLogo() {

        LoggerHandler.info("Verifying Reliance Jewels logo is displayed.");
        test.log(Status.INFO, "Verifying Reliance Jewels logo is displayed.");

        String expectedtitle = ExcelReader.readCellValue("Diamond and Chain", "1", "data");
        helper.verifyEquals(Base.driver.findElement(ChainLocators.logo).getAttribute("title"),
                expectedtitle, "Verified logo");

    }

    public void hoverOnChain() {

        LoggerHandler.info("Hovering on Chain.");
        test.log(Status.INFO, "Hovering on Chain.");
        helper.hoverOnElement(ChainLocators.ChainHover);

    }

    public void clickOnSilver() {

        LoggerHandler.info("Clicking on Silver.");
        test.log(Status.INFO, "Clicking on Silver.");
        helper.waitUntilElementIsVisible(ChainLocators.SilverClick, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.clickElement(ChainLocators.SilverClick);

    }

    public void verifyCategoriesKeyword() {

        LoggerHandler.info("Verifying the keyword 'Categories'.");
        test.log(Status.INFO, "Verifying the keyword 'Categories'.");
        String CategoriesVerify = ExcelReader.readCellValue("Diamond and Chain", "2", "data");
        boolean condition = Base.driver.findElement(ChainLocators.CategoriesVerify).getText()
                .contains(CategoriesVerify);
        helper.verifyTrue(condition, "Keyword 'Categories' is verified.");

    }

    public void selectGender() {

        LoggerHandler.info("Clicking on Gender filter.");
        test.log(Status.INFO, "Clicking on Gender filter.");
        helper.clickElement(ChainLocators.Gender);
        LoggerHandler.info("Selecting Women under Gender filter.");
        test.log(Status.INFO, "Selecting Women under Gender filter.");
        helper.clickElement(ChainLocators.women);

    }

    public void clickOnMoreFilters() {

        LoggerHandler.info("Clicking on More Filters.");
        test.log(Status.INFO, "Clicking on More Filters.");
        helper.clickElement(ChainLocators.moreFilters);

    }

    public void clickOnTryOnAvailable() {

        LoggerHandler.info("Clicking on Try on Available.");
        test.log(Status.INFO, "Clicking on Try on Available.");
        helper.clickElement(ChainLocators.tryOnAvailable);

    }

    public void clickOnYes() {

        LoggerHandler.info("Clicking on Yes.");
        test.log(Status.INFO, "Clicking on Yes.");
        helper.clickElement(ChainLocators.yesButton);

    }

    public void selectFirstProduct() {

        LoggerHandler.info("Clicking on the first product.");
        test.log(Status.INFO, "Clicking on the first product.");
        helper.clickElement(ChainLocators.firstProductClick);

    }

    public void clickOnBuyNow() {

        LoggerHandler.info("Clicking on Buy Now.");
        test.log(Status.INFO, "Clicking on Buy Now.");
        WebElement element = Base.driver.findElement(By.id("item-size"));
        Select select = new Select(element);
        select.selectByValue("46cm");
    }

    public void verifyProductCodeAndRecordLogs() {

        LoggerHandler.info("Verifying the keyword 'Product Code' and recording logs.");
        test.log(Status.INFO, "Verifying the keyword 'Product Code' and recording logs.");
        String Productcodeverify = ExcelReader.readCellValue("Diamond and Chain", "4", "data");
        boolean condition = Base.driver.findElement(ChainLocators.productCodeVerify).getText()
                .contains(Productcodeverify);
        helper.verifyTrue(condition, "Verified Product Code");
        //helper.verifyEquals(helper.retrieveElementText(ChainLocators.productCodeVerify), Productcodeverify, "Verified Product Code");

    }

    public void clickonBuynowafterweight() {
        WebElement element = Base.driver.findElement(By.id("item-weight"));
        Select select = new Select(element);
        select.selectByValue("1570767");
        helper.clickElement(ChainLocators.buyNow);
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
        clickOnBuyNow();
        verifyProductCodeAndRecordLogs();
        clickonBuynowafterweight();
        takeScreenshot();
        LoggerHandler.info("Completed chainAction sequence.");
        test.log(Status.INFO, "Completed chainAction sequence.");

    }
}