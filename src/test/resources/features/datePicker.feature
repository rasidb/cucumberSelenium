Feature: user on Widgets page
  Scenario: user on Date Picker page
    Given user open date picker menu
    And select a date
    And select date and time
    Then  assert results