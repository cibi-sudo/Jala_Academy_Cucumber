Feature: Login functionality

  Background: the user is on the login page
    Given the user should be able to see login

  Scenario: User is able to login with valid credentials
    When the user enters their valid email "training@jalaacademy.com" and valid password "jobprogram"
    And the user clicks the Remember
    And the user clicks the login button
    Then the user should be able to see logout

  Scenario: User is unable to login with invalid credentials
    When the user enters an invalid email "invalidEmail" and invalid password "invalidPassword"
    And the user clicks the Remember
    And the user clicks the login button
    Then the user should see an error message

  Scenario: User is not able to login without credentials
    When the user not enters their email and password
    And the user clicks the Remember
    And the user clicks the login button
    Then the user should be able to see email warning
    And the user should be able to see password warning

  Scenario: User is unable to login with invalid email address
    When the user enters an invalid email "invalidEmail" and a valid password "jobprogram"
    And the user clicks the Remember
    And the user clicks the login button
    Then the user should see an error message

  Scenario: User is unable to login with invalid password
    When the user enters a valid email "training@jalaacademy.com" and an invalid password "invalidPassword"
    And the user clicks the Remember
    And the user clicks the login button
    Then the user should see an error message

  Scenario: User is able to go to the forget password page
    When the user clicks the forget password link
    Then the user should be on the forget password page

  Scenario: User is able to login with valid credentials using keyboard
    When the user enters their valid email "training@jalaacademy.com"
    And the user presses the tab key
    When the user enters their valid password "jobprogram"
    And the user presses the tab key
    And the user clicks the Remember
    And the user presses the tab key
    And the user presses the enter key
    Then the user should be able to see logout

  Scenario: User is able to see the placeholder text for username and password
    Then the username placeholder should be "Email or Mobile No"
    And the password placeholder should be "Password"

  Scenario: User is able to login with valid credentials without clicking Remember
    When the user enters their valid email "training@jalaacademy.com" and valid password "jobprogram"
    And the user clicks the login button
    Then the user should be able to see logout
