Feature: Pre-interview Exercise for Test Engineer Candidates
  This feature covers pre-interview exercise for HMRC Digital Worthing and http://automationpractice.com/index.php

  Scenario: Login, find the most expensive dress and add it to the cart and Logout
    Given I navigate to automation practice home page
    When I click Sign in link
    Then I navigate to page with title "Login - My Store"
    When I enter "hmrc113@test.com" email address for new account
    And I press the Create an account button
    Then Create New Account page heading is displayed
    When I enter "Hello" first name for new account
    And I enter "World" last name for new account
    And I enter "Qwerty" password for new account
    And I enter "Test Str 123" address 1 for new account
    And I enter "London" city for new account
    And I select "Alaska" state for new account
    And I enter "00000" post code for new account
    And I enter "123456789" mobile phone for new account
    And I press the submit account button
    Then My Account page with welcome text is displayed

  Scenario: Login, find the most expensive dress and add it to the cart and Logout
    Given I navigate to automation practice home page
    When I click Sign in link
    Then I navigate to page with title "Login - My Store"
    When I enter "hmrc113@test.com" email address for registered account
    And I enter "Qwerty" password for registered account
    And I press the Sign in button
    Then My Account page with welcome text is displayed
    When I click Dresses link
    Then Dresses page subheading is displayed
    When I select Sort by Price: Highest First
    And I click first item in grid image
    Then Dress details with name "Printed Dress" are displayed
    When I press Add to cart button
    And I click Proceed To Checkout button on overlay
    Then Cart page heading is displayed
    And Cart contains "Printed Dress" dress
    When I click Sign out link
    Then After Sign out action Sign In link is displayed

  Scenario: Back in again, ensuring the dress is still in the cart
    Given I navigate to automation practice home page
    When I click Sign in link
    Then I navigate to page with title "Login - My Store"
    When I enter "hmrc113@test.com" email address for registered account
    And I enter "Qwerty" password for registered account
    And I press the Sign in button
    Then My Account page with welcome text is displayed
    When I click Cart
    Then Cart page heading is displayed
    And Cart contains "Printed Dress" dress