package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.ChainAction;
import pages.HomepageEarringsAction;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;

public class TestRunner_Akash extends Base {

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
    public void Earrings_Purchase()
    {
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
        HomepageEarringsAction action = new HomepageEarringsAction(test);
        action.allFunctionality();

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
