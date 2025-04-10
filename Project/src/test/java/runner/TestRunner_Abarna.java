package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.HomepageVivaham_Abarna;
import pages.HomepageFooter_Abarna;
import utils.Base;
import utils.Reporter;

public class TestRunner_Abarna extends Base {
    public static ExtentReports reports;
    public static ExtentTest test;

    @BeforeClass
    public static void reportConfig() {
        reports = Reporter.initializeExtentReport("Reliance jewels report");
    }

    @BeforeMethod
    public void browserConfig() {
        openBrowser();
    }

    @Test(priority = 1, enabled = true)
    public void testing() {
        test = reports.createTest("vivaham");
        HomepageVivaham_Abarna vivahActions = new HomepageVivaham_Abarna(test);
        vivahActions.vivahamSection(test);
    }

    @Test(priority = 2, enabled = true)
    public void footerPart() {
        test = reports.createTest("Brand and Customer");
        HomepageFooter_Abarna footerActions = new HomepageFooter_Abarna(test);
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