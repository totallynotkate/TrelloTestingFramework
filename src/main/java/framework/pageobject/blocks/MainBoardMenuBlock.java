package framework.pageobject.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by totallynotkate on 13.02.16.
 */
public class MainBoardMenuBlock extends BoardMenuBlock {
    private static final String XPATH_MORE_MENU_ELEMENT = "//a[@class='board-menu-navigation-item-link js-open-more']";

    @FindBy (xpath = XPATH_MORE_MENU_ELEMENT)
    WebElement moreMenuElement;

    public MainBoardMenuBlock(WebElement boardMenuBlock) {
        super(boardMenuBlock);
    }

    public MoreBoardMenuBlock getMoreBoardMenu(){
        moreMenuElement.click();
        return new MoreBoardMenuBlock(moreMenuElement);
    }
}
