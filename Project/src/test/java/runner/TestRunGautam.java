package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.BuyPendentsActionGautam;
import pages.BuyRingsActionGautam;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;

public class TestRunGautam extends Base{
    ExtentReports reports;
    ExtentTest test;

    @BeforeClass
    public void reportConfig(){
        reports=Reporter.initializeExtentReport("Reliance Jewles");
    }

    @BeforeMethod
    public void browserConfig(){
        openBrowser();
    }
    
    
    @Test(priority = 1, enabled=true)
    public void BuyRing(){
        test=reports.createTest("Buy Ring Test");
        BuyRingsActionGautam action=new BuyRingsActionGautam(test);
        action.callAllMethod();
    }

    @Test(priority = 2)
    public void BuyPendent(){
        test=reports.createTest("Buy Pendent Test");
        BuyPendentsActionGautam action=new BuyPendentsActionGautam(test);
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
