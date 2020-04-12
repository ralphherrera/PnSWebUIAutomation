package com.pnswebuiautomation.stepdefinitions;

import com.pnswebuiautomation.pageobjects.HomePage;
import com.pnswebuiautomation.pageobjects.ItemDetailsModalPage;
import com.pnswebuiautomation.pageobjects.SearchResultsPage;
import com.pnswebuiautomation.utilities.CommonUtility;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import io.cucumber.java8.En;

import java.time.Duration;
import java.time.LocalDateTime;

public class SampleSearchItemStepDefinition implements En {

//    private List<String> stepDurationList = new ArrayList<>();
    private LocalDateTime stepStartTime;
    private LocalDateTime stepEndTime;
    private Duration stepDuration;

    public SampleSearchItemStepDefinition(ScenarioHooks hooks, HomePage homePage, SearchResultsPage searchResultsPage,
                                          ItemDetailsModalPage itemDetailsModalPage) {
        Given("^I access my favorite shopping website$", () -> {
            String stepName = "I access my favorite shopping website";
            homePage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            homePage.openPage(FileMgmtUtility.getPropertyValue("website.url"));
            stepEndTime = CommonUtility.getCurrentTimeStamp();

            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));
        });

        And("^I enter '(.*)' in the search text field$", (String searchQuery) -> {
            String stepName = "I enter " + searchQuery + " in the search text field";
            stepStartTime = CommonUtility.getCurrentTimeStamp();
            homePage.enterSearchQueryInSearchTextField(searchQuery);
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));
        });

        And("^I click on search button$", () -> {
            String stepName = "I click on search button";
            stepStartTime = CommonUtility.getCurrentTimeStamp();
            homePage.clickSearchButton();
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));
        });

        When("^I click the quick view button$", () -> {
            searchResultsPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            String stepName = "I click the quick view button";
            stepStartTime = CommonUtility.getCurrentTimeStamp();
            searchResultsPage.clickQuickViewButton();
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));
        });

        Then("^I should see the item details and item description '(.*)'$", (String itemDescription) -> {
            itemDetailsModalPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            String stepName = "I should see the item details and item description";
            stepStartTime = CommonUtility.getCurrentTimeStamp();
            itemDetailsModalPage.switchToItemDetailsModalIframe();
            itemDetailsModalPage.verifyItemDescriptionDisplayedIsCorrect(itemDescription);
            stepEndTime = CommonUtility.getCurrentTimeStamp();

            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

//            hooks.setStepDurationList(stepDurationList);
        });

    }
}
