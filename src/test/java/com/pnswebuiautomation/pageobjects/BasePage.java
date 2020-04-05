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


}
