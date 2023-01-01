package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductDetailPage {

    SHAFT.GUI.WebDriver driver;

    public static By product_details_Locator() {
        return By.xpath("//div[@class='product-details']");
    }

    public ProductDetailPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
