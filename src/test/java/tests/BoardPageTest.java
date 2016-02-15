package tests;

import framework.pageobject.pages.BoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class BoardPageTest extends BaseTest {

    private static final String TEST_BOARD_NAME = "Test";
    private static final String FIRST_LIST_NAME = "First list"; //// TODO: 10.02.16 replace with list number
    private static final String SECOND_LIST_NAME = "Second list";
    private static final String EXISTING_CARD_NAME = "My card";
    private static final String NEW_CARD_NAME = "New card";

    @Test
    public void canDragAndDropCardToAnotherList() {
        BoardPage boardPage = homePage.goToBoard(TEST_BOARD_NAME);
        try {
            boardPage.dragAndDropCard(EXISTING_CARD_NAME, SECOND_LIST_NAME);
            Assert.assertFalse(boardPage.getListOfCards(FIRST_LIST_NAME).contains(EXISTING_CARD_NAME));
            Assert.assertTrue(boardPage.getListOfCards(SECOND_LIST_NAME).contains(EXISTING_CARD_NAME));

            boardPage.dragAndDropCard(EXISTING_CARD_NAME, FIRST_LIST_NAME);
        } finally {
            boardPage.getUpperMenu().logout();
        }
    }

    @Test
    public void canCreateNewCard(){
        BoardPage boardPage = homePage.goToBoard(TEST_BOARD_NAME);
        boardPage.addNewCard(FIRST_LIST_NAME, NEW_CARD_NAME);

        Assert.assertTrue(boardPage.getListOfCards(FIRST_LIST_NAME).contains(NEW_CARD_NAME));
    }

    @Test
    public void canArchiveCard(){
        BoardPage boardPage = homePage.goToBoard(TEST_BOARD_NAME);
        boardPage.archiveCard(NEW_CARD_NAME);

        Assert.assertFalse(boardPage.getListOfCards(FIRST_LIST_NAME).contains(NEW_CARD_NAME));
    }
}
