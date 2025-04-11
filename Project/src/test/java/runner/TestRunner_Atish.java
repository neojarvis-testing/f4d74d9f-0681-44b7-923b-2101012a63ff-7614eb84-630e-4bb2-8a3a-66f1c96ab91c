package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.DiamondAction;
import pages.ChainAction;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;

public class TestRunner_Atish extends Base {
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeClass
    public void configreport() {
        reports = Reporter.initializeExtentReport("Reliance_Report");
    }

    @BeforeMethod
    public void configBrowser() {
        openBrowser();
    }

    @Test(priority = 1, enabled = true)
    public void Diamond_Testing() {
        test = reports.createTest(Thread.currentThread().getName());
        LoggerHandler.info(Thread.currentThread().getName());

        DiamondAction testcasefourAction1 = new DiamondAction(test);

        testcasefourAction1.diamondAction();

    }

    @Test(priority = 2, enabled = true)
    public void Chain_Testing() {
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());

        ChainAction tAction = new ChainAction(test);

        tAction.chainAction();

    }

    @AfterMethod
    public void quitdriver() {
        driver.quit();
    }

    @AfterClass
    public void flushreport() {
        reports.flush();
    }

}
