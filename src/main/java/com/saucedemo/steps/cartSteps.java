package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class cartSteps {
    WebDriver driver;
    CartPage cartPage;

    public cartSteps() {
        driver = DriverFactory.getDriver();
        cartPage = new CartPage(driver);
    }


    @Given("cartPage: Check {string} ist in Warenkorb vorhanden")
    public void checkProductIstInWarenkorbVorhanden(String productName) throws InterruptedException {
        Assert.assertTrue(cartPage.isItemInCart(productName));
    }

    @And("cartPage: Checkout klicken")
    public void checkoutKlicken(){
        cartPage.weiterZuCheckout();
    }

}
