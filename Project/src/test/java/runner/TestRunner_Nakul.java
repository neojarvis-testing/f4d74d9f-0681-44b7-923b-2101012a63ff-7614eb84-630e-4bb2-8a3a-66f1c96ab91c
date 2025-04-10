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

import pages.NecklaceBuyAndMyCartVerifiedAction_Nakul;
import pages.FooterPoliciesAction_Nakul;
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
    public void Testcase1() {
        try {
            test = reports.createTest("Test Case two");
            NecklaceBuyAndMyCartVerifiedAction_Nakul action = new NecklaceBuyAndMyCartVerifiedAction_Nakul(test);
            action.executeAll();

        } catch (Exception e) {
           LoggerHandler.error(e.getMessage());
           test.log(Status.FAIL, e.getMessage());
        }
    }

    @Test(priority = 2, enabled = true)
    public void Testcase2() {
        try {
            test = reports.createTest("Test Case Nine");
            FooterPoliciesAction_Nakul action = new FooterPoliciesAction_Nakul(test);
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
