@demoqa @alerts @browserWindows
Feature: Window Navigation

  Scenario: User navigates between browser windows
    Given the user opens the website
    When the user clicks the Browser Windows button
    Then a new browser window should open

