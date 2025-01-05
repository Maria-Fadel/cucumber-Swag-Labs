Feature: product

  Scenario Outline: Regressionstest für product-Page

    Given loginPage: user ist in der Login-page
    When loginPage: user gibt email und password
    Then loginPage: user wird in inventory-Page weitergeleitet
    And productPage: Products-Title ist sichtbar

    When productPage: "<Produkt>" in den Warenkorb legen
    And productPage: check Remove-Button für folgende "<Produkt>" ist sichtbar
    And productPage: "<Produkt>" Remove-Button anklicken
    And productPage: check add to cart-Button für folgende "<Produkt>" ist sichtbar


    Examples:
      | Produkt            |
      | Sauce Labs Backpack|