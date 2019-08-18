@tasks
Feature: Tasks
  As user I want to create a task from Activity Stream

  Background:
    Given user is on the landing page

  Scenario: Verify that user can create new task
    When user logs in as a "hr"
    Then user navigates to "Activity Stream" and "Tasks"
    And user clicks on "New task"
    And user creates new task


