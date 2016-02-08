package tests;

import framework.pageobject.pages.BoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class BoardPageTest extends BaseTest {

    private static final String TEST_BOARD_NAME = "Test";
    public static final String FIRST_LIST_NAME = "First list";
    public static final String SECOND_LIST_NAME = "Second list";
    public static final String TEST_CARD_NAME = "My card";

    @Test
    public void canDragAndDropCardToAnotherList(){
        BoardPage boardPage = homePage.goToBoard(TEST_BOARD_NAME);
        Assert.assertTrue(boardPage.getListOfCards(FIRST_LIST_NAME).contains(TEST_CARD_NAME)
                && ! boardPage.getListOfCards(SECOND_LIST_NAME).contains(TEST_CARD_NAME));
        boardPage.dragAndDropCard(TEST_CARD_NAME, SECOND_LIST_NAME);
        Assert.assertTrue(!boardPage.getListOfCards(FIRST_LIST_NAME).contains(TEST_CARD_NAME)
                && boardPage.getListOfCards(SECOND_LIST_NAME).contains(TEST_CARD_NAME));
        boardPage.dragAndDropCard(TEST_CARD_NAME, FIRST_LIST_NAME);
    }
}
