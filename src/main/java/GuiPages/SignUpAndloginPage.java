package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpAndloginPage {
    SHAFT.GUI.WebDriver driver ;

    public static By NewUserSignupLocator(){
        return By.xpath("//h2[contains(.,'New User Signup!')]");
    }
    public SignUpAndloginPage(SHAFT.GUI.WebDriver driver){
        this.driver =driver;
    }


}
