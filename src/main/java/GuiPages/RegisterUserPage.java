package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RegisterUserPage {
    private SHAFT.GUI.WebDriver driver;
    private final String URL = System.getProperty("URL");

    public static By SliderLocator() {
        return By.xpath("(//*[@alt='demo website for practice'])[1]");
    }

    private By susbscribe_email_locator(){return By.id("susbscribe_email");}

    private By arrow_button_locator(){return By.id("subscribe");}

    public static By success_subscribe_Message(){return By.id("success-subscribe");}

    private By SignUpButton() {
        return By.xpath("//a[contains(.,' Signup / Login')]");
    }

    private By ContactUsButton() {
        return By.xpath("//a[contains(.,' Contact us')]");
    }
    private By ProductsButton() {
        return By.xpath("//a[contains(.,' Products')]");
    }
    public static By LogintoyouraccountLocator() {
        return By.xpath("//h2[contains(.,'Login to your account')]");
    }

    public RegisterUserPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public RegisterUserPage NavigateToUrl() {
        driver.browser().navigateToURL(URL);
        return this;
    }
    public SignUpAndloginPage ClickOnSignupButton() {
        driver.element().click(SignUpButton());
        return new SignUpAndloginPage(driver);
    }

    public ContactUsPage ClickOnContactUsButton() {
        driver.element().click(ContactUsButton());
        return new ContactUsPage(driver);
    }

    public ProductsPage ClickOnProductsButton() {
        driver.element().click(ProductsButton());
        return new ProductsPage(driver);
    }

    public RegisterUserPage Enter_email_address_in_input(String EmailAddress){
        driver.element().type(susbscribe_email_locator(),EmailAddress).keyPress(susbscribe_email_locator(), Keys.ENTER);
        return this;
    }

    public RegisterUserPage click_on_arrow_button(){

        driver.element().scrollToElement(arrow_button_locator())
                .click(arrow_button_locator());

        return this;
    }


}
