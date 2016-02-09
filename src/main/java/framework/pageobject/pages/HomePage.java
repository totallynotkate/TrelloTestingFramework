package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;

/**
 * Describes the page shown when the user logs in. It holds the list of the user boards.
 * Created by totallynotkate on 07.02.16.
 */
public class HomePage extends PageObject {

    /**
     * Switch to one of the boards. This method doesn't perform input check.
     * It uses driver.findElements(...).get(1) to get to the clickable element, else the driver finds the invisible
     * wrapper element
     * @param boardName The name of the board, case-sensitive
     * @return BoardPage object that represents the board named boardName. If there is no boardName board the returned
     * object will behave incorrectly.
     */
    public BoardPage goToBoard(String boardName){
        driver.findElements(By.xpath(String.format("//span[contains(text(),'%1$s')]/..", boardName))).get(1).click();
        return new BoardPage();
    }
}
