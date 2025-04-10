package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.RelianceJewelsActions_Sahla;
import utils.Base;
import utils.Reporter;

public class TestRunner_Sahla extends Base {

    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeClass
    public static void setupReport() {
        reports = Reporter.initializeExtentReport("Reliance Jewels Report");

    }

    @BeforeMethod
    public void configBrowser() {
        openBrowser();

    }

    @Test
    public void buyRing() {
        test = reports.createTest("Actions to buy a ring");
        RelianceJewelsActions_Sahla actions = new RelianceJewelsActions_Sahla(test);
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
