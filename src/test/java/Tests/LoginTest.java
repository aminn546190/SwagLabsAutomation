package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage login;
    private HomePage home;

    @Test(priority = 1)
    public void successfulLoginTest(){
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);

        login.enterUserName("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLoginButton();

        Assert.assertTrue(login.getPageUrl().contains("inventory"),"Login Failed!");
    }

    @Test(priority = 2, dependsOnMethods = "successfulLoginTest")
    public void logOutTest(){
        home = new HomePage(driver);

        home.clickMenu();
        home.clickLogOut();
        Assert.assertTrue(login.isLoginButtonDisplayed(), "User was not redirected to login page after logout.");
        Assert.assertTrue(home.getPageUrl().contains("www.saucedemo.com"),"LogOut Failed!");
    }

}
