package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegisterUserPage {
    private SHAFT.GUI.WebDriver driver;
    private final String URL = System.getProperty("URL");

    public static By SliderLocator() {
        return By.xpath("(//*[@alt='demo website for practice'])[1]");
    }

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


}
