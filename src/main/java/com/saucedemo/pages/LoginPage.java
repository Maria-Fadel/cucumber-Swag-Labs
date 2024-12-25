package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.cssSelector("[data-test=username]");
    private final By passwordInput = By.cssSelector("[data-test=password]");
    private final By loginButton = By.cssSelector("[data-test=login-button]");

    public void login(String username, String password){
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }

}
