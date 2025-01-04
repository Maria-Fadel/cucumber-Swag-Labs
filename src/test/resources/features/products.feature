Feature: User login standard_user

  Scenario Outline: user kann sich  einloggen
    Given loginPage: user ist in der Login-page
    When loginPage: user gibt email und password
    Then loginPage: user wird in inventory-Page weitergeleitet
    And productPage: Products-Title ist sichtbar
    And productPage: check die products ist ungleich null
    And productPage: check die products ist gleich <productAnzahl>
    And productPage: check burger menu enthält <itemsAnzahl>

    Examples:
      | productAnzahl |itemsAnzahl |lastName   |ZIP    |
      | 6            |4             |Maximilian | 12345 |