package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultsPage extends BasePage {

    private static final Logger log = LogManager.getLogger(SearchResultsPage.class);

    // Page Elements
    @FindBy(css = "div[class='product-container'] a[class='quick-view']")
    private WebElement quickViewItemDetailsButton;

    @FindBy(css = "div[class='product-container']")
    private WebElement productSearchContainer;


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
     * Clicks the quick view button in the product
     */
    public void clickQuickViewButton() {
        webActionsUtil.hoverMouseOverElement(productSearchContainer);
        webActionsUtil.clickElement("", quickViewItemDetailsButton);
    }
}
