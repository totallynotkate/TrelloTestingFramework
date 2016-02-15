package framework.pageobject.blocks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by totallynotkate on 13.02.16.
 */
public class MoreBoardMenuBlock extends BoardMenuBlock {
    private static final String XPATH_CLOSE_BOARD_MENU_ELEMENT = "//a[@class='board-menu-navigation-item-link js-close-board']";
    private static final String XPATH_CLOSE_BOARD_CONFIRMATION_BUTTON = "//input[@value='Close']";

    @FindBy (xpath = XPATH_CLOSE_BOARD_MENU_ELEMENT)
    WebElement closeBoardMenuElement;

    @FindBy (xpath = XPATH_CLOSE_BOARD_CONFIRMATION_BUTTON)
    WebElement closeBoardConfirmationButton;

    public MoreBoardMenuBlock(WebElement boardMenuBlock) {
        super(boardMenuBlock);
    }

    public void closeBoard(){
        closeBoardMenuElement.click();
        closeBoardConfirmationButton.click();
    }
}
