package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CompletePage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class completeSteps {


    WebDriver driver;
    CompletePage completePage;

    public completeSteps() {
        driver = DriverFactory.getDriver();
        completePage = new CompletePage(driver);
    }

    @And("Check Thank you Message ist vorhanden")
    public void checkThankYouMessageIstVorhanden(){
        Assert.assertTrue(completePage.istThankYouMessageVorhanden());
    }

    @And("Back Home klicken")
    public void backHomeKlicken(){
        completePage.backHomeKlicken();
    }
}
