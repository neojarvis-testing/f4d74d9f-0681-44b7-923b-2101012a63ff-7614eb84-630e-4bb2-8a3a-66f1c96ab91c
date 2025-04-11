package utils;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

/**
 * Creator: Nakul J Gowda
 * Description: This class provides helper methods for interacting with
 * WebDriver,
 * such as clicking elements, handling windows, and performing actions on web
 * elements.
 */
public class WebDriverHelper {

    private WebDriver driver;
    private ExtentTest test;

    /**
     * Description: Constructor to initialize the WebDriverHelper class with a
     * WebDriver instance.
     * 
     * @param driver - WebDriver instance
     */
    public WebDriverHelper(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test = test;
    }

    /**
     * Description: Waits for a web element to be visible within the specified
     * timeout.
     * 
     * @param locator          - Locator of the element
     * @param timeoutInSeconds - Maximum time to wait in seconds
     */
    public void waitUntilElementIsVisible(By locator, int timeoutInSeconds) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to locate element", test, e.getMessage());
        }
    }

    /**
     * // * Description: Clicks on a web element located by the given locator.
     * // * @param locator - Locator of the element
     * //
     */
    public void clickElement(By locator) {
        try {
            driver.findElement(locator)
                    .click();
        }catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to locate element and hover", test, e.getMessage());
        }
    }

    /**
     * // * Description: Sends keys (text) to a web element located by the given
     * locator.
     * // * @param locator - Locator of the element
     * // * @param data - Text to be sent
     * //
     */
    public void typeIntoElement(By locator, String data) {
        try {
            driver.findElement(locator)
                    .sendKeys(data);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to write on element", test, e.getMessage());
        }
    }

    /**
     * // * Description: Retrieves the text content of a web element located by the
     * given locator.
     * // * @param locator - Locator of the element
     * // * @return The text content of the element, or an empty string if an
     * exception occurs
     * //
     */
    public String retrieveElementText(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to retrieve text from element", test, e.getMessage());
            return " ";
        }
    }

    /**
     * // * Description: Sends an ENTER key press to a web element located by the
     * given locator.
     * // * @param locator - Locator of the element
     * //
     */
    public void pressEnterKey(By locator) {
        try {
            driver.findElement(locator)
                    .sendKeys(Keys.ENTER);
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to perform ENTER action on element", test, e.getMessage());
        }
    }

    /**
     * Description: Hovers over a web element located by the given locator.
     * 
     * @param locator - Locator of the element
     */
    public void hoverOnElement(By locator) {
        //String message="";
        try {
            WebElement webElement = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(webElement).perform();
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            //message+=e.getMessage();
            Reporter.addScreenshotToReportfail("Unable to locate element and hover", test, e.getMessage());
        }
    }

    /**
     * Description: Switches the WebDriver control to a new browser window.
     */
    public void switchToChildWindow() {
        try {
            String parentId = driver.getWindowHandle();
            Set<String> childIds = driver.getWindowHandles();

            for (String id : childIds) {
                if (!parentId.equals(id)) {
                    driver.switchTo().window(id);
                }
            }
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to switch to different a window", test, e.getMessage());
        }
    }

    /**
     * Description: Retrieves a list of web elements located by the given XPath.
     * 
     * @param locator - XPath locator for the elements
     * @return List of web elements, or null if an exception occurs
     */
    public List<WebElement> findElementsByXpath(String locator) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(locator));
            return elements;
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to find the elements", test, e.getMessage());
        }
        return null;
    }

    /**
     * Scrolls the web page by the specified number of pixels either vertically or
     * horizontally.
     * 
     * @param scroll - Determines the scroll direction: '0' for vertical scrolling
     *               and '1' for horizontal scrolling.
     * @param pixals - Number of pixels to scroll. Positive values scroll down or
     *               right, and negative values scroll up or left.
     * @throws IllegalArgumentException - Thrown when the 'scroll' parameter has an
     *                                  invalid value (not 0 or 1).
     */
    public void scrollInWebPage(int scroll, int pixals) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;

            if (scroll == 0) {
                js.executeScript("window.scrollBy(0," + pixals + ")", "");
            } else if (scroll == 1) {
                js.executeScript("window.scrollBy(" + pixals + ",0)", "");
            } else {
                throw new IllegalArgumentException(
                        "Invalid value for 'scroll'. Use '0' for vertical scrolling and '1' for horizontal scrolling.");
            }
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll", test, e.getMessage());
        }
    }

    /**
     * Scrolls the web page until the specified element is visible in the viewport.
     * 
     * @param locator - Locator of the element to bring into view.
     */
    public void scrollInWebPageTillVisible(By locator) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll to a specific element", test, e.getMessage());
        }
    }

    /**
     * Scrolls to the end of the web page by using JavaScript execution.
     */
    public void scrollInWebPageEnd() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
        } catch (Exception e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail("Unable to scroll to End", test, e.getMessage());
        }
    }

    /**
     * Verifies that two strings are equal and logs the result along with a
     * description.
     *
     * This method asserts that the actual value matches the expected value and logs
     * the provided description for better context. If the assertion fails, it
     * captures
     * the error message and attaches a screenshot to the report for debugging
     * purposes.
     *
     * @param actual      The actual value to compare.
     * @param expected    The expected value for comparison.
     * @param description A brief description of the validation being performed.
     */
    public void verifyEquals(String actual, String expected, String description) {
        try {
            Assert.assertEquals(actual, expected);
            LoggerHandler.info(description);
            test.log(Status.PASS, description);
        } catch (AssertionError e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail(description, test, e.getMessage());
        }
    }

    /**
     * Verifies that a condition is true and logs the result along with a
     * description.
     *
     * This method asserts that the given condition evaluates to true and logs
     * the provided description for context. If the assertion fails, it captures
     * the error message and attaches a screenshot to the report for debugging
     * purposes.
     *
     * @param condition   The condition to verify.
     * @param description A brief description of the verification being performed.
     */
    public void verifyTrue(boolean condition, String description) {
        try {
            Assert.assertTrue(condition);
            LoggerHandler.info(description);
            test.log(Status.PASS, description);
        } catch (AssertionError e) {
            LoggerHandler.error(e.getMessage());
            Reporter.addScreenshotToReportfail(description, test, e.getMessage());
        }
    }

    /**
     * Description: Clears the content of a text input field located by the given
     * locator.
     * 
     * @param locator - Locator of the element
     */
    public void clearTextInputField(By locator) {
        driver.findElement(locator).clear();
    }
}