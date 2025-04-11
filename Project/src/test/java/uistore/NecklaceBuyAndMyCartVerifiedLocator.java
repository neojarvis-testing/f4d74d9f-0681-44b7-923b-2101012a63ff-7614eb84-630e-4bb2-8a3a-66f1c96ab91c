package uistore;

import org.openqa.selenium.By;

public class NecklaceBuyAndMyCartVerifiedLocator {
    public static By logo = By.cssSelector("img[title='Online Shopping in India']");
    public static By search = By.id("q");
    public static By hover = By.xpath("(//div[@class='quick_look_wrap'])[1]");
    public static By quickView = By.xpath("(//a[@class='quicklooklink'])[1]"); //"(//a[@class='quicklooklink'])[1]"

    public static By close = By.cssSelector("a[title='Close']");
    public static By firstProduct = By.xpath("(//a[@class='tooltip_18'])[1]");    

    public static By dropdown = By.id("item-size");
    public static By buyNow = By.xpath("(//a[@id='btnBuyNow'])[2]");

    public static By Cart = By.cssSelector("div[class='name']");
}
