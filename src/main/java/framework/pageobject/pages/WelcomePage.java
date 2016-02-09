package framework.pageobject.pages;

import framework.pageobject.PageObject;
import framework.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * The starting page of the application
 * Created by totallynotkate on 07.02.16.
 */
public class WelcomePage extends PageObject {
    private static final String XPATH_LOGIN_LINK = "//a[@href='/login']";
    public static final String XPATH_TRELLO_LOGO = "//img[@src='https://d2k1ftgv7pobq7.cloudfront.net/meta/p/res/" +
            "images/c13d1cd96a2cff30f0460a5e1860c5ea/header-logo-blue.svg']";

    /**
     * Open a WelcomePage using the URL from config.properties file
     */
    public void open(){
        driver.get(PropertyLoader.getInstance().getURL());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPATH_TRELLO_LOGO)));
    }

    /**
     * Click the login link to go to login page
     * @return LoginPage object
     */
    public LoginPage goToLoginPage(){
        driver.findElement(By.xpath(XPATH_LOGIN_LINK)).click();
        return new LoginPage();
    }
}
