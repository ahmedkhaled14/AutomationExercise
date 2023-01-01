package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.python.modules._sre;

public class ProductsPage {

    public static By ALlProductsLocator(){
        return By.xpath("//h2[contains(.,'All Products')]");
    }
    private By search_product_Locator(){return By.id("search_product");}
    private By submit_search(){return By.id("submit_search");}
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

    public ProductsPage Enter_product_name_in_search_input(String ProductName){
        driver.element().type(search_product_Locator(),ProductName);
        return this;
    }

    public SearchedProductsPage Click_On_Search_Button(){
        driver.element().click(submit_search());
        return new SearchedProductsPage(driver);
    }

}
