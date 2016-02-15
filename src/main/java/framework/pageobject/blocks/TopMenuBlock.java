package framework.pageobject.blocks;

import framework.pageobject.PageObject;
import framework.pageobject.pages.HomePage;
import framework.pageobject.pages.LoggedOutPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Upper menu block object
 * Created by totallynotkate on 09.02.16.
 */
public class TopMenuBlock extends PageObject{
    private static final String XPATH_PROFILE_MENU = "//span[.='totallynotkate']/.."; // TODO: 10.02.16 ask if I should generate Xpath dynamically using the username provided in config.properties
    private static final String XPATH_LOGOUT_MENU_OPTION = "//a[@class='js-logout']";
    private static final String XPATH_TRELLO_LOGO = "//span[@class='header-logo-default']";

    @FindBy (xpath = XPATH_PROFILE_MENU)
    private WebElement profileMenu;

    @FindBy (xpath = XPATH_LOGOUT_MENU_OPTION)
    private WebElement logoutMenuOption;

    @FindBy (xpath = XPATH_TRELLO_LOGO)
    private WebElement trelloLogo;

    private WebElement topMenuBlock;

    public TopMenuBlock(WebElement upperMenu){
        this.topMenuBlock = upperMenu;
    }

    public LoggedOutPage logout(){
        profileMenu.click();
        logoutMenuOption.click();
        return new LoggedOutPage();
    }

    public HomePage goToHomePage(){
        trelloLogo.click();
        return new HomePage();
    }

    // TODO: 10.02.16 get profile dialogue method, public ProfileDialogue getProfileDialogue()
}
