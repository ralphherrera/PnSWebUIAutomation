package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ItemDetailsPage extends BasePage {

    private static final Logger log = LogManager.getLogger(ItemDetailsPage.class);

    // Page Elements
    @FindBy(css = "iframe[class='fancybox-iframe']")
    private WebElement quickViewModalIframe;

    @FindBy(id = "product")
    private WebElement quickViewModalMainWindow;

    @FindBy(css = "body[id='product'] div[id='short_description_content'] p")
    private WebElement itemDetailsDescription;

    @FindBy(css = "body[id='product'] div h1")
    private WebElement itemDetailsItemName;

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
     * Switches to the Quick View Item Details iFrame
     */
    public void switchToItemDetailsModalIframe() {
        webActionsUtil.switchToIFrame(quickViewModalIframe);
    }

    /**
     * Checks if the item description displayed is correct
     * @param itemDescription Description of item
     * @return true if item description is the same with the scenario; false otherwise
     */
    public boolean verifyItemDescriptionDisplayedIsCorrect(String itemDescription) {
        return itemDescription.equalsIgnoreCase(webActionsUtil.getElementText(itemDetailsDescription));
    }
}
