package tests;

import framework.pageobject.pages.HomePage;
import framework.pageobject.pages.LoginPage;
import framework.pageobject.pages.WelcomePage;
import framework.utils.PropertyLoader;
import framework.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

/**
 * Created by totallynotkate on 07.02.16.
 */
public abstract class BaseTest {
    HomePage homePage;


    @BeforeSuite
    public void beforeSuite() {
        WebDriver driver = WebDriverFactory.getInstance().createDriver("firefox");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void beforeMethod(){
        WelcomePage welcomePage = new WelcomePage();
        welcomePage.open();
        LoginPage loginPage = welcomePage.goToLoginPage();
        homePage = loginPage.loginAs(PropertyLoader.getInstance().getEmail(),
                PropertyLoader.getInstance().getPassword());
    }

    @AfterMethod
    public void afterMethod(){
        WebDriverFactory.getInstance().getDriver().manage().deleteAllCookies();
    }

    @AfterSuite
    public void afterSuite(){
        WebDriverFactory.getInstance().getDriver().quit();
    }

}
