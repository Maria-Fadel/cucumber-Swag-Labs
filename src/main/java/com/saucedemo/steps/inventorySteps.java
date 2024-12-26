package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class inventorySteps {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;


    public inventorySteps() {
        driver = DriverFactory.getDriver();
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }
    @Given("{string} in den Warenkorb legen")
    public void produktInDenWarenkorbLegen(String productName) throws InterruptedException {
        productPage.clickAddToCartButtonByProductName(productName);
    }

    @And("Warenkorb klicken")
    public void warenkorbKlicken(){
        productPage.warenkorbKlicken();
    }

}
