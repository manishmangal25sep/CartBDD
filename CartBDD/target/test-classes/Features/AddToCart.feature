Feature: Add Product to Cart
  
  Scenario: Add Product to Cart from WishList
    Given I Add four different products to my WishList
    When  I view my wishlist table
    Then  I find total four selected items in my WishList
    When  I Search for Lowest Price Product
    And 	I am able to add the lowest price item to my Cart
    Then 	I am able to verify the item in my cart
