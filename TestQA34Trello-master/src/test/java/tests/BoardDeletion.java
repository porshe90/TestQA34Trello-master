package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardDeletion extends TestBase {

    @Test (groups = {"logs"},invocationCount = 1)
    public void boardDeletion1() {
        int boardCountBeforeDeletion = app.getBoard().getBoardCount();

        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().openSideBoardMenu();
        app.getBoard().openMore();
        app.getBoard().deleteBoard();
        logger.info("The board is deleted---");

        int boardCountAfterDeletion = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterDeletion, boardCountBeforeDeletion - 1);

    }

    @Test
    public void refuseBoardDeletion() {

        app.getBoard().clickOnTheFirstBoard();
        app.getBoard().openSideBoardMenu();
        app.getBoard().openMore();
        app.getBoard().closeBoard2();
        app.getBoard().openBoard();
        app.getBoard().openBoardaAgain();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is reopened---");

        Assert.assertTrue(app.getBoard().isCreated());

    }

}
