$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src\\test\\resources\\features\\activity_stream\\Tasks.feature");
formatter.feature({
  "name": "Tasks",
  "description": "  As user I want to create a task from Activity Stream",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tasks"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Background"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on the landing page",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStepDefinition.user_is_on_the_landing_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Verify that user can create new task",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tasks"
    }
  ]
});
formatter.step({
  "name": "user logs in as a \"hr\"",
  "keyword": "When "
});
formatter.match({
  "location": "TasksStepDefinition.user_logs_in_as_a(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user navigates to \"Activity Stream\" and \"Tasks\"",
  "keyword": "Then "
});
formatter.match({
  "location": "TasksStepDefinition.user_navigates_to_and(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user clicks on \"New task\"",
  "keyword": "And "
});
formatter.match({
  "location": "TasksStepDefinition.user_clicks_on(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user creates new task",
  "keyword": "And "
});
formatter.match({
  "location": "TasksStepDefinition.user_creates_new_task()"
});
formatter.result({
  "error_message": "java.lang.NullPointerException\r\n\tat com.cybertek.pages.activity_stream.TasksPage.createNewTask(TasksPage.java:28)\r\n\tat com.cybertek.step_definitions.TasksStepDefinition.user_creates_new_task(TasksStepDefinition.java:31)\r\n\tat ✽.user creates new task(src\\test\\resources\\features\\activity_stream\\Tasks.feature:12)\r\n",
  "status": "failed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "status": "passed"
});
});