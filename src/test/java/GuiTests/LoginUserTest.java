package GuiTests;

import GuiPages.RegisterUserPage;
import GuiPages.SignInPage;
import GuiPages.SignUpAndloginPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("GUI")
public class LoginUserTest {
    private SHAFT.GUI.WebDriver driver;

    public static SHAFT.TestData.JSON LoginUserTestData = new SHAFT.TestData.JSON(System.getProperty("SignInTestData"));

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }

    @Description("Given the browser is open, When i navigate to Automation Exercise URl, And Click On Signup Button, And Login Using Valid Name And Password," +
            "And Click On Click On Login Button, Then navigate to SignUp And login Page ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
    @Test(description = "Login User with correct email and password")
    public void Login_User_with_correct_email_and_password() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton()
                .LoginUsingValidNameAndPassword(LoginUserTestData.getTestData("EmailAddress"), LoginUserTestData.getTestData("Password"))
                .ClickOnLoginButton();

        driver.assertThat()
                .element(SignInPage.VisibleUserNameLocator())
                .text()
                .contains("Ahmed")
                .withCustomReportMessage("Verify that 'Logged in as username' is visible")
                .perform();
    }

    @Description("Given the browser is open, When i navigate to Automation Exercise URl, And Click On Signup Button, And Login Using InValid Name And Password," +
            "And Click On Click On Login Button, Then error message 'Your email or password is incorrect!' is visible ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
    @Test(description = "Login User with Incorrect email and password")
    public void Login_User_with_Incorrect_email_and_password() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton()
                .LoginUsingValidNameAndPassword(LoginUserTestData.getTestData("EmailAddress") + "invalidEmail", LoginUserTestData.getTestData("Password"))
                .ClickOnLoginButton();

        driver.assertThat()
                .element(SignUpAndloginPage.ErrorMessageLocator())
                .text()
                .contains("Your email or password is incorrect!")
                .withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible")
                .perform();
    }


    @Description("Given the browser is open, When i navigate to Automation Exercise URl, And Click On Signup Button, And Login Using Valid Name And Password," +
            "And Click On Click On Login Button, When navigate to SignUp And login Page And Click On LogOut Button Then User navigated to login page after Click on LogOut Button ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Register User")
    @Test(description = "Logout User")
    public void Logout_User() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton()
                .LoginUsingValidNameAndPassword(LoginUserTestData.getTestData("EmailAddress"), LoginUserTestData.getTestData("Password"))
                .ClickOnLoginButton()
                .ClickOnLogOutButton();

        driver.assertThat()
                .element(RegisterUserPage.LogintoyouraccountLocator())
                .isVisible()
                .withCustomReportMessage("Verify that user is navigated to login page after Click on LogOutButton ")
                .perform();

    }

    @Test(description = "Register User with existing email")
    public void Register_User_with_existing_email() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnSignupButton()
                .AddNewUserSignup(LoginUserTestData.getTestData("Password"), LoginUserTestData.getTestData("EmailAddress"))
                .ClickOnSignUpButton();

        driver.assertThat()
                .element(SignUpAndloginPage.ErrorMessageEmailExist())
                .text()
                .contains("Email Address already exist!")
                .withCustomReportMessage("Verify error 'Email Address already exist!' is visible")
                .perform();

    }


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}

