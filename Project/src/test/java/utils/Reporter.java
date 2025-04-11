package utils;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;
 
import com.google.common.io.Files;
 
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
 
/**
 * Creator: Atish
 *
 * Description: The Reporter class provides methods to generate and manage ExtentReports.
 * It includes functionality to create reports, add screenshots to reports, and manage report files.
 */
public class Reporter extends Base {
       private static ExtentReports extentReport;
       public static TakesScreenshot ts;
 
    /**
     * Description: Generates an ExtentReport instance. If an instance already exists, it returns the existing one.
     *
     * @param reportName The name of the report to be generated.
     * @return An instance of ExtentReports.
     */
    public static ExtentReports initializeExtentReport(String reportName) {
        if (extentReport == null) {
            extentReport = setupExtentReport(reportName);
        }
        return extentReport;
    }
 
    /**
     * Description: Creates a new ExtentReport instance with the specified report name.
     *
     * @param reportName The name of the report to be created.
     * @return A new instance of ExtentReports.
     */
    private static ExtentReports setupExtentReport(String reportName) {
        extentReport = new ExtentReports();
 
        // Load properties from browser.properties file
        String filepath = System.getProperty("user.dir") + "/config/config.properties";
        try (FileInputStream file = new FileInputStream(filepath)) {
            prop = new Properties();
            prop.load(file);
        } catch (IOException e) {
            System.err.println("Error loading properties file: " + e.getMessage());
        }
 
        // Get the current timestamp for the report name
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
        TimeZone istTimeZone = TimeZone.getTimeZone("Asia/Kolkata"); // IST timezone
        dateFormat.setTimeZone(istTimeZone);
        String timestamp = dateFormat.format(new Date());
 
        // Define the report file path with the timestamp and provided report name
        String reportFilePath = System.getProperty("user.dir") + "/reports/";
        if (reportName == null || reportName.isEmpty()) {
            reportName = "Test Report";
        }
        reportFilePath += reportName + "_" + timestamp + ".html";
 
        File extentReportFile = new File(reportFilePath);
 
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
 
        // Configure the report
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Test Report");
        sparkReporter.config().setDocumentTitle("Test Automation Report");
        sparkReporter.config().setTimeStampFormat("yyyy.MM.dd.HH.mm.ss");
 
        extentReport.attachReporter(sparkReporter);
 
        // Set system information
        extentReport.setSystemInfo("Application URL", prop.getProperty("url", "N/A"));
        extentReport.setSystemInfo("Browser Name", prop.getProperty("browserName", "N/A"));
        extentReport.setSystemInfo("Email", prop.getProperty("validEmail", "N/A"));
        extentReport.setSystemInfo("Password", prop.getProperty("validPassword", "N/A"));
        extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReport.setSystemInfo("Username", System.getProperty("user.name"));
        extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
 
        return extentReport;
    }
 
    /**
     * Description: Captures a screenshot and saves it with the specified filename.
     *
     * @param filename The name of the screenshot file.
     * @return The path to the saved screenshot file.
     */
    public static String takeScreenshot(String filename) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";
 
        String destPath = "./" + name;
 
         ts = (TakesScreenshot) driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
 
        // Create the screenshots directory if it doesn't exist
        File screenshotsDir = new File(System.getProperty("user.dir") + Base.prop.getProperty("report")); // "/reports"
 
        if (!screenshotsDir.exists()) {
            screenshotsDir.mkdirs();
        }
 
        File target = new File(screenshotsDir, name);
        try {
            Files.copy(file, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destPath;
    }
 
    /**
     *Description:  Attaches a screenshot to the ExtentReport with the specified file name, test instance, and description.
     *
     * @param filename The name of the screenshot file.
     * @param test The ExtentTest instance to which the screenshot will be added.
     * @param description A description of the screenshot.
     */
    public static void addScreenshotToReport(String filename, ExtentTest test, String description) {
        try {
            test.log(Status.INFO, description, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(filename)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Description:  Attaches a screenshot to the ExtentReport with the specified file name, test instance, and description.
     *
     * @param filename The name of the screenshot file.
     * @param test The ExtentTest instance to which the screenshot will be added.
     * @param description A description of the screenshot.
     */
    public static void addScreenshotToReportfail(String filename, ExtentTest test, String description) {
        try {
            test.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(takeScreenshot(filename)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}