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
        driver.findElements(By.xpath(getXpath(boardName))).get(1).click();// TODO: 08.02.16 rewrite with String.format()
        return new BoardPage();
    }

    /**
     * Generate the Xpath for the board specified as the method parameter. This method generates the Xpath for the board
     * name by adding board name to the span element that has board names and then adds /.. to return the span's parent.
     * This method doesn't check if the board name is valid.
     * @param boardName the board name as a string, case-sensitive
     * @return the Xpath to the boardName's span element parent
     */
    private String getXpath(String boardName) {
        return "//span[contains(text(),'" + boardName + "')]/..";
    }
}
