@appium
Feature: userLogin
  User logging in

  Scenario: Correct password
    Given I have a correct email and password
    When I try to Login
    Then Timeline Should Load