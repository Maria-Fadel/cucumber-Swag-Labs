package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductPage;
import com.saucedemo.utils.EnvUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class saucedemoSteps {
    WebDriver driver;
    LoginPage loginPage;
    ProductPage productPage;


    public saucedemoSteps() {
        driver = DriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
    }
    @Given("user ist in der Login-page")
    public void UserIstInDerLoginPage() throws IOException {
       loginPage.load(EnvUtils.getInstance().getURL());
    }
    @When("user gibt email und password")
    public void usergibtEmailUndPassword() throws Exception {
        loginPage.login(EnvUtils.getInstance().getUser(),EnvUtils.getInstance().getPassword());
    }
    @Then("user wird in inventory-Page weitergeleitet")
    public void userWirdInInventoryPageWeitergeleitet(){
        Assert.assertTrue(productPage.checkCorrectPage());
    }
    @When("Products-Title ist sichtbar")
    public void ProductsTitleIstSichtbar(){
        Assert.assertTrue(productPage.titleIsDisplayed());
    }
}
