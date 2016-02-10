package tests;

import framework.pageobject.pages.BoardPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by totallynotkate on 07.02.16.
 */
public class BoardPageTest extends BaseTest {

    public static final String FIRST_LIST_NAME = "First list";
    public static final String SECOND_LIST_NAME = "Second list";
    public static final String TEST_CARD_NAME = "My card";
    private static final String TEST_BOARD_NAME = "Test";

    @Test
    public void canDragAndDropCardToAnotherList() {
        BoardPage boardPage = homePage.goToBoard(TEST_BOARD_NAME);
        try {
            boardPage.dragAndDropCard(TEST_CARD_NAME, SECOND_LIST_NAME);
            Assert.assertFalse(boardPage.getListOfCards(FIRST_LIST_NAME).contains(TEST_CARD_NAME));
            Assert.assertTrue(boardPage.getListOfCards(SECOND_LIST_NAME).contains(TEST_CARD_NAME));

            boardPage.dragAndDropCard(TEST_CARD_NAME, FIRST_LIST_NAME);
        } finally {
            boardPage.getUpperMenu().logout();
        }
    }
}
