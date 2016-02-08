package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class LoginPage extends PageObject {
    private static final String XPATH_LOGIN_FIELD = "//input[@id='user']";
    private static final String XPATH_PASSWORD_FIELD = "//input[@id='password']";

    public HomePage loginAs(String usernameOrEmail, String password){
        driver.findElement(By.xpath(XPATH_LOGIN_FIELD)).sendKeys(usernameOrEmail);
        driver.findElement(By.xpath(XPATH_PASSWORD_FIELD)).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        return new HomePage();
    }
}
