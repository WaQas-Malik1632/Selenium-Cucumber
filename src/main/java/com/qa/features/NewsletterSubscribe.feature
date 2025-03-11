
Feature: OpenCart Subscribe Newsletter

  Scenario Outline: OpenCart Subscribe Newsletter Test Scenario

    Given User is already on Login Page
    When Title of Login Page is Account Login
    Then User enters "<emailAddress>" and "<password>"
    Then User clicks on LoginButton
    Then User is on Home Page

    Then user clicks on Newsletter menu item
    Then user selects the yes option
    Then user clicks continue button
    Then Verify success message

    Examples:
      | emailAddress              | password        |
      | Testerqaw@youpmail.com    | Playwright@123  |
      | Tomtester@mailinator.com  | Secret@123      |
