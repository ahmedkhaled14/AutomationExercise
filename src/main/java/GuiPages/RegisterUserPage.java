package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegisterUserPage {
    private  SHAFT.GUI.WebDriver driver;
    private final String URL = "https://www.automationexercise.com/";

    public static By SliderLocator(){
      return  By.xpath("(//*[@alt='demo website for practice'])[1]");
    }
    private By SignUpButton(){
        return By.xpath("//a[contains(.,' Signup / Login')]");
    }

    public RegisterUserPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public RegisterUserPage NavigateToUrl() {
        driver.browser().navigateToURL(URL);
        return this;
    }
    public SignUpAndloginPage ClickOnSignupButton(){
        driver.element().click(SignUpButton());
        return new SignUpAndloginPage(driver);
    }
}
