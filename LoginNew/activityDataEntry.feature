Feature: Enter Activity

  Scenario: Adding activity
    Given I am logged in
    When I try to enter a valid activity and save
    Then It should appear on the timeline