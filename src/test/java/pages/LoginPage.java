package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Locators
    By userName = By.id("user-name");
    By password = By.id("password");
    By loginButton = By.id("login-button");

    // Actions
    public void enterUserName(String name){
        driver.findElement(userName).sendKeys(name);
    }

    public void enterPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }

    public String getPageUrl(){
        return driver.getCurrentUrl();
    }

    public boolean isLoginButtonDisplayed() {
        try {
            return driver.findElement(By.id("login-button")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
