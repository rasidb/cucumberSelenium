@forms @demoqa
Feature: User fills the practice form

  Scenario: User fills out the practice form and submits
    Given the user is on the main page
    When the user clicks on the practice form
    And fills out the practice form
    Then submits the form
