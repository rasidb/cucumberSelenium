@demoqa @alerts
Feature: Handling Different Types of Alerts
  Scenario: Click Button to see different types of alerts
    Given the user is on the alert page
    When the user clicks the Alert Button
    Then an alert should appear after five seconds

    Then a confirm box should appear with the message "You selected Cancel"

    Then a prompt box should appear with the message "You entered rasid"
