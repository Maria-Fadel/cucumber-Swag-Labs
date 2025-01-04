package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.YourInformaitionPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class yourInformationSteps {

    WebDriver driver;
    YourInformaitionPage yourInformaitionPage;

    public yourInformationSteps() {
        driver = DriverFactory.getDriver();
        yourInformaitionPage = new YourInformaitionPage(driver);
    }

    @When("yourInformaitionPage: {string} first name eingeben")
    public void first_name_eingeben(String firstName) {
        yourInformaitionPage.enterFirstName(firstName);
    }
    @When("yourInformaitionPage: {string} last name eingeben")
    public void last_name_eingeben(String lastName) {
        yourInformaitionPage.enterLastName(lastName);
    }
    @When("yourInformaitionPage: {string} ZIP eingeben")
    public void zip_eingeben(String ZIP) {
       yourInformaitionPage.enterPostalCode(ZIP);
    }
    @When("yourInformaitionPage: Continue klicken")
    public void continueKlicken() {
       yourInformaitionPage.clickContinue();
    }



}
