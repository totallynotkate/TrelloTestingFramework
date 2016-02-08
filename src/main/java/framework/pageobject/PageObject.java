package framework.pageobject;

import framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public PageObject(){
        this.driver = WebDriverFactory.getInstance().getDriver();
        this.wait = new WebDriverWait(driver, 10, 500);
    }
}
