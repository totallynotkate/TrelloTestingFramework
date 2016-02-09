package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class LoginPage extends PageObject {
    private static final String XPATH_LOGIN_FIELD = "//input[@id='user']";
    private static final String XPATH_PASSWORD_FIELD = "//input[@id='password']";
    public static final String XPATH_LOGIN_BUTTON = "//input[@id='login']";

    /**
     * Log in successfully with the credentials provided as method params. This method doesn't check if the credentials
     * are valid.
     * @param usernameOrEmail username or email are interchangeable, only one needs to be provided
     * @param password password that corresponds to this username or email
     * @return new HomePage object with the user usernameOrEmail logged in. If the credentials are invalid the behaviour
     * will be incorrect.
     */
    public HomePage loginAs(String usernameOrEmail, String password){
        driver.findElement(By.xpath(XPATH_LOGIN_FIELD)).sendKeys(usernameOrEmail);
        driver.findElement(By.xpath(XPATH_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath(XPATH_LOGIN_BUTTON)).click();
        return new HomePage();
    }
}
