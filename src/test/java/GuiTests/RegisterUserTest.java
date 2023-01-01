package GuiTests;

import GuiPages.AccountCreatedPage;
import GuiPages.RegisterUserPage;
import GuiPages.SignUpAndloginPage;
import GuiPages.SignUpPage;
import Utils.Util;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("GUI")
public class RegisterUserTest {

    private SHAFT.GUI.WebDriver driver;
    private SHAFT.TestData.JSON SignUptestData = new SHAFT.TestData.JSON(System.getProperty("SignUpTestData"));
    private SHAFT.TestData.JSON AccountDetailstestData = new SHAFT.TestData.JSON(System.getProperty("AccountDetailsTestData"));

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();

    }

    @Description("Given the browser is open, When i navigate to Automation Exercise URl,Then Home page is visible successfully ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
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

    @Description("Given the browser is open, When i navigate to Automation Exercise URl,And Click On Signup Button, Then Navigate to SignUp And login Page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
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

    @Description("Given the browser is open, When i navigate to Automation Exercise URl,And Click On Signup Button,And Add New User Signup,And Click On SignUp Button,Then Navigate to SignUp Page")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
    @Test(description = "Verify that 'ENTER ACCOUNT INFORMATION' is visible")
    public void Verify_that_Enter_Account_Information_is_visible() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton()
                .AddNewUserSignup
                        (
                                SignUptestData.getTestData("name") + Util.GenerateCurrentDateAndTime(),
                                SignUptestData.getTestData("SignUpEmail") + Util.GenerateCurrentDateAndTime()
                        )
                .ClickOnSignUpButton();

        driver.assertThat()
                .element(SignUpPage.EnterAccountInformationLocator())
                .isVisible()
                .withCustomReportMessage("Verify that 'ENTER ACCOUNT INFORMATION' is visible")
                .perform();
    }

    @Description("Given the browser is open, When i navigate to Automation Exercise URl,And Click On Signup Button,And Add New User Signup,And Click On SignUp Button,And Fill Account Details, And Click On Create Account Button,Then Navigate To Account Created Page  ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
    @Test(description = "Verify that 'ACCOUNT CREATED!' is visible")
    public void Verify_that_Account_Created_is_visible() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton()
                .AddNewUserSignup
                        (
                                SignUptestData.getTestData("name") + Util.GenerateCurrentDateAndTime(),
                                SignUptestData.getTestData("SignUpEmail") + Util.GenerateCurrentDateAndTime()
                        )
                .ClickOnSignUpButton()
                .FillAccountDetails
                        (
                                AccountDetailstestData.getTestData("Name"),
                                AccountDetailstestData.getTestData("Password"),
                                Integer.parseInt(AccountDetailstestData.getTestData("Day")),
                                AccountDetailstestData.getTestData("Month"),
                                Integer.parseInt(AccountDetailstestData.getTestData("Year")),
                                AccountDetailstestData.getTestData("FirstName"),
                                AccountDetailstestData.getTestData("LastName"),
                                AccountDetailstestData.getTestData("Company"),
                                AccountDetailstestData.getTestData("Address1"),
                                AccountDetailstestData.getTestData("Address2"),
                                AccountDetailstestData.getTestData("Country"),
                                AccountDetailstestData.getTestData("State"),
                                AccountDetailstestData.getTestData("City"),
                                Integer.parseInt(AccountDetailstestData.getTestData("Zipcode")),
                                Integer.parseInt(AccountDetailstestData.getTestData("MobileNumber"))
                        )
                .ClickOnCreateAccountButton();


        driver.assertThat()
                .element(AccountCreatedPage.AccountCreatedLocator())
                .isVisible()
                .withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible")
                .perform();

    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}
