package com.cybertek.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    //we don't want to access these variables outside
    private static final Logger logger = LogManager.getLogger();


    @FindBy(css = "div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    @FindBy(css = "span[class='menu-item-link-text']:nth-of-type(1)")
    protected WebElement pageSubTitle;


    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    /**
     * @return page name, for example: Dashboard
     */
    public String getPageSubTitle() {
        //ant time we are verifying page name, or page subtitle, loader mask appears
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForStaleElement(pageSubTitle);
        return pageSubTitle.getText();
    }


    /**
     * Waits until loader screen present. If loader screen will not pop up at all,
     * NoSuchElementException will be handled  bu try/catch block
     * Thus, we can continue in any case.
     */
    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            logger.error("Loader mask doesn't present.");
            System.out.println("Loader mask doesn't present.");
        }

    }

        /**
         * This method will navigate user to the specific module in btrix24 application.
         *
         * @param tab
         * @param module
         */
        public void navigateToModule(String tab, String module) {
            String tabLocator = "//span[@class='menu-item-link-text'][1]/span[contains(text(),'" + tab + "')]";
            String moduleLocator = "//a[@title='Tasks']/span[contains(text(),'" + module + "')]";
            try {
              // BrowserUtils.waitForClickablility(By.xpath(tabLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
               BrowserUtils.clickWithTimeOut(Driver.getDriver().findElement(By.xpath(tabLocator)), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
            } catch (Exception e) {
                logger.error("Failed to click on :: "+tab);
                logger.error(e);
                BrowserUtils.clickWithWait(By.xpath(tabLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
            }
            try {

                BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
                BrowserUtils.scrollToElement(Driver.getDriver().findElement(By.xpath(moduleLocator)));
                Driver.getDriver().findElement(By.xpath(moduleLocator)).click();

            } catch (Exception e) {
                logger.error("Failed to click on :: "+module);
                logger.error(e);
                BrowserUtils.clickWithTimeOut(Driver.getDriver().findElement(By.xpath(moduleLocator)),  Integer.valueOf(ConfigurationReader.getProperty("SHORT_WAIT")));
            }

    }


}
