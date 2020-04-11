package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfirmationOfApplicationPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ConfirmationOfApplicationPage.class);

    // Page Elements
    @FindBy(css = "div[class='page-body'] h1")
    private WebElement header_ConfirmationOfApplicationPage;

    @FindBy(xpath = "(//div[@class='page-body']//p)[3]")
    private WebElement txtlbl_ThankYouMessage;

    // Page Methods
    @Override
    WebElement returnPageElement(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, WebElement> elementMap = new HashMap<>();

        elementMap.put("Header Text", header_ConfirmationOfApplicationPage);
        elementMap.put("Thank You Message", txtlbl_ThankYouMessage);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }

    @Override
    List<WebElement> returnPageElementList(String key) {
        return null;
    }
}
