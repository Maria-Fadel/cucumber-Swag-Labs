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
    @Given("loginPage: user ist in der Login-page")
    public void UserIstInDerLoginPage() throws IOException {
       loginPage.load(EnvUtils.getInstance().getURL());
    }
    @When("loginPage: user gibt email und password")
    public void usergibtEmailUndPassword() throws Exception {
        loginPage.login(EnvUtils.getInstance().getUser(),EnvUtils.getInstance().getPassword());
    }

    @When("loginPage: user gibt korrekten {string} und {string}")
    public void usergibtKorrektenEmailUndOderPassword(String email, String password) throws Exception {
        loginPage.login(email,password);
    }

    @When("loginPage: user gibt falschen {string} und oder {string}")
    public void usergibtFalschenEmailUndOderPassword(String email, String password) throws Exception {
        loginPage.loginError(email,password);
    }
    @Then("loginPage: user wird in inventory-Page weitergeleitet")
    public void userWirdInInventoryPageWeitergeleitet(){
        Assert.assertTrue(productPage.checkCorrectPage());
    }
    @When("loginPage: Products-Title ist sichtbar")
    public void ProductsTitleIstSichtbar(){
        Assert.assertTrue(productPage.titleIsDisplayed());
    }
    @When("loginPage: logout anklicken")
    public void logoutClick(){
        productPage.logoutClick();
    }

    @Then("loginPage: Error-Message wurde gezeigt")
    public void loginpageErrorMessageWurdeGezeigt() {
        loginPage.checkErrorMessage();
    }

    @When("loginPage: user gibt falschen {string} und\\/oder {string}")
    public void loginpageUserGibtFalschenUndOder(String arg0, String arg1) {
    }
}
