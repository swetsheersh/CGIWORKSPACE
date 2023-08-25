Feature: feature to test Forget Pass functionality of facebook

  Scenario: check login successful with valid credentials
    Given launch the browser for forget pass
    And Navigate to the forget pass URL
    When enter the email
    And clickon search button
    Then Recovery page should be displayed
    And Close the browser tab 