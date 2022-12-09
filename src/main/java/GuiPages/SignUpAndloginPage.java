package GuiPages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SignUpAndloginPage {
    SHAFT.GUI.WebDriver driver ;

    public static By NewUserSignupLocator(){
        return By.xpath("//h2[contains(.,'New User Signup!')]");
    }
    private final By Name = By.name("name");
    private final By SignupEmail = By.xpath("//*[@data-qa='signup-email']");
    private final By SignUpButton = By.xpath("//button[contains(.,'Signup')]");
    private final By SignInEmail = By.xpath("(//input[@type='email'])[1]");
    private final By password = By.name("password");
    private final By LoginButton = By.xpath("//button[contains(.,'Login')]");

    public static By ErrorMessageEmailExist(){
        return By.xpath("//p[contains(.,'Email Address already exist!')]");
    }
    public static By ErrorMessageLocator(){
        return By.xpath("//p[contains(.,'Your email or password is incorrect!')]");
    }
    public SignUpAndloginPage(SHAFT.GUI.WebDriver driver){
        this.driver =driver;
    }

    public SignUpAndloginPage AddNewUserSignup(String name , String signupEmail){
        driver.element().type(Name,name);
        driver.element().type(SignupEmail,signupEmail);
        return this;
    }
    public SignUpPage ClickOnSignUpButton(){
        driver.element().click(SignUpButton);
        return new SignUpPage(driver);
    }

    public SignUpAndloginPage LoginUsingValidNameAndPassword(String UserName , String Password){
        driver.element().type(SignInEmail,UserName);
        driver.element().type(password,Password);
        return this;
    }

    public SignInPage ClickOnLoginButton(){
        driver.element().click(LoginButton);
        return new SignInPage(driver);
    }



}
