@smoke
Feature: F04_Search | user will be able to search for products with different parameters
  Scenario Outline: user search using product name
    When user click on search field
    And user search with "<productName>"
    Then user could find "<productName>" relative results
    Examples:
      |productName|
      |apple      |
      |laptop     |
      |nike       |
  Scenario Outline: user search for product using sku
    When user click on search field
    And user search with "<sku>"
    Then user could find "<sku>" inside product detail page
    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|