package com.cybertek.pages.login_navigation;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[name='USER_LOGIN']")
    @CacheLookup
    public WebElement usernameElement;

    @FindBy(css = "input[name='USER_PASSWORD']")
    @CacheLookup
    public WebElement passwordElement;

    @FindBy(css = "input[type='submit']")
    public WebElement loginButtonElement;

    @FindBy(xpath = "//input[@name='USER_REMEMBER']")
    public WebElement rememberMeElement;

    @FindBy(partialLinkText = "Forgot your password?")
    public WebElement forgotPasswordElement;

    @FindBy(tagName = "b_line_gray")
    public WebElement titleElement;

    @FindBy(className = "errortext")
    public WebElement errorMessageElement;

    public void login(String username, String password){
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }

    public void login(){
        String username = ConfigurationReader.getProperty("hrusername");
        String password = ConfigurationReader.getProperty("hrpassword");
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }
    public void login(String role) {
        String username = "";
        String password = "";
        if (role.equalsIgnoreCase("hr")) {
            username = ConfigurationReader.getProperty("hrusername");
            password = ConfigurationReader.getProperty("hrpassword");
        } else if (role.equalsIgnoreCase("helpdesk")) {
            username = ConfigurationReader.getProperty("helpdeskusername");
            password = ConfigurationReader.getProperty("helpdeskpassword");
        } else if (role.equalsIgnoreCase("marketing")) {
            username = ConfigurationReader.getProperty("marketingusername");
            password = ConfigurationReader.getProperty("marketpassword");
        }
        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);
        loginButtonElement.click();
    }
    public String getErrorMessage(){
        return errorMessageElement.getText();
    }

    public void clickRememberMe(){
        BrowserUtils.waitForClickablility(rememberMeElement, Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
        if(!rememberMeElement.isSelected()){
            rememberMeElement.click();
        }
    }
    public void goToLandingPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
}
