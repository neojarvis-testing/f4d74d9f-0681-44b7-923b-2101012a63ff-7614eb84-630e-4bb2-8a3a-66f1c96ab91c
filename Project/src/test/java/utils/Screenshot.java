package utils;
 
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.ExtentTest;
import com.google.common.io.Files;
 
/**
* Creator: Akash Deep
* Description: This class provides methods for capturing screenshots of web pages and web elements,
* as well as utility methods for managing screenshot directories.
*/
public class Screenshot {
 
    public static TakesScreenshot ts;
 
    /**
     * Description: Captures a screenshot and saves it with the specified filename.
     *
     * @param filename The name of the screenshot file.
     * @return The path to the saved screenshot file.
     */
    public static String takePageScreenShot(String filename) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = filename + timestamp + ".png";
 
        String destPath = "./" + name;
 
         ts = (TakesScreenshot) Base.driver;
        File file = ts.getScreenshotAs(OutputType.FILE);
 
        // Create the screenshots directory if it doesn't exist
        File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots"); //Base.prop.getProperty("screenshot")
 
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
     * Description: Captures a screenshot of a specific web element and saves it with a timestamped filename.
     *
     * @param elementLocator - The locator of the web element to capture
     * @param fileName - The base name for the screenshot file
     * @return The file path of the saved screenshot
     */
    public static String takeElementScreenShot(By elementLocator, String fileName) {
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String name = "/" + fileName + timestamp + ".png";
        try {
            WebElement elementParam = Base.driver.findElement(elementLocator);
            File file = elementParam.getScreenshotAs(OutputType.FILE);
            File target = new File(System.getProperty("user.dir") +"/screenshots");
            if (!target.exists()) {
                target.mkdirs();
            }
            FileHandler.copy(file, new File(target.toString() + name));
            return "." + name;
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
        }
        return null;
    }
 
    /**
     * Description: Deletes all files inside the specified directory.
     *
     * @param dirPath - The path of the directory to clear
     */
    public static void deleteAllFilesInsideDirectory(String dirPath) {
        File directory = new File(dirPath);
        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            }
        }
    }

    /**
     * Captures a screenshot of the highlighted element.
     *
     * @param driver   - The WebDriver instance
     * @param locator  - The locator of the element to highlight and capture
     * @param filename - The base name for the screenshot file
     * @return The file path of the saved screenshot
     */
 
    public static void captureHighlightedElementScreenshot( By locator, String filename, ExtentTest test) {
 
        try {
            WebDriverHelper helper=new WebDriverHelper(Base.driver, test);
            WebElement element = Base.driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) Base.driver;
            js.executeScript("arguments[0].setAttribute('style', 'border:solid 5px red');", element);
 
            helper.waitUntilElementIsVisible(locator, 10);
 
           
 
            TakesScreenshot ts = (TakesScreenshot) Base.driver;
            File file = ts.getScreenshotAs(OutputType.FILE);
 
            File screenshotsDir = new File(System.getProperty("user.dir") + "/screenshots"); //"/screenshorts"
 
            if (!screenshotsDir.exists()) {
                screenshotsDir.mkdirs();
            }
 
            String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
 
            String name = filename + timestamp + ".png";
            File target = new File(screenshotsDir, name);
            FileHandler.copy(file, target);
 
        } catch (IOException e) {
            e.printStackTrace();
 
        }
 
    }

}