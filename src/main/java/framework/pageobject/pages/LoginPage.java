package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class LoginPage extends PageObject {
    private static final String XPATH_LOGIN_FIELD = "//input[@id='user']";
    private static final String XPATH_PASSWORD_FIELD = "//input[@id='password']";
    private static final String XPATH_LOGIN_BUTTON = "//input[@id='login']";

    @FindBy (xpath = XPATH_LOGIN_FIELD)
    private WebElement loginField;

    @FindBy(xpath = XPATH_PASSWORD_FIELD)
    private WebElement passwordField;

    @FindBy (xpath = XPATH_LOGIN_BUTTON)
    private WebElement loginButton;

    /**
     * Log in successfully with the credentials provided as method params. This method doesn't check if the credentials
     * are valid.
     * @param usernameOrEmail username or email are interchangeable, only one needs to be provided
     * @param password password that corresponds to this username or email
     * @return new HomePage object with the user usernameOrEmail logged in. If the credentials are invalid the behaviour
     * is incorrect.
     */
    public HomePage loginAs(String usernameOrEmail, String password){
        loginField.sendKeys(usernameOrEmail);
        passwordField.sendKeys(password);
        loginButton.click();
        return new HomePage();
    }
}
