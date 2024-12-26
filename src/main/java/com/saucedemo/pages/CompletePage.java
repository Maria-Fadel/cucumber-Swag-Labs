package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompletePage extends BasePage {

    public CompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout_complete_container")
    private WebElement message;

    @FindBy(xpath = "//button[@data-test='back-to-products']")
    private WebElement backHome;


    public boolean istThankYouMessageVorhanden() {
        String expectedText = "Thank you for your order!";
        return message.getText().contains(expectedText);
    }

    public void backHomeKlicken(){
        backHome.click();
    }



}
