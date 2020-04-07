package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {

    private static final Logger log = LogManager.getLogger(HomePage.class);

    // Page Elements
    @FindBy(id = "search_query_top")
    private WebElement searchTextField;

    @FindBy(css = "button[name='submit_search']")
    private WebElement searchButton;


    // Page Methods
    @Override
    WebElement returnPageElement(String key) {
        return null;
    }

    @Override
    List<WebElement> returnPageElementList(String key) {
        return null;
    }

    /**
     * Opens the browser and navigates to the specified URL
     * @param url url site to be tested
     */
    public void openPage(String url) {
        log.traceEntry("Opening url: [{}]", url);
        webActionsUtil.navigateToPage(url);
    }

    /**
     * Enters search query in the search text field
     * @param searchQuery search keyword
     */
    public void enterSearchQueryInSearchTextField(String searchQuery) {
        webActionsUtil.enterTextToField(searchTextField, searchQuery);
    }

    /**
     * Enters search query button
     */
    public void clickSearchButton() {
        webActionsUtil.clickElement("Search Button", searchButton);
    }
}
