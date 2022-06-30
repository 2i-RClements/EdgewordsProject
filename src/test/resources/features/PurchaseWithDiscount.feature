Feature: Purchase With Discount
  Description: The test will login to an e-commerce site as a registered user, purchase an item of clothing, apply a
  discount code and check that the total is correct after the discount & shipping is applied.

  Background: User is Logged In
    Given I navigate to the login page
    When I submit the valid username "test@testaccount.co.uk" and password "Testtest123!"
    Then I should be logged in

  Scenario:
    Given I navigate to the Shop
    When I add an item to my cart
    And View my cart
    And Use the discount code "edgewords"
    Then I should receive 15% discount
    And The total after coupon and shipping should be correct
