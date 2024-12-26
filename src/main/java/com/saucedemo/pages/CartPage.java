package com.saucedemo.pages;

import com.saucedemo.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(css = ".inventory_item_name")
    private List<WebElement> itemNames;

    @FindBy(css = ".inventory_item_price")
    private List<WebElement> itemPrices;

    @FindBy(css = ".btn_secondary.cart_button")
    private List<WebElement> removeButtons;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public boolean isItemInCart(String itemName) {
        for (WebElement nameElement : itemNames) {
            if (nameElement.getText().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    public void removeItemFromCart(String itemName) {
        for (int i = 0; i < itemNames.size(); i++) {
            if (itemNames.get(i).getText().equalsIgnoreCase(itemName)) {
                removeButtons.get(i).click();
                return;
            }
        }
        throw new RuntimeException("Artikel mit dem Namen '" + itemName + "' wurde nicht im Warenkorb gefunden.");
    }

    public int getCartItemCount() {
        return cartItems.size();
    }

    public void weiterZuCheckout() {
        checkoutButton.click();
    }

    public void continueShopping() {
        continueShoppingButton.click();
    }



}
