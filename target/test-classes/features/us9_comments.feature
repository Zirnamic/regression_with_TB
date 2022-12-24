@regression
Feature: As a user, I should be able to write comments to files/folders.

  @us_9
  Scenario Outline: Verify users to write comments to files/folder
    Given "<user>" on the dashboard page
    When the user clicks the "Files" module
    When the user clicks action-icon  from any file on the page
    And user choose the "Details" option
    * user clicks on Comments section module
    And user write a comment inside the input box
    And user click the submit button to post it
    Then Verify the comment is displayed in the comment section.

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |