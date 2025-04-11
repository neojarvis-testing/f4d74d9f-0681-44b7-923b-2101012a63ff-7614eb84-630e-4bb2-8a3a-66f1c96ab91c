package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BuyPendentsAction;
import pages.BuyRingsAction;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class TestRunner_Gautam extends Base{
    ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    public void reportConfig(){
        reports=Reporter.initializeExtentReport("Reliance_Report");
    }

    @BeforeMethod
    public void browserConfig(){
        openBrowser();
    }
    
    
    @Test(priority = 1, enabled=true)
    public void Buy_Ring_Test(){
        //test=reports.createTest("Buy Ring Test");
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
        BuyRingsAction action=new BuyRingsAction(test);
        action.callAllMethod();
    }

    @Test(priority = 2)
    public void Buy_Pendent_Test(){
        //test=reports.createTest("Buy Pendent Test");
        test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
        LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
        BuyPendentsAction action=new BuyPendentsAction(test);
        action.callAllAction();
        
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @AfterClass
    public void flushreports(){
        reports.flush();
    }
}
