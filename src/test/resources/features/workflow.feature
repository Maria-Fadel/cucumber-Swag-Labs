Feature: kauf eines Produkts

  Scenario Outline: Regressionstest für das gesammte System
    Given loginPage: user ist in der Login-page
    When loginPage: user gibt email und password
    Then loginPage: user wird in inventory-Page weitergeleitet
    And loginPage: Products-Title ist sichtbar
    When productPage: "<Produkt>" in den Warenkorb legen
    And productPage: Warenkorb klicken
    And cartPage: Check "<Produkt>" ist in Warenkorb vorhanden
    And cartPage: Checkout klicken
    And yourInformaitionPage: "<FirstName>" first name eingeben
    And yourInformaitionPage: "<lastName>" last name eingeben
    And yourInformaitionPage: "<ZIP>" ZIP eingeben
    And yourInformaitionPage: Continue klicken
    And overviewPage: Check "<Produkt>" in Overview Page vorhanden ist
    And overviewPage: Finish klicken
    And completePage: Check Thank you Message ist vorhanden
    And completePage: Back Home klicken
    And completePage: logout anklicken


    Examples:
      | Produkt             |FirstName |lastName   |ZIP    |
      | Sauce Labs Backpack |Max       |Maximilian | 12345 |