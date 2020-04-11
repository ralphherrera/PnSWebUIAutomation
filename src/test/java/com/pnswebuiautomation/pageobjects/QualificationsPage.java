package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QualificationsPage extends BasePage {

    private static final Logger log = LogManager.getLogger(QualificationsPage.class);

    // Page Elements
    @FindBy(css = "select[id='CountryOfBirth'] option")
    private List<WebElement> ddl_CountryOfBirthList;

    @FindBy(id = "YearArriveInAustralia")
    private WebElement txt_YearOfArrivalInAustralia;

    @FindBy(css = "select[id='CurrentEmploymentStatus'] option")
    private List<WebElement> ddl_CurrentEmploymentStatusList;

    @FindBy(css = "select[id='ReasonForTaking'] option")
    private List<WebElement> ddl_ReasonForTakingList;

    @FindBy(id = "SubmitButton")
    private WebElement btn_ContinueButton;

    // Page Methods
    @Override
    WebElement returnPageElement(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, WebElement> elementMap = new HashMap<>();

        elementMap.put("YearOfArrivalInAustralia", txt_YearOfArrivalInAustralia);
        elementMap.put("Continue Button", btn_ContinueButton);

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

        elementMap.put("CountryOfBirthList", ddl_CountryOfBirthList);
        elementMap.put("CurrentEmploymentStatusList", ddl_CurrentEmploymentStatusList);
        elementMap.put("ReasonForTakingList", ddl_ReasonForTakingList);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }
}
