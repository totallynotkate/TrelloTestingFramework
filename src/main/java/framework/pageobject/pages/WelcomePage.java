package framework.pageobject.pages;

import framework.pageobject.PageObject;
import framework.utils.PropertyLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class WelcomePage extends PageObject {
    private static final String XPATH_LOGIN_LINK = "//a[@href='/login']";

    public void open(){
        driver.get(PropertyLoader.getInstance().getURL());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='https://d2k1ftgv7pobq7.cloudfront.net/meta/p/res/images/c13d1cd96a2cff30f0460a5e1860c5ea/header-logo-blue.svg']")));
    }

    public LoginPage goToLoginPage(){
        driver.findElement(By.xpath(XPATH_LOGIN_LINK)).click();
        return new LoginPage();
    }
}
