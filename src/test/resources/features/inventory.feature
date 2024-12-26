Feature: User login standard_user

  Scenario Outline: user kann sich  einloggen
    Given user ist in der Login-page
    When user gibt email und password
    Then user wird in inventory-Page weitergeleitet
    And Products-Title ist sichtbar
    When "<Produkt>" in den Warenkorb legen
    And Warenkorb klicken
    And Check "<Produkt>" ist in Warenkorb vorhanden
    And Checkout klicken
    And "<FirstName>" first name eingeben
    And "<lastName>" last name eingeben
    And "<ZIP>" ZIP eingeben
    And Continue klicken
    And Check "<Produkt>" in Overview Page vorhanden ist
    And Finish klicken
    And Check Thank you Message ist vorhanden
    And Back Home klicken


    Examples:
      | Produkt             |FirstName |lastName   |ZIP    |
      | Sauce Labs Backpack |Max       |Maximilian | 12345 |