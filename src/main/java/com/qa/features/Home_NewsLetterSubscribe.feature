Feature: HomePage Subscribe NewsLetter Feature

  Scenario : HomePage Subscribe NewsLetter Test Scenario
    Given User Opens the application
    When User redirect towards Login Page
    Then Title of Login Page is Account Login
    Then user logs into the application
    Then user is on Home Page
    Then user clicks on Newsletter menu item
    Then user selects the yes option
    Then user clicks continue button
    Then verify success message
