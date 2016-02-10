package framework.pageobject.pages;

import framework.pageobject.PageObject;
import framework.pageobject.blocks.TopMenuBlock;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/** Describes the basic elements present on any page when the user is logged in (e.g. the top navigational menu)
 * Created by totallynotkate on 10.02.16.
 */
public class BasePage extends PageObject{
    private static final String XPATH_TOP_MENU = "div[@id='header']";

    @FindBy (xpath = XPATH_TOP_MENU)
    private WebElement topMenuBLock;

    public TopMenuBlock getUpperMenu(){
        return new TopMenuBlock(topMenuBLock);
    }
}
