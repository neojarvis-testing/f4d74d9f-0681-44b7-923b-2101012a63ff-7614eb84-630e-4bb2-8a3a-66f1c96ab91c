package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomepageVivahamAction;
import pages.HomepageFooterAction;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;

public class TestRunner_Abarna extends Base {
    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeClass
    public static void reportConfig() {
        reports = Reporter.initializeExtentReport("Reliance_Report");
    }

    @BeforeMethod
    public void browserConfig() {
        openBrowser();
    }

    @Test(priority = 1, enabled = true)
    public void Vivaham_Testing() {
        //test = reports.createTest("vivaham");
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
        HomepageVivahamAction vivahActions = new HomepageVivahamAction(test);
        vivahActions.vivahamSection(test);
    }

    @Test(priority = 2, enabled = true)
    public void Brand_And_Customer_footerPart() {
        //test = reports.createTest("Brand and Customer");
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
        HomepageFooterAction footerActions = new HomepageFooterAction(test);
        footerActions.BrandStoryCustomerDelight(test);

    }

    @AfterMethod
    public void quiting() {
        driver.quit();
    }

    @AfterClass
    public static void reportFlush() {
        reports.flush();
    }
}