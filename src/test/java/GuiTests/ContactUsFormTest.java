package GuiTests;

import GuiPages.ContactUsPage2;
import GuiPages.RegisterUserPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ContactUsFormTest {
    SHAFT.GUI.WebDriver driver;
    private final SHAFT.TestData.JSON ContactUsTestData = new SHAFT.TestData.JSON(System.getProperty("ContactUsTestData"));

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
    }


    @Test(description = "Contact Us Form Verify success message 'Success' details have been submitted successfully. ")
    public void ContactUsForm(){
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
