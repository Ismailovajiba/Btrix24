package com.cybertek.pages.activity_stream;

import com.cybertek.utilities.BasePage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends BasePage {
    WebDriver driver;
    public TasksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(className = "ui-btn-main")
    public WebElement newTask;
    @FindBy(className = "task-info-panel-title")
    public WebElement createTask;
    @FindBy(xpath = "//button[@class='ui-btn ui-btn-success']")
    public WebElement addTask;

    public void clickOnNewTask(){
        newTask.click();
    }
    public void createNewTask(){
        driver.switchTo().frame("iframe_17phope9oo");//jump into the frame
        driver.findElement(By.className(".task-info-panel-title")).sendKeys("Urgent message");
        BrowserUtils.waitPlease(2);
        driver.switchTo().defaultContent();//quit from the frame





      //createTask.sendKeys("Urgent message");
        addTask.click();

    }

}
