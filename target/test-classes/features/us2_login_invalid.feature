@regression
Feature: As a user, I should be able to log in.
  @us_2
  Scenario Outline: Verify user login fail with invalid credentials
    Given user on the login page
    When user enter invalid "<username>" and "<password>"

    And user click the login button
    Then verify "<message>" message should be displayed
    Examples:
      | username     |   password        | message                     |
      | User10        |   Wrong           | Wrong username or password. |
      | Wrong        |   Userpass123     | Wrong username or password. |
      | Wrong        |   Wrong           | Wrong username or password. |
