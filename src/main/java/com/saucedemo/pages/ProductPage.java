package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private final By title  = By.cssSelector("span.title[data-test='title']");

    public boolean titleIsDisplayed(){

        String actualText = driver.findElement(title).getText();
        String expectedText = "Products";

         return actualText.equals(expectedText);
    }


    public boolean checkCorrectPage(){

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        return currentURL.equals(expectedURL);

    }



}
