package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignInPage {
    SHAFT.GUI.WebDriver driver ;
    public static By VisibleUserNameLocator(){
        return By.xpath("//b[contains(.,'Ahmed')]");
    }
    public SignInPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }
}
