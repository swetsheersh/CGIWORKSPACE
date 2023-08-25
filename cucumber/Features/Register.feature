Feature: feature to test Register functionality of facebook

  Scenario: check Register successfully with valid credentials
    Given launch the browser for register
    And Navigate to the Register URL
    When enter the data
    And click submit button
    Then user should be Registered Successfully
    And Close the browser register
