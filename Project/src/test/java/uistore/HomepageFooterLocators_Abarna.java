package uistore;

import org.openqa.selenium.By;

public class HomepageFooterLocators_Abarna {
    
    public static By Aboutus = By.cssSelector("a[href='https://m.reliancejewels.com/static/about_us2024.mobi']");
    // public static By Aboutus = By.xpath("//a[@href='https://m.reliancejewels.com/static/about_us2024.mobi']");
    public static By WhyReliance = By.cssSelector("a[href='https://m.reliancejewels.com/static/about_us2024.mobi']");
    // public static By Certification = By.cssSelector("a[href='https://www.reliancejewels.com/s/certification']");
    public static By Certification = By.xpath("(//a[@href='https://www.reliancejewels.com/s/certification'])[1]");
    // public static By OurShowroom = By.cssSelector("a[href='https://reliancejewels.com/storelocator']");
    public static By OurShowroom = By.xpath("//a[text()='Our Showrooms']");
    public static By Media = By.cssSelector("a[href='https://m.reliancejewels.com/static/MediasecM2023.mobi']");
    public static By Blog = By.cssSelector("a[href='https://reliancejewels.com/blog/']");
    public static By FAQs = By.cssSelector("a[href='https://www.reliancejewels.com/s/faq']");
    public static By Trackorder = By.cssSelector("a[href='https://www.reliancejewels.com/track-your-order.html']");
    public static By Contactus = By.xpath("(//a[text()='Contact Us'])[1]");

    // public static By FooterBrandStory = By.xpath("(//div[@class='width20percentage'])[1]/div[@class='module-body']/ul/li");
    // public static By FooterCustomerDelight = By.xpath("(//div[@class='width20percentage'])[2]/div[@class='module-body']/ul/li");

}