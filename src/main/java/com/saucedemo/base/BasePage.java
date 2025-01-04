package com.saucedemo.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void load(String url){
        driver.get(url);
    }
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton ;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton ;

    public void logoutClick(){
        burgerMenuButton.click();
        logoutButton.click();

    }

}
