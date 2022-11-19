package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignInPage {
    SHAFT.GUI.WebDriver driver ;
    public static By VisibleUserNameLocator(){
        return By.xpath("//b[contains(.,'Ahmed')]");
    }
    private final By LogOutButton = By.xpath("//a[contains(.,' Logout')]");
    public SignInPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    public RegisterUserPage ClickOnLogOutButton(){
        driver.element().click(LogOutButton);
        return new RegisterUserPage(driver);
    }
}
