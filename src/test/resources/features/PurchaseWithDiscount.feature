Feature: Purchase With Discount
  Description: The test will login to an e-commerce site as a registered user, purchase an item of clothing, apply a
  discount code and check that the total is correct after the discount & shipping is applied. The test will then log out.

  Background: User is Logged In
    Given I am on the account page
    When I enter the valid username "test@testaccount.co.uk" and password "Testtest123!"
    And I Log in
    Then I should be logged in

  Scenario: User navigates to the Shop
    Given I am on the account page
    When I navigate to the shop
    Then I am on the shop page

  Scenario: User adds an item to cart
    Given I am on the shop page
    When I add an item to cart
    And I view my cart
    Then I should see the item in my cart

#  Scenario: User uses discount code
#    Given I am on the cart page
#    And my cart is not empty
#    When I use the discount code "edgewords"
#    Then I should receive 15% discount
#    And The total after coupon and shipping should be correct

  Scenario: User adds an item to cart and uses discount code
    Given I am on the shop page
    When I add an item to cart
    And I view my cart
    And I use the discount code "edgewords"
    Then I should receive 15% discount
    And The total after coupon and shipping should be correct

  Scenario: User logs out
    Given I am on the cart page
    When I navigate to the account page
    And log out
    Then I should successfully log out





#  Scenario:
#    Given I navigate to the Shop
#    When I add an item to my cart
#    And View my cart
#    And Use the discount code "edgewords"
#    Then I should receive 15% discount
#    And The total after coupon and shipping should be correct


