package runner;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import pages.NecklaceBuyAndMyCartVerifiedAction;
import pages.FooterPoliciesAction;
import utils.Base;
import utils.LoggerHandler;
import utils.Reporter;
import utils.WebDriverHelper;

public class TestRunner_Nakul extends Base{
    public ExtentReports reports;
    public ExtentTest test;

    @BeforeClass
    public void reports() {
        reports = Reporter.initializeExtentReport("Reliance_Report");
    }

    @BeforeMethod
    public void open() {
        openBrowser();
    }

    @Test(priority = 1, enabled = true)
    public void Necklace_Buy_And_MyCartVerified() {
        try {
            //test = reports.createTest("Test Case two");
            test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
            LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
            NecklaceBuyAndMyCartVerifiedAction action = new NecklaceBuyAndMyCartVerifiedAction(test);
            action.executeAll();

        } catch (Exception e) {
           LoggerHandler.error(e.getMessage());
           test.log(Status.FAIL, e.getMessage());
        }
    }

    @Test(priority = 2, enabled = true)
    public void Footer_Policies_Testing() {
        try {
            //test = reports.createTest("Test Case Nine");
            test = reports.createTest(new Throwable().getStackTrace()[0].getMethodName());
            LoggerHandler.info(new Throwable().getStackTrace()[0].getMethodName());
            FooterPoliciesAction action = new FooterPoliciesAction(test);
            action.policies();

        } catch (Exception e) {
           LoggerHandler.error(e.getMessage());
           test.log(Status.FAIL, e.getMessage());
        }
    }

    @AfterMethod
    public void quit() {
        driver.quit();
    }

    @AfterClass
    public void flush() {
        reports.flush();
    }
}
