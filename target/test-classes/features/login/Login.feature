@Btrix-4131
Feature: Login
  As  user I want to login under different roles

  Background:
    Given user is on the landing page

  @hr
  Scenario: Login as a hr
    Then user logs in as a hr
    And user verifies that "Activity Stream" page name is displayed


  @negative
  Scenario: Verify warning message for invalid credentials
    Then user logs in with "wrong" username and "wrong" password
    And user verifies that "Incorrect login or password" warning message is displayed


  @helpdesk
  Scenario: Login as a helpdesk
    Then user logs in as a helpdesk
    And user verifies that "Activity Stream" page name is displayed

    @marketing
    Scenario: Login as a marketing
      Then user logs in as a marketing
      And user verifies that "Activity Stream" page name is displayed