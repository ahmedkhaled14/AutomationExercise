package GuiTests;

import GuiPages.RegisterUserPage;
import GuiPages.SearchedProductsPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchProductTest {
    SHAFT.GUI.WebDriver driver ;
    SHAFT.TestData.JSON ProductName = new SHAFT.TestData.JSON(System.getProperty("ProductNameTestData"));
    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Verify 'SEARCHED PRODUCTS' is visible")
    public void Verify_Searched_Products_is_visible(){
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnProductsButton()
                .Enter_product_name_in_search_input(ProductName.getTestData("ProductName"))
                .Click_On_Search_Button();

        driver.verifyThat()
                .element(SearchedProductsPage.Searched_Products_LocatorVisible())
                .isVisible()
                .withCustomReportMessage(" Verify 'SEARCHED PRODUCTS' is visible")
                .perform();

        driver.verifyThat()
                .element(SearchedProductsPage.ProductName_Locator())
                .text()
                .isEqualTo(ProductName.getTestData("ProductName"))
                .withCustomReportMessage("Verify all the products related to search are visible")
                .perform();


    }





















    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
