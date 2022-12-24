@regression
Feature: As a user, I should be able to access to Talks module

  Scenario Outline: verify users to access to Talks module
    Given "<user>" on the dashboard page
    When the user clicks the "Talk" module
    Then verify the page title is "Talk - Trycloud"

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |

  @us_11
  Scenario Outline: verify users to send a message
    Given "<user>" on the dashboard page
    When the user clicks the "Talk" module
    And user search "<friendUser>" from the search box
    And user write a message
    And user clicks to submit button
    Then the user should be able to see the message is displayed on the conversation log

    Examples: usernames:
      |user    | friendUser |
      |User10  | User100     |
      |User40  | User70     |
      |User70  | User40     |
      |User100 | User10     |