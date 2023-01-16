@smoke
Feature: F03_Currencies | user could switch between different currencies
  Scenario: user move between different currencies
    When user select Euro currency
    Then currency is changed correctly to the euro symbol "€"