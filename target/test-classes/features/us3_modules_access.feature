@regression
Feature: As a user, I should be accessing all the main modules of the app.
  @us_3
  Scenario Outline:  Verify users accessing all the main modules of the app.
    Given user on the login page
    When the users  log in with valid credentials "<user>"
    Then Verify the user see the following modules:
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |