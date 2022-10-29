package GuiTests;

import GuiPages.RegisterUserPage;
import GuiPages.SignUpAndloginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterUserTest {

    private SHAFT.GUI.WebDriver driver;

    @BeforeMethod
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Test(description = "Verify that home page is visible successfully")
    public void Verify_that_home_page_is_visible_successfully() {

        new RegisterUserPage(driver)
                .NavigateToUrl();
        driver.assertThat()
                .element(RegisterUserPage.SliderLocator())
                .isVisible()
                .withCustomReportMessage("Verify that home page is visible successfully")
                .perform();
    }

    @Test(description = "Verify New User Signup is visible")
    public void Verify_New_User_Signup_is_visible() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton();
        driver.assertThat()
                .element(SignUpAndloginPage.NewUserSignupLocator())
                .isVisible()
                .withCustomReportMessage("Verify that New User Signup is visible")
                .perform();
    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
