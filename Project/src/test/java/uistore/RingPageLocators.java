package uistore;

import org.openqa.selenium.By;

public class RingPageLocators {
    public static By Gender= By.cssSelector("div[class='head clearfix'][id='myDIV01']");
    public static By Mens=By.cssSelector("a[href='/rings/search:Rings/filter_Gender:%28%22Men%22%29/']");
    public static By Metal=By.xpath("//div[text()='Metal']");
    public static By Gold=By.cssSelector("a[href='/rings/search:Rings/filter_Gender:%28%22Men%22%29/filter_Metal:%28%22Gold%22%29/']");
    public static By firstProduct=By.xpath("(//a[@class='tooltip_18'])[1]");
    public static By AddtoCart=By.cssSelector("div[id='btnBuyNowC'][class='btnaddtocart']");    
}
