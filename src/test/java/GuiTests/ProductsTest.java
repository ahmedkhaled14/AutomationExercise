package GuiTests;

import GuiPages.ProductDetailPage;
import GuiPages.ProductsPage;
import GuiPages.RegisterUserPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductsTest {
    private SHAFT.GUI.WebDriver driver ;

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }


    @Test(description = "Verify user is navigated to ALL PRODUCTS page successfully")
    public void Verify_user_is_navigated_to_ALL_PRODUCTS_page_successfully(){

        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnProductsButton();

        driver.verifyThat()
                .element(ProductsPage.ALlProductsLocator())
                .isVisible()
                .withCustomReportMessage("The user is navigated to ALL PRODUCTS page successfully")
                .perform();

        driver.verifyThat()
                .element(ProductsPage.products_list_Locator())
                .isVisible()
                .withCustomReportMessage(" ALL products list is visible")
                .perform();

    }

    @Test(description = "Verify that Product detail is visible")
    public void Verify_that_Product_detail_Is_visible(){
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnProductsButton()
                .Click_on_ViewProduct_of_first_product();

        driver.verifyThat()
                .element(ProductDetailPage.product_details_Locator())
                .isVisible()
                .withCustomReportMessage("Verify that Product detail is visible: product name, category, price, availability, condition, brand")
                .perform();
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
