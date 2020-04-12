package com.pnswebuiautomation.stepdefinitions;

import com.pnswebuiautomation.pageobjects.*;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import io.cucumber.java.bs.A;
import io.cucumber.java8.En;
import org.junit.Assert;

public class ApplyOnAVFHCourseStepDefinition implements En {

    public ApplyOnAVFHCourseStepDefinition(ScenarioHooks hooks, TAFEEnrolmentPortalGetStartedPage getStartedPage,
                                           TAFEEnrolmentPortalAboutYouPage aboutYouPage, USIVerificationUnsuccessfulPage usiVerificationUnsuccessfulPage,
                                           AboutYouCheckAndConfirmPage aboutYouCheckAndConfirmPage, QualificationsPage qualificationsPage,
                                           ReviewPersonalInformationPage reviewPersonalInformationPage,
                                           ConfirmationOfApplicationPage confirmationOfApplicationPage) {

        Given("^I navigate to the TAFE Enrolment Site$", () -> {
            getStartedPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            getStartedPage.openTAFEEnrolmentPortalSite(FileMgmtUtility.getPropertyValue("website.url"));
        });

        And("^I fill out the details in the Get Started Page questions$", () -> {
            getStartedPage.clickElementFromList("HowCourseSourceList", "Google");
            getStartedPage.clickElementFromList("StudiedPreviouslyList", "No");
            getStartedPage.clickElement("Continue button");
        });

        And("^I enter my personal information in about you page one of three$", () -> {
            aboutYouPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            aboutYouPage.clickElementFromList("ResideInAustraliaList", "Yes");
            aboutYouPage.clickElementFromList("AreYouAUSResidentList", "Permanent Humanitarian visa holder");
            aboutYouPage.inputTextToField("UniqueStudentIdTxtField", "HE73375392");
            aboutYouPage.clickElementFromList("IndigenousStatusList", "No");
            aboutYouPage.clickElementFromList("ApprenticeshipList", "Neither");
            aboutYouPage.clickElement("ContinuePage1of3 button");
        });

        And("^I enter my personal information in about you page two of three$", () -> {
            aboutYouPage.clickElementFromList("PersonTitleList", "Reverend");
            aboutYouPage.inputTextToField("FamilyNameTxtField", "Scotch");
            aboutYouPage.inputTextToField("FirstNameTxtField", "Tafe");
            aboutYouPage.inputTextToField("DateOfBirthTxtField", "01/01/1991");
            aboutYouPage.clickElementFromList("GenderList", "Female");
            aboutYouPage.inputTextToField("EmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.inputTextToField("ConfirmEmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.clickElement("ContinuePage2of3 button");
        });

        And("^I proceed with the USI Unsuccessful verification$", () -> {
            usiVerificationUnsuccessfulPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            usiVerificationUnsuccessfulPage.clickElement("Continue Button");
        });

        And("^I check and confirm the details I entered previously$", () -> {
            aboutYouCheckAndConfirmPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            aboutYouCheckAndConfirmPage.clickElement("ConfirmDetails");
            aboutYouCheckAndConfirmPage.clickElement("Continue Button");
        });

        And("^I enter my personal information in about you page three of three$", () -> {
            aboutYouPage.inputTextToField("StreetResidentialAddressLine", "Lo");
            aboutYouPage.inputTextToField("ResidentialAddressPostCode", "2000");
            aboutYouPage.clickElement("ValidateAddressPostalCode");
            aboutYouPage.isElementDisplayed("AddressSearchModal");
            aboutYouPage.clickElementFromList("AddressSearchResultList",
                    "Lower Ground Floor  323-339 Castlereagh Street, HAYMARKET  NSW, 2000");
            aboutYouPage.clickElementFromList("SpeakOtherLanguagesAtHomeList", "No");
            aboutYouPage.clickElementFromList("DisabilityStatusList", "No, I don't have a disability");
            aboutYouPage.clickElement("ContinuePage3of3 button");
        });

        And("^I fill out the Qualifications Page questions$", () -> {
            qualificationsPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            qualificationsPage.clickElementFromList("CountryOfBirthList", "Australia");
            qualificationsPage.clickElementFromList("CurrentEmploymentStatusList", "Part-time employee");
            qualificationsPage.clickElementFromList("ReasonForTakingList", "To try for a different career");
            qualificationsPage.clickElement("Continue Button");
        });

        When("^I confirm all the details I entered and proceed$", () -> {
            reviewPersonalInformationPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());

            reviewPersonalInformationPage.clickElement("ConfirmDetails");
            reviewPersonalInformationPage.clickElement("Continue Button");
        });

        Then("^I should see the confirmation for my application for the course$", () -> {
            confirmationOfApplicationPage.setDriver(hooks.getWebWaitsUtil(), hooks.getWebActionsUtil());
            Assert.assertTrue("Verify Application of Learner to VFH Course is Successful",
                    confirmationOfApplicationPage.isElementDisplayed("Header Text"));
        });


    }
}
