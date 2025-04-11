package pages;

import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.HomepageVivahamLocators;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.Reporter;
import utils.Screenshot;
import utils.WebDriverHelper;


public class HomepageVivahamAction {

    public ExtentTest test;
    WebDriverHelper helper;

    public HomepageVivahamAction(ExtentTest test){    
        this.test=test;
        helper = new WebDriverHelper(Base.driver,test);
    }

    String parent =Base.driver.getWindowHandle();

    public void Whatstrending(){
        try {     
            helper.hoverOnElement(HomepageVivahamLocators.Whatstrending);
            test.log(Status.INFO, "hovered on Whats trending");
            LoggerHandler.info("hovered on Whats trending");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Vivaham(){
        try {
            helper.clickElement(HomepageVivahamLocators.Vivaham); 
            test.log(Status.INFO, "clicked on whats trending");        
            LoggerHandler.info("clicked on whats trending");  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void locateStore(){
        try {
            helper.clickElement(HomepageVivahamLocators.Locatestore);   
            test.log(Status.INFO, "clicked on locate store");        
            LoggerHandler.info("clicked on locate store");  
            Reporter.addScreenshotToReport("LocateStore", test, "Captured screenshot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void selectState(){
        try {
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        helper.switchToChildWindow();
        helper.waitUntilElementIsVisible(HomepageVivahamLocators.state, Integer.parseInt(Base.prop.getProperty("ewait")));
        Select select = new Select(Base.driver.findElement(HomepageVivahamLocators.state));
        select.selectByValue(ExcelReader.readCellValue("ExcelSheetAbarna","2","City"));
        test.log(Status.INFO, "Selected state value");
        LoggerHandler.info("Selected state value");  
    }
    
    public void selectCity(){
        helper.waitUntilElementIsVisible(HomepageVivahamLocators.city, Integer.parseInt(Base.prop.getProperty("ewait")));
        Select select = new Select(Base.driver.findElement(HomepageVivahamLocators.city));
        select.selectByValue(ExcelReader.readCellValue("ExcelSheetAbarna", "1", "City"));
        test.log(Status.INFO, "Selected city value");
        LoggerHandler.info("Selected city value");  

    }
    
    public void clickSearch(){
        
        helper.clickElement(HomepageVivahamLocators.clickSearch);
        Base.driver.switchTo().defaultContent();
        Base.driver.switchTo().window(parent);
        helper.waitUntilElementIsVisible(HomepageVivahamLocators.Locatestore, Integer.parseInt(Base.prop.getProperty("ewait")));
        helper.scrollInWebPageTillVisible(HomepageVivahamLocators.Delhi);
        helper.hoverOnElement(HomepageVivahamLocators.Delhi);
        helper.clickElement(HomepageVivahamLocators.Delhi);
        Screenshot.takePageScreenShot("Vivaham");
        test.log(Status.INFO, "Navigated back to parent window and Clicked Delhi");
        LoggerHandler.info("Navigated back to parent window and Clicked Delhi");  
    }


    public void vivahamSection(ExtentTest test){
        Whatstrending();
        Vivaham();
        locateStore();
        selectState();
        selectCity();
        clickSearch();
    }
    
}