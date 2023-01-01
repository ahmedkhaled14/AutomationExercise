package GuiTests;

import GuiPages.ContactUsPage2;
import GuiPages.RegisterUserPage;
import com.shaft.driver.SHAFT;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Automation Exercise")
@Feature("GUI")
public class ContactUsFormTest {
    SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON ContactUsTestData = new SHAFT.TestData.JSON(System.getProperty("ContactUsTestData"));

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }


    @Description("Given the browser is open, When i navigate to Automation Exercise URl, And Click On Contact Us Button, And Enter,name,email,subject,and,message," +
            "And Click On Submit, Then navigate to ContactUsPage ")
    @Severity(SeverityLevel.CRITICAL)
    @Story("ContactUsForm")
    @Test(description = "Contact Us Form Verify success message 'Success' details have been submitted successfully. ")
    public void ContactUsForm() {
        new RegisterUserPage(driver)
                .NavigateToUrl()
                .ClickOnContactUsButton()
                .Enter_name_email_subject_and_message(
                        ContactUsTestData.getTestData("Name"),
                        ContactUsTestData.getTestData("Email"),
                        ContactUsTestData.getTestData("Subject"),
                        ContactUsTestData.getTestData("Message"),
                        ContactUsTestData.getTestData("filePath"))
                .ClickOnSubmit();


        driver.assertThat()
                .element(ContactUsPage2.status_alert_success_Locator())
                .text()
                .contains("Success! Your details have been submitted successfully.")
                .withCustomReportMessage(" Verify success message 'Success! Your details have been submitted successfully.'is visible' ")
                .perform();
    }


    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
