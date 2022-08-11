package tests;

import manage.MyDataProvider;
import models.Board;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreation extends TestBase {

    @Test(dataProvider = "boardData", dataProviderClass = MyDataProvider.class)
    public void boardCreation1(String boardName) {
        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillboardCreationForm(boardName);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();
        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test
    public void boardCreation1() {

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        Board board = Board.builder().title("testQa34").build();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillboardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }

    @Test (groups = {"logs"},invocationCount = 1)
    public void boardCreation2() {
        Board board = Board.builder().title("testQa34").build();
        logger.info("Test board creation 1" + board.getTitle());
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().fillboardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is created---");

        Assert.assertTrue(app.getBoard().isCreated());
    }

    @Test
    public void boardcreation3() {
        Board board = Board.builder().title("testQa34").build();
        logger.info("Test board creation 3" + board.getTitle());
        app.getBoard().statrBoardCreation();
        app.getBoard().fillboardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().isCreated();
        logger.info("Board is created---");

        Assert.assertTrue(app.getBoard().isCreated());

    }

    @Test
    public void boardCreationWithBackGround() {

        int boardCountBeforeCreation = app.getBoard().getBoardCount();
        Board board = Board.builder().title("testQa34").build();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().chooseBackground();
        app.getBoard().pause(2000);
        app.getBoard().fillboardCreationForm(board);
        app.getBoard().scrollDownTheForm();
        app.getBoard().pause(2000);
        app.getBoard().submitBoardCreation();
        app.getBoard().pause(2000);
        app.getBoard().returnToHomePage();

        int boardCountAfterCreation = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountAfterCreation, boardCountBeforeCreation + 1);
    }


    @Test
    public void refuseBoardCreation1() {
        int boardCountBefore = app.getBoard().getBoardCount();
        app.getBoard().statrBoardCreation();
        app.getBoard().closecreationWindow();
        int boardCountAfter = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountBefore, boardCountAfter);
    }


    @Test
    public void refuseboardCreation2() {
        int boardCountBefore = app.getBoard().getBoardCount();
        app.getBoard().createBoard();
        app.getBoard().closecreationWindow2();

        int boardCountAfter = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountBefore, boardCountAfter);

    }

    @Test
    public void refuseboardCreation3() {
        int boardCountBefore = app.getBoard().getBoardCount();
        app.getBoard().initBoardCreationFromHeader();
        app.getBoard().retutnToCreationPage();
        app.getBoard().closecreationWindow2();

        int boardCountAfter = app.getBoard().getBoardCount();
        Assert.assertEquals(boardCountBefore, boardCountAfter);


    }
}




