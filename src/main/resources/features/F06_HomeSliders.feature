@smoke
Feature: F06_Register | user could click on products in slider to go to its page
  Scenario: user click on first slider
    When first slider is clickable
    And click on first slider
    Then user go to url "https://demo.nopcommerce.com/nokia-lumia-1020"
  Scenario: user click on second slider
    When second slider is clickable
    And click on second slider
    Then user go to url "https://demo.nopcommerce.com/iphone-6"