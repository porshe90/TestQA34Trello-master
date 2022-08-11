package manage;

import models.Board;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public void initBoardCreationFromHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
        click(By.cssSelector("[aria-label='BoardIcon']"));
    }
    public void  fillboardCreationForm(String boardName){
        type(By.cssSelector("[data-test-id = 'create-board-title-input']"), boardName);
    }

   public void fillboardCreationForm(Board board) {
        type(By.cssSelector("[data-test-id='create-board-title-input']"),board.getTitle());
    }

    public void scrollDownTheForm() {
        Actions action= new Actions(wd);
        WebElement container = wd.findElement(By.cssSelector("[data-test-id='header-create-menu-popover']"));
        Rectangle rect = container.getRect();
        int x = rect.getX()+20;
        int y = rect.getY()+rect.getHeight()/2;
        action.moveByOffset(x,y).click().perform();
    }

    public void submitBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-submit-button']"));
    }

    public void returnToHomePage() {
        click(By.cssSelector(".m2N684FcksCyfT"));
    }

    public int getBoardCount() {
        return wd.findElements(By.cssSelector(".boards-page-board-section-list-item")).size()-1-recentlyViewedBoards();
    }
    public int recentlyViewedBoards(){
        return  wd.findElements(By.xpath("//*[contains(@class,'icon-clock')]/../../..//li")).size();

    }

    public boolean isCreated() {
        return wd.findElements(By.cssSelector(".list-name-input")).size()>0;

    }

    public void clickOnTheFirstBoard() {
        click(By.cssSelector(".board-tile-details"));
    }

    public void openSideBoardMenu() {
        click(By.cssSelector(".js-show-sidebar"));

    }

    public void openMore() {
        click(By.cssSelector(".js-open-more"));
    }

    public void deleteBoard() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));
        click(By.cssSelector("[data-test-id= 'close-board-delete-board-button']"));
        click(By.cssSelector("[data-test-id= 'close-board-delete-board-confirm-button']"));
    }

    public void statrBoardCreation() {
        click(By.cssSelector("[data-test-id='create-board-tile']"));
    }

    public void closecreationWindow() {
        click(By.cssSelector("[data-test-id='popover-close']"));
    }

    public void createBoard() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void closecreationWindow2() {
        click(By.cssSelector("[data-test-id='popover-close']"));
    }

    public void retutnToCreationPage() {
        click(By.cssSelector("._0F1JkilrBuDsnA"));
    }


    public void chooseBackground() {
        click(By.cssSelector("[aria-label='CheckIcon']"));
    }

    public void openBoard() {
        click(By.cssSelector("[data-test-id='workspace-chooser-trigger-button']"));
    }

    public void openBoardaAgain() {
        click(By.cssSelector(".JIXQq8gDYY04N6"));
    }

    public void closeBoard2() {
        click(By.cssSelector(".js-close-board"));
        click(By.cssSelector(".js-confirm"));

    }
}
