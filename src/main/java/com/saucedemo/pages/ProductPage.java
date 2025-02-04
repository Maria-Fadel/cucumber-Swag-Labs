package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public @FindBy(css = "span.title[data-test='title']")
    WebElement title;

    public @FindBy(id = "shopping_cart_container")
    WebElement warenkorb;

    @FindBy(css = ".inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrices;

    @FindBy(css = ".btn_inventory")
    private List<WebElement> addToCartButtons;

    @FindBy(css = ".bm-item.menu-item")
    private List<WebElement> menuItems;

      public int getItemCount() {
        return inventoryItems.size();
    }

    public String getItemName(int index) {
        return itemNames.get(index).getText();
    }

    public String getItemPrice(int index) {
        return itemPrices.get(index).getText();
    }

    public void addItemToCart(int index) {
        addToCartButtons.get(index).click();
    }

    public void clickAddToCartButtonByProductName(String productName) throws InterruptedException {
        // Schleife durch alle Elemente, um das Produkt mit dem gewünschten Namen zu finden
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equals(productName)) {
                // Wenn der Name übereinstimmt, klicke den "Add to Cart"-Button
                addToCartButtons.get(i).click();
                return; // Methode verlassen, nachdem das Produkt gefunden wurde
            }
        }
        // Wenn kein Produkt gefunden wurde, werfen wir eine Exception
        throw new NoSuchElementException("Kein Produkt mit dem Namen '" + productName + "' gefunden.");
    }
    public boolean checkProductsUngleichNull(){
          if (itemNames.size()== 0){
              return true;
          }else
              return false;
    }

    public boolean checkProductsIstgleichAnzahl(int anzahl){
        if (itemNames.size()== anzahl){
            return true;
        }else
            return false;
    }

    public boolean checkBurgerMenuEnthaeltItemsAnzahl(int anzahl){
        if (menuItems.size()== anzahl){
            return true;
        }else
            return false;
    }
    public boolean titleIsDisplayed(){

        String actualText = title.getText();
        String expectedText = "Products";

         return actualText.equals(expectedText);
    }

    public boolean checkCorrectPage(){
        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.saucedemo.com/inventory.html";
        return currentURL.equals(expectedURL);
    }

    public void warenkorbKlicken(){
        warenkorb.click();
    }

    public boolean istRemoveButtonSichtbar(String product) {

        String formattedId = "remove-" + product.toLowerCase().replace(" ", "-");
        // Sucht den Button anhand der ID
        WebElement removeButton = driver.findElement(By.id(formattedId));
        // Überprüft, ob das Element sichtbar ist
        return removeButton.isDisplayed();
    }
    public boolean istAddToCartButtonSichtbar(String product) {

        String formattedId = "add-to-cart-" + product.toLowerCase().replace(" ", "-");
        // Sucht den Button anhand der ID
        WebElement addToCartButton = driver.findElement(By.id(formattedId));
        // Überprüft, ob das Element sichtbar ist
        return addToCartButton.isDisplayed();
    }
    public void clickRemoveButton(String product) {
        String formattedId = "remove-" + product.toLowerCase().replace(" ", "-");
        WebElement removeButton = driver.findElement(By.id(formattedId));
        removeButton.click();


    }
}
