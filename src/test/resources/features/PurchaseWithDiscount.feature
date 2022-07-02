Feature: Purchase With Discount
  Description: The test will login to an e-commerce site as a registered user, purchase an item of clothing, apply a
  discount code and check that the total is correct after the discount & shipping is applied. The test will then log out.

  Background: User is Logged In
    Given I am on the account page
    When I submit the valid username "test@testaccount.co.uk" and password "Testtest123!"
    Then I should be logged in

  Scenario: Apply Discount
    Given I have an item in my cart
    When I apply the coupon code "edgewords"
    Then I should receive a 15% discount






