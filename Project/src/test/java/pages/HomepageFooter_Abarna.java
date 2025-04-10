package pages;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import uistore.HomepageFooterLocators_Abarna;
import utils.Base;
import utils.LoggerHandler;
import utils.WebDriverHelper;

public class HomepageFooter_Abarna {

    public ExtentTest test;
    WebDriverHelper helper;  

    public HomepageFooter_Abarna(ExtentTest test){    
        this.test=test;
        helper = new WebDriverHelper(Base.driver,test);
    }
    
     

    public void AboutUs(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.Aboutus);
            Base.driver.navigate().back();  
            test.log(Status.INFO, "Clicked Aboutus and navigated");   
            LoggerHandler.info("Clicked Aboutus and navigated");   
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void WhyReliance(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.WhyReliance);
            Base.driver.navigate().back(); 
            test.log(Status.INFO, "Clicked WhyReliance and navigated"); 
            LoggerHandler.info("Clicked WhyReliance and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Certifications(){
        try {  
            helper.clickElement(HomepageFooterLocators_Abarna.Certification);
            Base.driver.navigate().back();
            test.log(Status.INFO, "Clicked Certifications and navigated"); 
            LoggerHandler.info("Clicked Certifications and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void OurShowrooms(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.OurShowroom);
            Base.driver.navigate().back();  
            test.log(Status.INFO, "Clicked OurShowroom and navigated");         
            LoggerHandler.info("Clicked OurShowroom and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Media(){
        try {   
            helper.clickElement(HomepageFooterLocators_Abarna.Media);
            Base.driver.navigate().back();
            test.log(Status.INFO, "Clicked Media and navigated"); 
            LoggerHandler.info("Clicked Media and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Blog(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.Blog);
            Base.driver.navigate().back();   
            test.log(Status.INFO, "Clicked Blog and navigated");         
            LoggerHandler.info("Clicked Blog and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void FAQs(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.FAQs);
            Base.driver.navigate().back();   
            test.log(Status.INFO, "Clicked FAQs and navigated");       
            LoggerHandler.info("Clicked FAQs and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void TrackOrder(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.Trackorder);
            Base.driver.navigate().back();  
            test.log(Status.INFO, "Clicked Aboutus and navigated");          
            LoggerHandler.info("Clicked Aboutus and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void Contactus(){
        try {
            helper.clickElement(HomepageFooterLocators_Abarna.Contactus);
            Base.driver.navigate().back();     
            test.log(Status.INFO, "Clicked Contact us and navigated");        
            LoggerHandler.info("Clicked Contact us and navigated");          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void BrandStoryCustomerDelight(ExtentTest test){
        AboutUs();
        WhyReliance();
        Certifications();
        OurShowrooms();
        Media();
        Blog();
        FAQs();
        TrackOrder();
        Contactus();
             
      }
 
}


