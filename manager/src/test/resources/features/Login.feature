@All @Login

Feature: Login
  As a user
  I want to login the app
  In order to get full access to the platform

  Scenario: Insert valid email and password and you will enter in your account
    Given I am at the login page
    When I insert an email account "qa@displaynote.com"
     And I insert an "123456" password
     And I press button log in
    Then I can see all dashboard manage devices

