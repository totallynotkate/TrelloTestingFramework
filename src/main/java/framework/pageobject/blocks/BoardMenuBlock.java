package framework.pageobject.blocks;

import framework.pageobject.PageObject;
import org.openqa.selenium.WebElement;

/**
 * Created by totallynotkate on 13.02.16.
 */
public abstract class BoardMenuBlock extends PageObject {
    private WebElement boardMenuBlock;

    public BoardMenuBlock(WebElement boardMenuBlock){
        this.boardMenuBlock = boardMenuBlock;
    }
}
