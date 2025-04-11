package uistore;

import org.openqa.selenium.By;

public class ChainLocators {
    public static By logo = By.cssSelector("img[src='//image.reliancejewels.com/Jewels/cms_hydrant/widgets/HS18Logo/HorizontalBannerImage_1593441799728.png']");
    // public static By ChainHover = By.cssSelector("a[href='https://www.reliancejewels.com/category:146/'][data-toggle='dropdown']");
    public static By ChainHover = By.xpath("//a[@href='https://www.reliancejewels.com/category:146/']");
    public static By SilverClick = By.cssSelector("a[href='https://www.reliancejewels.com/category:151/']");
    public static By CategoriesVerify = By.xpath("(//div[@id='filter_tree'])[1]");
    public static By Gender = By.xpath("(//div[@id='filter_tree'])[3]");
    public static By women = By.cssSelector("a[href='/silver/category:151/filter_Gender:%28%22Women%22%29/']");
    public static By moreFilters = By.id("myBtn");
    public static By tryOnAvailable = By.id("myDIV_2");
    public static By yesButton = By.cssSelector("a[href='/silver/category:151/filter_Gender:%28%22Women%22%29/filter_Try_On_Available:%28%22Yes%22%29/']");

    public static By firstProductClick = By.cssSelector("a[href='/925-purity-silver-chain/all-jewellery/chain/product:508198/cid:151/?pos=1'][onmousedown='setPid(508198);'][class='tooltip_18']");

    //public static By buyNow = By.cssSelector("a[href='/cart/addItemToCart?itemId=1570767&quantity=1']");
    public static By buyNow = By.cssSelector("div[id='btnBuyNowC'][class='btnaddbuynow buynow2']");
    public static By productCodeVerify = By.xpath("//p[@class='product-code f-left bold']");
}
