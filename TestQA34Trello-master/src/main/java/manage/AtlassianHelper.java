package manage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AtlassianHelper extends HelperBase{
    public AtlassianHelper(WebDriver wd) {
        super(wd);
    }

    public void initChangePhoto() {
        Actions actions = new Actions(wd);
        actions.moveToElement(wd.findElement(By.cssSelector("[data-test-selector='profile-avatar']"))).click().perform();
        pause(3000);
        click(By.xpath("//*[@role='menuitem'] [1]"));
    }

    public void uploadPhoto(String url) {
        wd.findElement(By.cssSelector("#image-input")).sendKeys(url);
        click(By.cssSelector(".css-12eh8h8"));

    }
}
