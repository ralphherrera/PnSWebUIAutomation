package com.pnswebuiautomation.stepdefinitions;

import com.pnswebuiautomation.pageobjects.*;
import com.pnswebuiautomation.utilities.CommonUtility;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import io.cucumber.java.bs.A;
import io.cucumber.java8.En;
import org.junit.Assert;
import org.junit.ClassRule;

import java.lang.annotation.Repeatable;
import java.time.Duration;
import java.time.LocalDateTime;


public class ApplyOnAVFHCourseStepDefinition implements En {

    private LocalDateTime stepStartTime;
    private LocalDateTime stepEndTime;
    private Duration stepDuration;

    public ApplyOnAVFHCourseStepDefinition(ScenarioHooks hooks, TAFEEnrolmentPortalGetStartedPage getStartedPage,
                                           TAFEEnrolmentPortalAboutYouPage aboutYouPage, USIVerificationUnsuccessfulPage usiVerificationUnsuccessfulPage,
                                           AboutYouCheckAndConfirmPage aboutYouCheckAndConfirmPage, QualificationsPage qualificationsPage,
                                           ReviewPersonalInformationPage reviewPersonalInformationPage,
                                           ConfirmationOfApplicationPage confirmationOfApplicationPage) {

        Given("^I navigate to the TAFE Enrolment Site$", () -> {
            getStartedPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            getStartedPage.openTAFEEnrolmentPortalSite(FileMgmtUtility.getPropertyValue("website.url"));
            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I fill out the details in the Get Started Page questions$", () -> {
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I navigate to the TAFE Enrolment Site";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            getStartedPage.clickElementFromList("HowCourseSourceList", "Google");
            getStartedPage.clickElementFromList("StudiedPreviouslyList", "No");
            getStartedPage.clickElement("Continue button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I enter my personal information in about you page one of three$", () -> {
            aboutYouPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I fill out the details in the Get Started Page questions";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            aboutYouPage.clickElementFromList("ResideInAustraliaList", "Yes");
            aboutYouPage.clickElementFromList("AreYouAUSResidentList", "Permanent Humanitarian visa holder");
            aboutYouPage.inputTextToField("UniqueStudentIdTxtField", "HE73375392");
            aboutYouPage.clickElementFromList("IndigenousStatusList", "No");
            aboutYouPage.clickElementFromList("ApprenticeshipList", "Neither");
            aboutYouPage.clickElement("ContinuePage1of3 button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I enter my personal information in about you page two of three$", () -> {
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I enter my personal information in about you page one of three";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            aboutYouPage.clickElementFromList("PersonTitleList", "Reverend");
            aboutYouPage.inputTextToField("FamilyNameTxtField", "Scotch");
            aboutYouPage.inputTextToField("FirstNameTxtField", "Tafe");
            aboutYouPage.inputTextToField("DateOfBirthTxtField", "01/01/1991");
            aboutYouPage.clickElementFromList("GenderList", "Female");
            aboutYouPage.inputTextToField("EmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.inputTextToField("ConfirmEmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.clickElement("ContinuePage2of3 button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I proceed with the USI Unsuccessful verification$", () -> {
            usiVerificationUnsuccessfulPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I enter my personal information in about you page two of three";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            usiVerificationUnsuccessfulPage.clickElement("Continue Button");
            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I check and confirm the details I entered previously$", () -> {
            aboutYouCheckAndConfirmPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I proceed with the USI Unsuccessful verification";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            aboutYouCheckAndConfirmPage.clickElement("ConfirmDetails");
            aboutYouCheckAndConfirmPage.clickElement("Continue Button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I enter my personal information in about you page three of three$", () -> {
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I check and confirm the details I entered previously";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            aboutYouPage.inputTextToField("StreetResidentialAddressLine", "Lo");
            aboutYouPage.inputTextToField("ResidentialAddressPostCode", "2000");
            aboutYouPage.clickElement("ValidateAddressPostalCode");
            aboutYouPage.isElementDisplayed("AddressSearchModal");
            aboutYouPage.selectRandomElementFromList("AddressSearchResultList");
            aboutYouPage.clickElementFromList("SpeakOtherLanguagesAtHomeList", "No");
            aboutYouPage.clickElementFromList("DisabilityStatusList", "No, I don't have a disability");
            aboutYouPage.clickElement("ContinuePage3of3 button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        And("^I fill out the Qualifications Page questions$", () -> {
            qualificationsPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I enter my personal information in about you page three of three";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            qualificationsPage.clickElementFromList("CountryOfBirthList", "Australia");
            qualificationsPage.clickElementFromList("CurrentEmploymentStatusList", "Part-time employee");
            qualificationsPage.clickElementFromList("ReasonForTakingList", "To try for a different career");
            qualificationsPage.clickElement("Continue Button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        When("^I confirm all the details I entered and proceed$", () -> {
            reviewPersonalInformationPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I fill out the Qualifications Page questions";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            reviewPersonalInformationPage.clickElement("ConfirmDetails");
            reviewPersonalInformationPage.clickElement("Continue Button");

            stepStartTime = CommonUtility.getCurrentTimeStamp();
        });

        Then("^I should see the confirmation for my application for the course$", () -> {
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String stepName = "I confirm all the details I entered and proceed";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    stepName));

            confirmationOfApplicationPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            Assert.assertTrue("Verify Application of Learner to VFH Course is Successful",
                    confirmationOfApplicationPage.isElementDisplayed("Header Text"));
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            String laststepName = "I should see the confirmation for my application for the course";
            ScenarioHooks.stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, hooks.getScenario().getName(),
                    laststepName));
        });


    }
}
