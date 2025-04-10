package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import uistore.FooterPoliciesLocator_Nakul;
import utils.Base;
import utils.ExcelReader;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class FooterPoliciesAction_Nakul {
    public ExtentTest test;

    public FooterPoliciesAction_Nakul(ExtentTest test) {
        this.test = test;
    }

    WebDriverHelper helper = new WebDriverHelper(Base.driver, test);

    public void policies(){
        LoggerHandler.info("Inside browser");
        test.log(Status.INFO, "Inside browser");
        
        List<WebElement> policies = helper.findElementsByXpath(FooterPoliciesLocator_Nakul.policies.toString().split(":")[1].trim());

        for (int i = 1; i <= policies.size(); i++) {
            helper.clickElement(By.xpath("("+FooterPoliciesLocator_Nakul.policies.toString().split(":")[1].trim()+")["+i+"]"));
            String urlActual = Base.driver.getCurrentUrl();
            String urlExpected = ExcelReader.readCellValue("Footer Policies Elements", ""+i+"", "URL");
            helper.verifyEquals(urlActual, urlExpected, urlExpected+" Verified");
            test.log(Status.PASS,urlExpected+" Verified");
            String titleActual = Base.driver.getTitle(); //helper.retrieveElementText(FooterPoliciesLocator.heading);
            String titleExpected = ExcelReader.readCellValue("Footer Policies Elements", ""+1+"", "Title");
            helper.verifyEquals(titleActual, titleExpected, titleExpected+" Verified");
            test.log(Status.PASS,titleExpected+" Verified");
            Base.driver.navigate().back();
        }
        LoggerHandler.info("Exit browser");
        test.log(Status.INFO, "Exit browser");
    }
}
