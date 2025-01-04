package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.cssSelector("[data-test=username]");
    private final By passwordInput = By.cssSelector("[data-test=password]");
    private final By loginButton = By.cssSelector("[data-test=login-button]");
    private final By errorMessage = By.cssSelector("[data-test=error]");
    private final By errorMessageLocator = By.cssSelector("h3[data-test='error']");

    public
    void login(String username, String password) throws Exception {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        boolean loginFailed = driver.findElements(errorMessage).size() > 0;
        if (loginFailed) {
            throw new Exception("Login fehlgeschlagen: Benutzername oder Passwort sind/ist falsch.");
        }
    }

    public void loginError(String username, String password) throws Exception {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public void checkErrorMessage(){
        String errorMessage = driver.findElement(errorMessageLocator).getText();

        String expectedText = "Epic sadface: Username and password do not match any user in this service";
       // String actualText = errorMessageElement.getText();
        assertTrue("Error message text is incorrect", errorMessage.contains(expectedText));

    }
}
