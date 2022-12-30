Feature: Login functionality on ecommerce website
  As a user, I want to be able to log in to the website so that I can access my account.

  Scenario: Successful login
    Given I am on the login page of the website
    When I login with valid credentials
    Then I should be redirected to my account

  Scenario: Incorrect password
    Given I am on the login page of the website
    When I login with a valid email and invalid password
    Then I should see an error message indicating that the password is incorrect