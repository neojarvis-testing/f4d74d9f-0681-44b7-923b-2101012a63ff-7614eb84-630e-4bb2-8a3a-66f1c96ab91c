package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


import pages.diamondActionAtish;
import pages.chainActionAtish;
import utils.Base;

import utils.Reporter;

public class TestRunnerAtish extends Base {
     public ExtentReports reports;
     public ExtentTest test;

    @BeforeClass
    public  void configreport() {
        reports = Reporter.initializeExtentReport("Reliance Jewels");
    }

    @BeforeMethod
    public void configBrowser() {
        openBrowser();
    }

    @Test(priority = 1, enabled = true)
    public void testcasefour() {
        test = reports.createTest("Testcasefour");

        diamondActionAtish testcasefourAction1 = new diamondActionAtish(test);

        testcasefourAction1.diamondAction();

    }

    @Test(priority = 2, enabled =  true)
    public void testcaseseven()
    {
        test = reports.createTest("TestcaseSeven");

        chainActionAtish tAction = new chainActionAtish(test);

        tAction.chainAction();
      
    }

    @AfterMethod
    public void quitdriver() {
        driver.quit();
    }

    @AfterClass
    public  void flushreport() {
        reports.flush();
    }

}
