package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CompletePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class completeSteps {


    WebDriver driver;
    CompletePage completePage;

    public completeSteps() {
        driver = DriverFactory.getDriver();
        completePage = new CompletePage(driver);
    }

    @And("completePage: Check Thank you Message ist vorhanden")
    public void checkThankYouMessageIstVorhanden(){
        Assert.assertTrue(completePage.istThankYouMessageVorhanden());
    }

    @And("completePage: Back Home klicken")
    public void backHomeKlicken(){
        completePage.backHomeKlicken();
    }
    @When("completePage: logout anklicken")
    public void logoutClick(){
        completePage.logoutClick();
    }
}
