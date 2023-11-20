@uploadAndDownload @demoqa_elements @demoqa
Feature:
  Scenario: user download and upload a file
    Given user clicks Upload and Download button
    And waits for the file to download
    And upload a file
    Then  checks that the file is uploaded