package framework.pageobject.pages;

import framework.pageobject.blocks.MainBoardMenuBlock;
import framework.pageobject.blocks.MoreBoardMenuBlock;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class BoardPage extends BasePage {

    private static final String XPATH_LIST_OF_CARDS = "//h2[.='%1$s']/../../descendant::a[@class='list-card-title js-card-name']";
    private static final String XPATH_ADD_CARD_BUTTON = "//h2[.='%1$s']/../../a[contains(text(),'Add a card')]";
    private static final String XPATH_ADD_A_CARD_LINK = XPATH_ADD_CARD_BUTTON;
    private static final String XPATH_OPENED_CARD_TEXTAREA = "//h2[.='%1$s']/../../div[2]/div[@class='card-composer']//textarea";
    private static final String XPATH_ADD_CARD_CONFIRMATION_BUTTON = "//input[@value='Add']";
    private static final String XPATH_CANCEL_ADD_CARD_BUTTON = "//a[@class='icon-lg icon-close dark-hover js-cancel']";
    private static final String XPATH_CARD_AREA = "//a[contains(text(),'%1$s')]/..";
    private static final String XPATH_LIST_AREA = "//h2[.='%1$s']/../..";
    private static final String XPATH_ARCHIVE_CARD_OPTION = "//span[.='Archive']/..";
    private static final String XPATH_CARD_EDIT_DIALOGUE = "//a[contains(text(),'%1$s')]/../../span";
    private static final String XPATH_BOARD_MENU = "//div[@class='board-menu-container']";
    private static final String XPATH_BOARD_NAME = "//span[@class='board-header-btn-text']";

    @FindBy (xpath = XPATH_BOARD_MENU)
    WebElement boardMenu;

    @FindBy (xpath = XPATH_BOARD_NAME)
    WebElement boardName;

    /**
     * Get the names of the cards present in the list as a List of Strings
     * @param listName the name of the list
     * @return list of card names as Strings, empty if there are no cards present
     */
    public List<String> getListOfCards(String listName) {
        List<WebElement> listOfCards = driver.findElements(By.xpath(String.format(XPATH_LIST_OF_CARDS, listName)));
        return listOfCards.stream()
                .map(WebElement::<String>getText)
                .collect(Collectors.toList());
    }

    /**
     * Move a card from one list to another. This method finds the card in any list on the page. This method doesn't
     * check if the card and the target list are present.
     * @param cardName The name of a card as a string, case-sensitive
     * @param targetList The name of the list where the card should be dropped, case-sensitive
     */
    public void dragAndDropCard(String cardName, String targetList) {
        (new Actions(driver)).dragAndDrop(driver.findElement(By.xpath(String.format(XPATH_CARD_AREA,cardName))),
                driver.findElement(By.xpath(String.format(XPATH_LIST_AREA,targetList)))).perform();
    }

    public void addNewCard(String listName, String cardName){
        driver.findElement(By.xpath(String.format(XPATH_ADD_A_CARD_LINK, listName))).click();
        driver.findElement(By.xpath(String.format(XPATH_OPENED_CARD_TEXTAREA,listName))).sendKeys(cardName);
        driver.findElement(By.xpath(XPATH_ADD_CARD_CONFIRMATION_BUTTON)).click();
        driver.findElement(By.xpath(XPATH_CANCEL_ADD_CARD_BUTTON)).click();
    }

    public void archiveCard(String cardName){
        (new Actions(driver)).moveToElement(driver.findElement(By.xpath(String.format(XPATH_CARD_AREA,cardName)))).build().perform();
        driver.findElement(By.xpath(String.format(XPATH_CARD_EDIT_DIALOGUE,cardName))).click();
        driver.findElement(By.xpath(XPATH_ARCHIVE_CARD_OPTION)).click();
    }

    public MainBoardMenuBlock getBoardMenu (){
        return new MainBoardMenuBlock(boardMenu);
    }

    public ClosedBoardPage closeBoard(){
//        MainBoardMenuBlock mainBoardMenu = getBoardMenu();
//        MoreBoardMenuBlock moreBoardMenu = mainBoardMenu.getMoreBoardMenu();
        MoreBoardMenuBlock test = this.getBoardMenu().getMoreBoardMenu();
        test.closeBoard();
        return new ClosedBoardPage();
    }

    public String getBoardName(){
        return boardName.getText();
    }
}

