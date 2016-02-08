package framework.pageobject.pages;

import framework.pageobject.PageObject;
import org.openqa.selenium.By;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class HomePage extends PageObject {

    public BoardPage goToBoard(String boardName){
        driver.findElements(By.xpath(getXpath(boardName))).get(1).click();
        return new BoardPage();
    }

    private String getXpath(String boardName) {
        return "//span[contains(text(),'" + boardName + "')]/..";
    }
}
