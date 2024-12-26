package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OverviewPage extends BasePage {
    public OverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrices; // Liste der Preise der Artikel

    @FindBy(css = ".summary_subtotal_label")
    private WebElement itemTotalLabel;

    @FindBy(id = "finish")
    private WebElement finish;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemNames;
    // Constructor

    // Methode zum Abrufen aller Artikelpreise
    public double[] getItemPrices() {
        double[] prices = new double[itemPrices.size()];
        for (int i = 0; i < itemPrices.size(); i++) {
            String priceText = itemPrices.get(i).getText().replace("$", "");
            prices[i] = Double.parseDouble(priceText);
        }
        return prices;
    }

    // Methode zum Abrufen des angezeigten "Item total"
    public double getItemTotal() {
        String itemTotalText = itemTotalLabel.getText();
        String totalValue = itemTotalText.split("\\$")[1]; // Nur den numerischen Wert extrahieren
        return Double.parseDouble(totalValue);
    }

    // Methode zur Überprüfung, ob die Summe der Artikelpreise der angezeigten Zwischensumme entspricht
    public boolean verifyItemTotal() {
        double[] itemPrices = getItemPrices();
        double calculatedSum = 0.0;

        for (double price : itemPrices) {
            calculatedSum += price;
        }

        double displayedTotal = getItemTotal();

        if (calculatedSum != displayedTotal) {
            throw new AssertionError("Berechnete Zwischensumme (" + calculatedSum +
                    ") entspricht nicht der angezeigten Zwischensumme (" + displayedTotal + ").");
        }
        return true;
    }

    public boolean istProkuktVorhanden(String itemName) {
        for (WebElement item : itemNames) {
            if (item.getText().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
   public void finishKlicken(){
        finish.click();
   }
}
