Feature: Verify homepage logout and employee functionality

  Background: the user is on the home page
    Given User is able to login with valid email "training@jalaacademy.com" and valid password "jobprogram"
    And the user clicks the Remember
    And the user clicks the login button

  Scenario: Verify that clicking the logout button logs the user out
    When the user should be able to see logout
    And the user clicks the logout button
    Then the user is logged out and should be able to see Sign-in

  Scenario: Verify that clicking the employee able to see create and search
    When the user clicks the employee
    Then the user is able to see create
    And the user is able to see search

  Scenario: Verify that clicking the create button on the employee page takes the user to the create employee page
    When the user clicks the employee
    Then the user is able to see create
    And  the user is clicks the create
    Then the user is taken to the create employee page
