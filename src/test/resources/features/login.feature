Feature: Validierung der Login-Funktion mit korrekten und falschen Anmeldedaten.

  Scenario Outline: Login-Funktion mit korrekten Anmeldedaten
    Given loginPage: user ist in der Login-page
    When loginPage: user gibt korrekten "<email>" und "<password>"
    Then loginPage: user wird in inventory-Page weitergeleitet


    Examples:
      | email             |password |
      | standard_user     |secret_sauce |


  Scenario Outline: Login-Funktion mit falschen Anmeldedaten
    Given loginPage: user ist in der Login-page
    When loginPage: user gibt falschen "<email>" und oder "<password>"
    Then loginPage: Error-Message wurde gezeigt


    Examples:
      | email             |password |
      | locked_out_user   |falsch |

