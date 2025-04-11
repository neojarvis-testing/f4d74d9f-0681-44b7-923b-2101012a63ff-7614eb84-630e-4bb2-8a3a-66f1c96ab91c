package uistore;

import org.openqa.selenium.By;

public class DiamondLocators {
    public static By logo = By.cssSelector("img[src='//image.reliancejewels.com/Jewels/cms_hydrant/widgets/HS18Logo/HorizontalBannerImage_1593441799728.png']");
    public static By EarringHover = By.cssSelector("a[href='https://www.reliancejewels.com/category:131/'][class='dropdown-toggle']");
    public static By DiamondClick = By.cssSelector("a[href='https://www.reliancejewels.com/category:133/']");
    // public static By DiamondVerify = By.xpath("//span[@id='breadcrumbNavigationLast']");
    public static By DiamondVerify = By.xpath("//span[@class='highlight_breadcrumb']");
    public static By Gender = By.xpath("(//div[@id='filter_tree'])[3]");
    // public static By women = By.xpath("//a[contains(@href, 'filter_Gender:%28%22Women%22%29')]");
    // public static By women = By.cssSelector("a[href='/diamond/category:133/filter_Gender:%28%22Women%22%29/']");
    public static By women = By.xpath("(//a[contains(text(),'Women')])[8]");
    // public static By women = By.cssSelector("li[id='filter_0Option_2']");
    // public static By women = By.xpath("//a[@href='/diamond/category:133/filter_Gender:%28%22Women%22%29/']");
    public static By popularity = By.cssSelector("button[id='shortbyfilter']");
    public static By newArrivals = By.id("sortOptionsLink_7");
    public static By keywordEarring = By.id("productTitleInPDP");
    public static By firstproductclick = By.xpath("//a[contains(text(),'14 Karat Gold & Diamond Earrings')]");
    public static By addtocart = By.xpath("(//a[@id ='btnBuyNow'])[1]");
}



