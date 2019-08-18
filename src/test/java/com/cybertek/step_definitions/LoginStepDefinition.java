package com.cybertek.step_definitions;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinition {
    Pages pages=new Pages();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
      pages.loginPage().goToLandingPage();
    }

    @Then("user logs in as a hr")
    public void user_logs_in_as_a_hr() {
      String username= ConfigurationReader.getProperty("hrusername");
      String password=ConfigurationReader.getProperty("hrpassword");
      pages.loginPage().login(username,password);
    }

    @Then("user verifies that {string} page name is displayed")
    public void user_verifies_that_page_name_is_displayed(String expected) {
       Assert.assertEquals(expected,pages.activityStreamPage().getPageSubTitle());

    }

}
