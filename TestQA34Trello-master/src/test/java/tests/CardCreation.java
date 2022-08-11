package tests;

import manage.MyDataProvider;
import models.Card;
import org.testng.annotations.Test;

public class CardCreation extends  TestBase{

    @Test(dataProvider = "dataCardCSV", dataProviderClass = MyDataProvider.class)
    public void cardCreation(){
        Card card = Card.builder().cardName("test1").color("green").build();
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("test11");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCardCreation();

    }
    @Test (groups = {"logs"},invocationCount = 1)
    public void cardCreation2(){
        Card card = Card.builder().cardName("test1").color("green").build();
        app.getBoard().clickOnTheFirstBoard();
        app.getList().createList("test11");
        app.getCard().initCardCreation();
        app.getCard().fillCreationForm(card);
        app.getCard().submitCardCreation();

    }
}
