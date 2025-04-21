package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public HomePage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Locators
    By menuButton = By.id("react-burger-menu-btn");
    By logOutButton = By.id("logout_sidebar_link");
    By addToCartButton = By.id("add-to-cart-sauce-labs-backpack"); // أول منتج
    By cartBadge = By.className("shopping_cart_badge"); // عدد المنتجات في السلة


    // Actions
    public void clickMenu(){
//        driver.findElement(menuButton).click(); // to perform action without wait
        wait.until(ExpectedConditions.elementToBeClickable(menuButton)).click();
    }

    public void clickLogOut(){
//        driver.findElement(logOutButton).click(); // to perform action without wait
        wait.until(ExpectedConditions.elementToBeClickable(logOutButton)).click();
    }
    public void addFirstItemToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isCartBadgeDisplayed() {
        return driver.findElements(cartBadge).size() > 0;
    }

        public String getPageUrl () {
            return driver.getCurrentUrl();
        }

    }

