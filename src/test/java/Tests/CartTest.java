package Tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;

public class CartTest extends BaseTest {

    private LoginPage login;
    private HomePage home;
    private CartPage cart;

    @Test(priority = 1)
    public void loginAndAddItemToCartTest() {
        driver.get("https://www.saucedemo.com/");
        login = new LoginPage(driver);

        login.enterUserName("standard_user");
        login.enterPassword("secret_sauce");
        login.clickLoginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory"), "Login Failed!");

        home = new HomePage(driver);
        home.addFirstItemToCart(); // دي هنضيفها في HomePage لو مش عندك

        Assert.assertTrue(home.isCartBadgeDisplayed(), "Item not added to cart!");
    }

    @Test(priority = 2, dependsOnMethods = "loginAndAddItemToCartTest")
    public void testCartAndCheckoutButton() {
        cart = new CartPage(driver);

        cart.openCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"), "Cart page did not open!");

        cart.proceedToCheckout();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"), "Did not navigate to checkout!");
    }
}