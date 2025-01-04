package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
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
    @Given("productPage: {string} in den Warenkorb legen")
    public void produktInDenWarenkorbLegen(String productName) throws InterruptedException {
        productPage.clickAddToCartButtonByProductName(productName);
    }
    @When("productPage: Products-Title ist sichtbar")
    public void ProductsTitleIstSichtbar(){
        Assert.assertTrue(productPage.titleIsDisplayed());
    }
    @When("productPage: check die products ist ungleich null")
    public void ProductPageCheckDieProductsIstUngleichNull(){
        Assert.assertFalse(productPage.checkProductsUngleichNull());
    }
    @When("productPage: check burger menu enthält {int}")
    public void ProductPageCheckBurgerMenuenthaeltItemsAnzahl(int itemsAnzahl){
        Assert.assertTrue(productPage.checkBurgerMenuEnthaeltItemsAnzahl(itemsAnzahl));
    }
    @When("productPage: check die products ist gleich {int}")
    public void ProductPageCheckDieProductsIstGlecihAnzahl(int anzahl){
        Assert.assertTrue(productPage.checkProductsIstgleichAnzahl(anzahl));

    }

    @And("productPage: Warenkorb klicken")
    public void warenkorbKlicken(){
        productPage.warenkorbKlicken();
    }

}
