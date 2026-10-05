package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    @Test(priority = 1)
    public void testValidLogin() {
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUsername("standard_user");
        lpg.enterPassword("secret_sauce");
        lpg.clickLoginButton();

        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(priority = 2)
    public void testInvalidLoginWithEmptyUsernameField() {
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUsername("");
        lpg.enterPassword("secret_sauce");
        lpg.clickLoginButton();

    }

    @Test(priority = 3)
    public void testInvalidLoginWithEmptyPasswordFiled(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUsername("standard_user");
        lpg.enterPassword("");
        lpg.clickLoginButton();

    }

    @Test(priority = 4)
    public void testBothInvalidLoginUserNameWithPasswordFiled(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUsername("dammar");
        lpg.enterPassword("dammar12");
        lpg.clickLoginButton();

    }

    @Test(priority = 5)
    public void testBothEmptyUserNameWithPasswordField(){
        LoginPage lpg = new LoginPage(driver);
        lpg.enterUsername("");
        lpg.enterPassword("");
        lpg.clickLoginButton();

    }
}