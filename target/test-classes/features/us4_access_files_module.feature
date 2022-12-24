@regression
Feature: As a user, I should be able to access to Files module.

  @us_4
  Scenario Outline: verify users can access to Files module
    Given "<user>" on the dashboard page
    When the user clicks the "Files" module
    Then verify the page title is "Files - Trycloud"

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |


  @us_4
  Scenario Outline: verify users can select all the uploaded files from the page
    Given "<user>" on the dashboard page
    When the user clicks the "Files" module
    And user click the top-left checkbox of the table
    Then verify all the files are selected

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |
