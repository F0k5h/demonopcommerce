@smoke
Feature: F08_Wishlist | user could add products to a wishlist
  Scenario: user add product to wishlist
    When click on wishlist button "❤️" on this product "HTC One M8 Android L 5.0 Lollipop"
    Then use see success message "The product has been added to your wishlist" with green background color
  Scenario: user add product to wishlist
    When click on wishlist button "❤️" on this product "HTC One M8 Android L 5.0 Lollipop"
    And wait until success message with green color to disappear
    And click on "Wishlist" Tab on the top of the page
    Then Qty value is bigger than 0