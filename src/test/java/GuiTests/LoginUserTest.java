package GuiTests;

import GuiPages.RegisterUserPage;
import GuiPages.SignInPage;
import GuiPages.SignUpAndloginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginUserTest {
    private SHAFT.GUI.WebDriver driver;

    private final SHAFT.TestData.JSON LoginUserTestData = new SHAFT.TestData.JSON(System.getProperty("SignInTestData"));

    @BeforeMethod
    public void beforeClass() {
        driver = new SHAFT.GUI.WebDriver();
    }

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


    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

}

