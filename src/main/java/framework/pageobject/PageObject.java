package framework.pageobject;

import framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract class that represents a web page
 * Created by totallynotkate on 07.02.16.
 */
public abstract class PageObject {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    /**
     * The default constructor gets a WebDriver object and sets implicit wait time to 5 seconds and sleep between polls
     * duration to 500 milliseconds.
     */
    public PageObject(){
        this.driver = WebDriverFactory.getInstance().getDriver();
        this.wait = new WebDriverWait(driver, 5, 500);
    }
}
