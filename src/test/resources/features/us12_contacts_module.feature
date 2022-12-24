@regression
Feature: As a user, I should be able to access to Contacts module.

  @us_12
  Scenario Outline:  verify user access to Talks module
    Given "<user>" on the dashboard page
    When the user clicks the "Contacts" module
    Then verify the page title is "Contacts - Trycloud"

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |