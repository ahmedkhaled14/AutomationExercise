package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPage2 {

    SHAFT.GUI.WebDriver driver;

    public static By status_alert_success_Locator() {
        return By.xpath("//*[@class='status alert alert-success']");
    }

    public ContactUsPage2(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
