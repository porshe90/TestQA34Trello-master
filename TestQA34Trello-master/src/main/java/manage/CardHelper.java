package manage;

import models.Card;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardHelper extends HelperBase{
    public CardHelper(WebDriver wd) {
        super(wd);
    }

    public void initCardCreation() {
        click(By.cssSelector(".js-add-a-card"));
    }

    public void fillCreationForm(Card card) {
        type(By.cssSelector(".js-card-title"),card.getCardName());
        if(card.getColor()!=null){
            openCardMenu();
            selectLable();
            click(By.cssSelector("[data-color="+card.getColor()+"]"));
        }
    }

    public void selectLable() {
        click(By.cssSelector(".js-label-selector"));
    }

    public void openCardMenu() {
        click(By.cssSelector(".js-cc-menu"));

    }

    public void submitCardCreation() {
        click(By.cssSelector(".js-add-card"));
    }
}
