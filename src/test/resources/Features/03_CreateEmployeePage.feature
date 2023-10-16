Feature: Create employee functionality

  Background: the user is on the create employee page
    Given User is able to login with valid email "training@jalaacademy.com" and valid password "jobprogram"
    And the user clicks the Remember
    And the user clicks the login button
    When the user clicks the employee
    And  the user is clicks the create
    Then the user is taken to the create employee page

  Scenario: Verify user name max length
    Then the user name field should have a maximum length of "20" characters

  Scenario: Verify user name placeholder
    Then the user name field should have a placeholder of "First Name"

  Scenario: Verify last name max length
    Then the last name field should have a maximum length of "20" characters

  Scenario: Verify last name placeholder
    Then the last name field should have a placeholder of "Last Name"

  Scenario: Verify email warning message
    When the user enters an invalid email address "invaldEmail" in the email field
    And the user clicks the save button
    Then the user should see an error message indicating that the "Please enter valid email address"

  Scenario: Verify mobile number max length
    Then the mobile number field should have a maximum length of "10" characters

  Scenario: Verify mobile number placeholder
    Then the mobile number field should have a placeholder of "Mobile No"

  Scenario: Verify male radio selected
    Then the male radio button should be selected

  Scenario: Verify female radio selected
    Then the female radio button should not be selected

  Scenario: Verify female radio deselected
    When the user selects the female radio button
    Then the male radio button should not be selected

  Scenario: Verify male radio deselected
    When the user selects the male radio button
    Then the female radio button should not be selected

  Scenario: Verify city disabled
    Then the city field should be disabled

  Scenario: Verify other city placeholder
    Then the other city field should have a placeholder of "City Name"

  Scenario: Verify save without credentials
    When the user clicks the save button
    Then the user should see an error message indicating that all fields are required

  Scenario: Verify save with valid credentials
    When the user enters valid credentials in all fields following details in the column
      | firstName | lastName | email                  | mobileNumber | dob        | address                           | country | city       |
      | Jane      | Smith    | jane.smith@example.com | 4444444444   | 02/02/1992 | 456 Elm Street, Anytown, CA 91234 | USA     | California |
    And the user clicks the skill checkbox
    And the user clicks the save button
    Then the user should be created successfully

  Scenario: Verify spelling of skills
    Then the skills field should be spelled correctly as "skills"

  Scenario: Verify mobile number warning while low count
    When the user enters an invalid mobile number "987456123" in the mobile number field
    And the user clicks the save button
    Then the user should see an error message indicating that "Mobile No must be 10 digits."