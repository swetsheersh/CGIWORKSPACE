Feature: feature to test login functionality of facebook

  Scenario: check login successful with valid credentials
    Given launch the browser
    And Navigate to the URL
    #When enter the username as "gaurav.sumit@gmail.com" and password as "Gaurav123"
    When enter the username as "<email>" and password as "<pass>"
    And clickon submit button
    Then Home page should be displayed
    And Close the browser
    
    Examples:
				| email | pass |
				| gaurav.saket@gmail.com | Saurav123 |
				| admin@gmail.com | Admin123 |
