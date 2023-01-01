package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SearchedProductsPage {
    SHAFT.GUI.WebDriver driver;

    public static By Searched_Products_LocatorVisible() {
        return By.xpath("//h2[contains(.,'Searched Products')]");
    }

    public static By ProductName_Locator() {
        return By.xpath("(//p[contains(.,'')])[3]");
    }

    public SearchedProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
