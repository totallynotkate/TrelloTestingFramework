package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Factory class that initiates WebDriver objects with various parameters.
 *
 * Created by totallynotkate on 07.02.16.
 */
public class WebDriverFactory {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String CHROME_DRIVER_PATH = "src/main/resources/chrome/chromedriver.exe";
    private ThreadLocal<WebDriver> driverThreadLocal;
    private final static WebDriverFactory INSTANCE = new WebDriverFactory();

    private WebDriverFactory(){}

    /**
     *
     * @return an instance of WebDriverFactory. Since this class uses Singleton pattern the instance is always the same
     */
    public static WebDriverFactory getInstance(){
        return INSTANCE;
    }

    /**
     * Create a new WebDriver object in a thread-safe manner
     * @param browserName Browser name represented as a string, e.g. "Firefox". Version numbers are not supported
     * @return new WebDriver object
     */
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
