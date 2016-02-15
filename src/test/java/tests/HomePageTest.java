package tests;

import framework.pageobject.pages.BoardPage;
import framework.pageobject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by totallynotkate on 13.02.16.
 */
public class HomePageTest extends BaseTest {

    public static final String BOARD_NAME = "CreateNewBoardTest";

    @Test
    public void canCreateNewBoard(){
        HomePage homePage = new HomePage();
        BoardPage newBoard = homePage.createNewPrivateBoard(BOARD_NAME);
        Assert.assertEquals(BOARD_NAME, newBoard.getBoardName());
        newBoard.closeBoard();
    }
}
