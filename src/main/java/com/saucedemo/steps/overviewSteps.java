package com.saucedemo.steps;

import com.saucedemo.factory.DriverFactory;
import com.saucedemo.pages.OverviewPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class overviewSteps {

    WebDriver driver;
    OverviewPage overviewPage;

    public overviewSteps() {
        driver = DriverFactory.getDriver();
        overviewPage = new OverviewPage(driver);
    }

    @When("Check {string} in Overview Page vorhanden ist")
    public void check_in_overview_page_vorhanden_ist(String produktName) {
        Assert.assertTrue(overviewPage.istProkuktVorhanden(produktName));


    }
    @When("Finish klicken")
    public void finish_klicken() {
        overviewPage.finishKlicken();
    }
}
