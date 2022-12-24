@regression
Feature: As a user, I should be able to log in.
  @us_1
  Scenario Outline: Verify login with valid credentials
    Given user on the login page
    When user use username "<username>" and passcode
    And user click the login button
    Then verify the user should be at the dashboard page

    Examples: usernames:
      |username|
      |User10  |
      |User40  |
      |User70  |
      |User100 |