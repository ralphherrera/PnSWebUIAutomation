package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TAFEEnrolmentPortalGetStartedPage extends BasePage {

    private static final Logger log = LogManager.getLogger(TAFEEnrolmentPortalGetStartedPage.class);

    // Page Elements
    @FindBy(css = "div[class='controls'] select")
    private List<WebElement> ddl_HowCourseSourceList;

    @FindBy(css = "input[name='HasStudiedPreviously']")
    private List<WebElement> rdolst_StudiedPreviouslyList;

    @FindBy(id = "HasStudiedPreviously_Yes")
    private WebElement rdo_StudiedPreviouslyAtTAFEYes;

    @FindBy(id = "HasStudiedPreviously_No")
    private WebElement rdo_StudiedPreviouslyAtTAFENo;

    @FindBy(id = "SubmitButton")
    private WebElement btn_Continue;

    // Page Methods
    @Override
    WebElement returnPageElement(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, WebElement> elementMap = new HashMap<>();

        elementMap.put("StudiedPreviouslyAtTAFEYes", rdo_StudiedPreviouslyAtTAFEYes);
        elementMap.put("StudiedPreviouslyAtTAFENo", rdo_StudiedPreviouslyAtTAFENo);
        elementMap.put("Continue button", btn_Continue);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }

    @Override
    List<WebElement> returnPageElementList(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, List<WebElement>> elementMap = new HashMap<>();

        elementMap.put("HowCourseSourceList", ddl_HowCourseSourceList);
        elementMap.put("StudiedPreviouslyList", rdolst_StudiedPreviouslyList);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }
}
