package com.pnswebuiautomation.stepdefinitions;

import com.pnswebuiautomation.pageobjects.HomePage;
import com.pnswebuiautomation.pageobjects.ItemDetailsModalPage;
import com.pnswebuiautomation.pageobjects.SearchResultsPage;
import com.pnswebuiautomation.utilities.FileMgmtUtil;
import io.cucumber.java8.En;

public class SampleSearchItemStepDefinition implements En {

    public SampleSearchItemStepDefinition(ScenarioHooks hooks, HomePage homePage, SearchResultsPage searchResultsPage,
                                          ItemDetailsModalPage itemDetailsModalPage) {

        Given("^I access my favorite shopping website$", () -> {
            homePage.setDriver(hooks.getWebWebsUtil(), hooks.getWebActionsUtil());

            homePage.openPage(FileMgmtUtil.getPropertyValue("website.url"));
        });

        And("^I enter '(.*)' in the search text field$", (String searchQuery) -> {
            homePage.enterSearchQueryInSearchTextField(searchQuery);
        });

        And("^I click on search button$", () -> {
            homePage.clickSearchButton();
        });

        When("^I click the quick view button$", () -> {
            searchResultsPage.setDriver(hooks.getWebWebsUtil(), hooks.getWebActionsUtil());
            searchResultsPage.clickQuickViewButton();
        });

        Then("^I should see the item details and item description '(.*)'$", (String itemDescription) -> {
            itemDetailsModalPage.setDriver(hooks.getWebWebsUtil(), hooks.getWebActionsUtil());

            itemDetailsModalPage.switchToItemDetailsModalIframe();
            itemDetailsModalPage.verifyItemDescriptionDisplayedIsCorrect(itemDescription);
        });
    }
}
