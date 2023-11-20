@alerts @demoqa
Feature: Modal Dialog Test
  Scenario: Verify modal dialogs
    Given I navigate to the Modal Dialogs page
    When I click on the small modal button
    Then the small modal should be displayed
    When I click on the large modal button
    Then the large modal should be displayed
