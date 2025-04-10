package uistore;

import org.openqa.selenium.By;

public class RelianceJewelsLocators_Sahla {

        public static By hoverRings = By.xpath("//a[@href='https://www.reliancejewels.com/category:136/']");

        public static By clickCasualWear = By.cssSelector(
                        "a[href='https://www.reliancejewels.com/rings/category:136/filter_Occasion:%28%22Casual+Wear%22%29/']");

        public static By clickCategory = By.cssSelector("a div[id='filter_tree']");

        public static By clickPlatinum = By
                        .cssSelector("a[href='/platinum/category:140/filter_Occasion:%28%22Casual+Wear%22%29/']");

        public static By clickMorefilters = By.cssSelector("button[class='filtersbutton']");

        public static By clickTryOn = By.cssSelector("div[title='Platinum - Try On Available']");

        public static By clickYes = By.cssSelector(
                        "a[href='/platinum/category:140/filter_Occasion:%28%22Casual+Wear%22%29/filter_Try_On_Available:%28%22Yes%22%29/']");

        public static By clickFirstProduct = By
                        .cssSelector("img[src='//image.reliancejewels.com/Jewels/images/productImages/691/pt950-karat-gold-ring-medium_56db9edcb862da4c7bd422ac1607044c.jpg']");

        public static By clickBuyNow = By.xpath("(//a[@title='Buy PT950 Karat Gold Ring'])[2]");

        public static By relianceLogo = By.cssSelector("img[title='Online Shopping in India']");

        public static By verifyPlatinum = By.xpath(
                        "//h1[@style='float: left;color: #333;font-weight: 500;margin: 10px 0 10px 0px;padding: 0;line-height: 1em;width: 100%;text-align: center;font-size: 18px;;text-transform: uppercase;']");

        public static By verifyTryOn = By.xpath("(//div[@id='selected_fltrs']/span)[1]");

        public static By verifyProductCode = By.xpath("//p[@class='product-code f-left bold']");

}
