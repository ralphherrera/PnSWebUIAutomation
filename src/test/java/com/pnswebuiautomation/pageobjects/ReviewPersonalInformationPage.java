package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReviewPersonalInformationPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ReviewPersonalInformationPage.class);

    // Page Elements
    @FindBy(id = "ConfirmDetails")
    private WebElement chk_ConfirmDetails;

    @FindBy(css = "p[class='navigation-forward'] input[value='Continue']")
    private WebElement btn_Submit;

    // Page Methods
    @Override
    WebElement returnPageElement(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, WebElement> elementMap = new HashMap<>();

        elementMap.put("ConfirmDetails", chk_ConfirmDetails);
        elementMap.put("Continue Button", btn_Submit);

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
