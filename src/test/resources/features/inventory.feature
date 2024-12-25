Feature: User login standard_user
  Scenario: user kann sich  einloggen
    Given user ist in der Login-page
    When user gibt email und password
    Then user wird in inventory-Page weitergeleitet
    And Products-Title ist sichtbar