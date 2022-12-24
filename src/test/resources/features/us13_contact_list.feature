@regression
Feature: As a user, I should be able to view the contact list.
  @us_13
  Scenario Outline:  verify users can see all the contact names on the contact list
    Given "<user>" on the dashboard page
    When the user clicks the "Contacts" module
    Then verify the contact names are in the list

    Examples: usernames:
      |user|
      |User10  |
      |User40  |
      |User70  |
      |User100 |
