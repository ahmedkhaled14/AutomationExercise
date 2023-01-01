package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpPage {
    SHAFT.GUI.WebDriver driver;

    public static By EnterAccountInformationLocator() {
        return By.xpath("//b[contains(.,'Enter Account Information')]");
    }

    private final By Title = By.id("id_gender1");
    private final By name = By.id("name");
    private final By password = By.id("password");
    private final By SelectDay = By.id("days");
    private final By SelectMonth = By.id("months");
    private final By SelectYear = By.id("years");
    private final By firstName = By.id("first_name");
    private final By lastName = By.id("last_name");
    private final By company = By.id("company");
    private final By address1 = By.id("address1");
    private final By address2 = By.id("address2");
    private final By SelectCountry = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobileNumber = By.id("mobile_number");
    private final By CreateAccountButton = By.xpath("//button[contains(.,'Create Account')]");

    public SignUpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    /**
     * @param Name         String Value From testDataFiles AccountDetailsTestData.json
     * @param Password     String Value From testDataFiles AccountDetailsTestData.json
     * @param Day          int Value From testDataFiles AccountDetailsTestData.json
     * @param Month        String Value From testDataFiles AccountDetailsTestData.json
     * @param Year         int Value From testDataFiles AccountDetailsTestData.json
     * @param FirstName    String Value From testDataFiles AccountDetailsTestData.json
     * @param LastName     String Value From testDataFiles AccountDetailsTestData.json
     * @param Company      String Value From testDataFiles AccountDetailsTestData.json
     * @param Address1     String Value From testDataFiles AccountDetailsTestData.json
     * @param Address2     String Value From testDataFiles AccountDetailsTestData.json
     * @param Country      String Value From testDataFiles AccountDetailsTestData.json
     * @param State        String Value From testDataFiles AccountDetailsTestData.json
     * @param City         String Value From testDataFiles AccountDetailsTestData.json
     * @param Zipcode      int Value From testDataFiles AccountDetailsTestData.json
     * @param MobileNumber int Value From testDataFiles AccountDetailsTestData.json
     * @return SignUpPage
     */
    public SignUpPage FillAccountDetails(String Name, String Password, int Day, String Month, int Year, String FirstName, String LastName,
                                         String Company, String Address1, String Address2, String Country, String State,
                                         String City, int Zipcode, int MobileNumber) {
        driver.element().click(Title);
        driver.element().type(name, Name);
        driver.element().type(password, Password);
        driver.element().select(SelectDay, String.valueOf(Day));
        driver.element().select(SelectMonth, Month);
        driver.element().select(SelectYear, String.valueOf(Year));
        driver.element().type(firstName, FirstName);
        driver.element().type(lastName, LastName);
        driver.element().type(company, Company);
        driver.element().type(address1, Address1);
        driver.element().type(address2, Address2);
        driver.element().select(SelectCountry, Country);
        driver.element().type(state, State);
        driver.element().type(city, City);
        driver.element().type(zipcode, String.valueOf(Zipcode));
        driver.element().type(mobileNumber, String.valueOf(MobileNumber));
        return this;

    }

    /**
     * @return Account Created Page
     */
    public AccountCreatedPage ClickOnCreateAccountButton() {
        driver.browser().setWindowSize(50, 400);
        driver.element().click(CreateAccountButton);
        driver.browser().maximizeWindow();
        return new AccountCreatedPage(driver);
    }


}
