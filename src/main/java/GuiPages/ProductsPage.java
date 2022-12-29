package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductsPage {

    public static By ALlProductsLocator(){
        return By.xpath("//h2[contains(.,'All Products')]");
    }
    public static By products_list_Locator(){
        return By.xpath("//div[@class='features_items']");
    }

    private By View_first_product() {
        return By.xpath("//a[@href='/product_details/1']");
    }

    SHAFT.GUI.WebDriver driver ;
    public ProductsPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    public ProductDetailPage Click_on_ViewProduct_of_first_product(){
        driver.element().click(View_first_product());
        return new ProductDetailPage(driver);
    }


}
