package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.TestFiveActionAkash;
import utils.Base;
import utils.Reporter;

public class TestRunnerAkash extends Base {

    public ExtentReports reports;
    public ExtentTest test;


    @BeforeClass
    public void configreport()
    {
        reports = Reporter.initializeExtentReport("Reliance_Report");
    }

    @BeforeMethod
    public void launchingBrowser()
    {
        openBrowser();
    }
    @Test
    public void testcasefive()
    {
        test=reports.createTest("Reliance jewels Test");
        TestFiveActionAkash action = new TestFiveActionAkash(test);
        action.clicksOnEarrings();
        action.clicksOnCategories();
        action.clicksOnMoreFilters();
        action.clicksOnProduct();
        action.buyNowProduct();
        

    }

    @AfterMethod
    public void closingBrowser()
    {
       driver.quit();
    }

    @AfterClass
    public void flushingreport()
    {
        reports.flush();
    }
    
}
