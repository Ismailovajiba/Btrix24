package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Hook {
    WebDriver driver;
    //default that runs for any scenario
    //default is common for all scenarios
    @Before(order = 2)
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");
        Driver.getDriver().manage().window().maximize();
      Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    //this hook will work only for a tag @storemanager
    //also it will run before default hook
    //because of priority
    // @Before(value = "@storemanager",order = 1)
    // public void setupForStoreManager(Scenario scenario){
    //  System.out.println("BEFORE FOR STORE MANAGER");
    // }
    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver(); // Takescrinshot is an interface comes from selnium
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //will attach screenshot into report
            scenario.embed(image,"image/png");// embed means insert it
        }
      Driver.closeDriver();
        System.out.println("AFTER");
        //  }
        // @After(value = "@storemanager",order = 1)
        //public void teardownForStoreManager(){
        //   System.out.println("AFTER FOR STORE MANAGER");
    }

}
