package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TasksStepDefinition {
    Pages pages=new Pages();

    @When("user logs in as a {string}")
    public void user_logs_in_as_a(String string) {
        String username= ConfigurationReader.getProperty("hrusername");
        String password=ConfigurationReader.getProperty("hrpassword");
        pages.loginPage().login(username,password);
    }

    @Then("user navigates to {string} and {string}")
    public void user_navigates_to_and(String tab, String module) {
    pages.tasksPage().navigateToModule(tab, module);
    }

    @Then("user clicks on {string}")
    public void user_clicks_on(String string) {
      pages.tasksPage().clickOnNewTask();
    }


    @Then("user creates new task")
    public void user_creates_new_task() {
        pages.tasksPage().createNewTask();

    }

}
