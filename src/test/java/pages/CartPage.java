package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage {


    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Locators
    By cartButton = By.className("shopping_cart_link");  // زر السلة
    By checkoutButton = By.id("checkout");  // زر الذهاب للشراء


    // Actions
    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartButton)).click();  // استنى لحد ما زر السلة يبقى قابل للضغط
    }

    public void proceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();  // استنى لحد ما زر الشراء يبقى جاهز
    }
}
