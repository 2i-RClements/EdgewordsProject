Feature: Checkout
  Description: The test will login to an e-commerce site as a registered user, purchase an item of clothing and go through checkout.
  It will capture the order number and check the order is also present in the ‘My Orders’ section of the site The test will then log out.

  Background: User is Logged In
    Given I am on the account page
    When I submit the valid username "test@testaccount.co.uk" and password "Testtest123!"
    Then I should be logged in

  Scenario: Checkout
    Given I have an item in my cart
    #This feels like a lot but I assume that's how you'd set it up if you eventually wanted to data drive this?
    When I use the valid first name "Test", last name "Tester", company name "Test", street address "404 Test Street", address line two "Test", city "Test", county "Test", postcode "ct110pb", phone "07777777777" to go through checkout
    Then I should be able to find my order