 # symbol is used to comment feature file....

 # --------------------Without example keywords-------------

#Feature: OpenCart Login Feature
#Scenario: OpenCart Login Test Scenario

#Given User is already on Login Page
#When Title of Login Page is OpenCart
#Then User enters "Testerqaw@youpmail.com" and "Playwright@123"
#Then User clicks on LoginButton
#And User is on Home Page



 # --------------------With example keywords-------------

Feature: OpenCart Login Feature

  Scenario Outline: OpenCart Login Test Scenario

    Given User is already on Login Page
    When Title of Login Page is Account Login
    Then User enters "<emailAddress>" and "<password>"
    Then User clicks on LoginButton
    Then User is on Home Page

    Examples:
      | emailAddress             | password        |
      | Testerqaw@youpmail.com   | Playwright@123  |
      | Tomtester@mailinator.com | Secret@123      |