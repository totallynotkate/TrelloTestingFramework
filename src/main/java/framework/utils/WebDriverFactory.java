package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String CHROME_DRIVER_PATH = "src/main/resources/chrome/chromedriver.exe";
    private ThreadLocal<WebDriver> driverThreadLocal;
    private final static WebDriverFactory INSTANCE = new WebDriverFactory();

    private WebDriverFactory(){}

    public static WebDriverFactory getInstance(){
        return INSTANCE;
    }

    public WebDriver createDriver(String browserName){
        driverThreadLocal = new ThreadLocal<>();
        if (FIREFOX.equalsIgnoreCase(browserName)){
            driverThreadLocal.set(new FirefoxDriver());
        } else if (CHROME.equalsIgnoreCase(browserName)){
            setChromeDriverPath();
            driverThreadLocal.set(new ChromeDriver());
        } else {
            throw new IllegalArgumentException(String.format("Browser %1$s is not supported", browserName));
        }
        return driverThreadLocal.get();
    }

    public WebDriver getDriver(){
        return driverThreadLocal.get();
    }

    private void setChromeDriverPath(){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
    }
}
