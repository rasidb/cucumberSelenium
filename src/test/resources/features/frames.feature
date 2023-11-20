@demoqa @alerts
Feature: IFrame Test

  Scenario: Verify content inside the iframe
    Given I open the main page
    When I switch to the iframe
    Then I should see "This is a sample page" inside the iframe
    And I switch back to the main iframe
