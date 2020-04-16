package com.pnswebuiautomation.testcases;

import com.pnswebuiautomation.pageobjects.*;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import com.pnswebuiautomation.utilities.WebActionsUtility;
import com.pnswebuiautomation.utilities.WebWaitsUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ApplyLearnerOnVFHCourseTest {

    private static final Logger log = LogManager.getLogger(ApplyLearnerOnVFHCourseTest.class);

    private WebActionsUtility webActionsUtil;
    private WebWaitsUtility webWaitsUtil;

    private static final int RUN_DURATION = FileMgmtUtility.getNumberValue("run.minute");
    private final long NANOSEC_PER_SEC = 1000l*1000*1000;

    @Test
    @Tag("webTest")
    public void ApplyLearnerOnVFHCourseTest() {
        long startTime = System.nanoTime();
        while ((System.nanoTime()-startTime)< RUN_DURATION * 60 * NANOSEC_PER_SEC){

            WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
            webDriverBuilder.setUpWebDriver();
            this.webWaitsUtil = webDriverBuilder.getWebWaitsUtil();
            this.webActionsUtil = webDriverBuilder.getWebActionsUtil();

            TAFEEnrolmentPortalGetStartedPage getStartedPage = new TAFEEnrolmentPortalGetStartedPage();
            TAFEEnrolmentPortalAboutYouPage aboutYouPage = new TAFEEnrolmentPortalAboutYouPage();
            USIVerificationUnsuccessfulPage usiVerificationUnsuccessfulPage =  new USIVerificationUnsuccessfulPage();
            AboutYouCheckAndConfirmPage aboutYouCheckAndConfirmPage = new AboutYouCheckAndConfirmPage();
            QualificationsPage qualificationsPage = new QualificationsPage();
            ReviewPersonalInformationPage reviewPersonalInformationPage = new ReviewPersonalInformationPage();
            ConfirmationOfApplicationPage confirmationOfApplicationPage = new ConfirmationOfApplicationPage();

            getStartedPage.setDriver(webWaitsUtil, webActionsUtil);
            aboutYouPage.setDriver(webWaitsUtil, webActionsUtil);
            usiVerificationUnsuccessfulPage.setDriver(webWaitsUtil, webActionsUtil);
            aboutYouCheckAndConfirmPage.setDriver(webWaitsUtil, webActionsUtil);
            qualificationsPage.setDriver(webWaitsUtil, webActionsUtil);
            reviewPersonalInformationPage.setDriver(webWaitsUtil, webActionsUtil);
            confirmationOfApplicationPage.setDriver(webWaitsUtil, webActionsUtil);

            getStartedPage.openTAFEEnrolmentPortalSite(FileMgmtUtility.getPropertyValue("website.url"));

            getStartedPage.clickElementFromList("HowCourseSourceList", "Google");
            getStartedPage.clickElementFromList("StudiedPreviouslyList", "No");
            getStartedPage.clickElement("Continue button");

            aboutYouPage.clickElementFromList("ResideInAustraliaList", "Yes");
            aboutYouPage.clickElementFromList("AreYouAUSResidentList", "Permanent Humanitarian visa holder");
            aboutYouPage.inputTextToField("UniqueStudentIdTxtField", "HE73375392");
            aboutYouPage.clickElementFromList("IndigenousStatusList", "No");
            aboutYouPage.clickElementFromList("ApprenticeshipList", "Neither");
            aboutYouPage.clickElement("ContinuePage1of3 button");

            aboutYouPage.clickElementFromList("PersonTitleList", "Reverend");
            aboutYouPage.inputTextToField("FamilyNameTxtField", "Scotch");
            aboutYouPage.inputTextToField("FirstNameTxtField", "Tafe");
            aboutYouPage.inputTextToField("DateOfBirthTxtField", "01/01/1991");
            aboutYouPage.clickElementFromList("GenderList", "Female");
            aboutYouPage.inputTextToField("EmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.inputTextToField("ConfirmEmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.clickElement("ContinuePage2of3 button");

            usiVerificationUnsuccessfulPage.clickElement("Continue Button");

            aboutYouCheckAndConfirmPage.clickElement("ConfirmDetails");
            aboutYouCheckAndConfirmPage.clickElement("Continue Button");

            aboutYouPage.inputTextToField("StreetResidentialAddressLine", "Lo");
            aboutYouPage.inputTextToField("ResidentialAddressPostCode", "2000");
            aboutYouPage.clickElement("ValidateAddressPostalCode");
            aboutYouPage.isElementDisplayed("AddressSearchModal");
            aboutYouPage.selectRandomElementFromList("AddressSearchResultList");
            aboutYouPage.clickElementFromList("SpeakOtherLanguagesAtHomeList", "No");
            aboutYouPage.clickElementFromList("DisabilityStatusList", "No, I don't have a disability");
            aboutYouPage.clickElement("ContinuePage3of3 button");

            qualificationsPage.clickElementFromList("CountryOfBirthList", "Australia");
            qualificationsPage.clickElementFromList("CurrentEmploymentStatusList", "Part-time employee");
            qualificationsPage.clickElementFromList("ReasonForTakingList", "To try for a different career");
            qualificationsPage.clickElement("Continue Button");

            reviewPersonalInformationPage.clickElement("ConfirmDetails");
            reviewPersonalInformationPage.clickElement("Continue Button");

            Assertions.assertTrue(confirmationOfApplicationPage.isElementDisplayed("Header Text"),
                    "Verify Application of Learner to VFH Course is Successful");

            webDriverBuilder.tearDownWebDriver();
        }

    }
}
