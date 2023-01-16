@smoke
Feature: F05_HoverCategories | user could hover on a random category and chose it or from sub category
  Scenario: user chose category or sub category
    When user select random category or sub category
    Then category or sub-category title contains the one user chose