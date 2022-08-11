package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @BeforeMethod
    public void preConditions(){
        if(app.getUser().isLogged()){
            app.getUser().logOut();
        }
    }


    @Test
    public  void loginPositive() throws InterruptedException {
        User user = User.builder().email("juliakliot.jk@gmail.com").password("misha240613").build();
        logger.info("Test Login Positive 1"+ user.getEmail()+ " "+ user.getPassword());

        app.getUser().initLogin();
        app.getUser().pause(2000);
        app.getUser().fillInLoginForm(user);
        app.getUser().submitLogin();
        logger.info(" Logged---");

        Assert.assertTrue(app.getUser().isLogged());
    }


}
