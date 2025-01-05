Feature: product

  Scenario Outline: Regressionstest für product-Page

    Given loginPage: user ist in der Login-page
    When loginPage: user gibt email und password
    Then loginPage: user wird in inventory-Page weitergeleitet
    And productPage: Products-Title ist sichtbar
    And productPage: check die products ist ungleich null
    And productPage: check die products ist gleich <productAnzahl>
    And productPage: check burger menu enthält <itemsAnzahl>
    When productPage: "<Produkt>" in den Warenkorb legen
    And  productPage: check Remove-Button für folgende "<Produkt>" ist sichtbar

    Examples:
      | productAnzahl |itemsAnzahl  | Produkt            |
      | 6            |4             | Sauce Labs Backpack|