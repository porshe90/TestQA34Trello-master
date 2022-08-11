package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserModification extends TestBase {

    @Test
    public void testNewTab() {
        app.getUser().openTabAndSwitch();
        app.getUser().pause(1000);
    }

    @Test
    public void changeAvatar() {
        app.getUser().clickOnAvatar();
        app.getUser().openUserProfile();
        app.getUser().goToAtlassianAccount();
        app.getUser().pause(3000);

        Assert.assertTrue(app.getUrl().contains("https://id.atlassian.com/manage-profile"));

        app.getAtlassian().initChangePhoto();
        app.getAtlassian().uploadPhoto("C:/Users/julia/Documents/QA/QA_Automation/QA/TestQA34Trello/src/test/resources/15-shi-tcu.jpg");
        app.getUser().returnToTrello();
        Assert.assertTrue(app.getUrl().contains("https://trello.com/"));

    }

}
