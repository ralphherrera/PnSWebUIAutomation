package com.pnswebuiautomation.pageobjects;

import com.pnswebuiautomation.utilities.WebActionsUtility;
import com.pnswebuiautomation.utilities.WebWaitsUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

abstract class BasePage {

    private static final Logger logger = LogManager.getLogger(BasePage.class);

    protected WebDriver driver;
    protected WebActionsUtility webActionsUtil;
    protected WebWaitsUtility webWaitsUtil;

    public BasePage() {

    }

    public void setDriver(WebWaitsUtility webWaitsUtil, WebActionsUtility webActionsUtil) {
        this.webWaitsUtil = webWaitsUtil;
        this.webActionsUtil = webActionsUtil;
        this.driver = webWaitsUtil.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Page Element Repository
    abstract WebElement returnPageElement(String key);

    abstract List<WebElement> returnPageElementList(String key);

    // Page Actions
    public void clickElement(String element) {
        webActionsUtil.clickElement(element, returnPageElement(element));
    }

    public void jsClickElement(String element) {
        webActionsUtil.jsClickElement(returnPageElement(element));
    }

    public void clickElementFromList(String elements, String key) {
        webActionsUtil.clickElementFromList(returnPageElementList(elements), key);
    }

    public void inputTextToField(String element, String input) {
        webActionsUtil.enterTextToField(returnPageElement(element), input);
    }

    public boolean isElementDisplayed(String element) {
        boolean isDisplayed = webWaitsUtil.isElementPresent(returnPageElement(element));
        return isDisplayed;
    }

    public boolean verifyHtmlAttributeIsChanged(String element, String attribute, String value) {
        return webWaitsUtil.waitForHtmlAttributeToChange(returnPageElement(element), attribute, value);
    }

    public void waitForTextToChange(String element, String text) {
        webWaitsUtil.waitForTextToChange(returnPageElement(element), text);
    }

    public boolean waitForElementToDisappear(String element) {
        return webWaitsUtil.waitForElementToDisappear(returnPageElement(element));
    }
}
