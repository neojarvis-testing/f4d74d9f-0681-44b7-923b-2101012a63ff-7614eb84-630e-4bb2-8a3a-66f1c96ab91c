package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.PlatinumRingActions;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;

public class TestRunner_Sahla extends Base {

    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeClass
    public static void setupReport() {
        reports = Reporter.initializeExtentReport("Reliance_Report");

    }

    @BeforeMethod
    public void configBrowser() {
        openBrowser();

    }

    @Test
    public void Action_To_Buy_Ring() {
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
        PlatinumRingActions actions = new PlatinumRingActions(test);
        actions.buyRing();

    }

    @AfterMethod
    public void tearDownBrowser() {
        driver.quit();
    }

    @AfterClass
    public static void reportFlush() {
        reports.flush();

    }

}
