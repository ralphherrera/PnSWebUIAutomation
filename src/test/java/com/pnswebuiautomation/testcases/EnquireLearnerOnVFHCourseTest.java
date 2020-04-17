package com.pnswebuiautomation.testcases;

import com.pnswebuiautomation.pageobjects.*;
import com.pnswebuiautomation.utilities.CommonUtility;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import com.pnswebuiautomation.utilities.WebActionsUtility;
import com.pnswebuiautomation.utilities.WebWaitsUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EnquireLearnerOnVFHCourseTest {

    private static final Logger log = LogManager.getLogger(EnquireLearnerOnVFHCourseTest.class);

    private WebActionsUtility webActionsUtil;
    private WebWaitsUtility webWaitsUtil;
    private LocalDateTime stepStartTime;
    private LocalDateTime stepEndTime;
    private static List<String> stepDurationList = new ArrayList<>();
    private static final String TEST_CASE_NAME = "Enquire Learner on VFH Course";

    private static final int RUN_DURATION = FileMgmtUtility.getNumberValue("run.minute");
    private final long NANOSEC_PER_SEC = 1000l*1000*1000;

    @BeforeEach
    public void setUpBeforeEachTest() {

    }


    @Test
    @Tag("webTest")
    public void EnquireLearnerOnVFHCourseTest() {
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

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            getStartedPage.openTAFEEnrolmentPortalSite(FileMgmtUtility.getPropertyValue("website.url"));
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 1"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            getStartedPage.clickElementFromList("HowCourseSourceList", "Google");
            getStartedPage.clickElementFromList("StudiedPreviouslyList", "No");
            getStartedPage.clickElement("Continue button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 2"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            aboutYouPage.clickElementFromList("ResideInAustraliaList", "Yes");
            aboutYouPage.clickElementFromList("AreYouAUSResidentList", "Permanent Humanitarian visa holder");
            aboutYouPage.inputTextToField("UniqueStudentIdTxtField", "HE73375392");
            aboutYouPage.clickElementFromList("IndigenousStatusList", "No");
            aboutYouPage.clickElementFromList("ApprenticeshipList", "Neither");
            aboutYouPage.clickElement("ContinuePage1of3 button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 2"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            aboutYouPage.clickElementFromList("PersonTitleList", "Reverend");
            aboutYouPage.inputTextToField("FamilyNameTxtField", "Scotch");
            aboutYouPage.inputTextToField("FirstNameTxtField", "Tafe");
            aboutYouPage.inputTextToField("DateOfBirthTxtField", "01/01/1991");
            aboutYouPage.clickElementFromList("GenderList", "Female");
            aboutYouPage.inputTextToField("EmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.inputTextToField("ConfirmEmailAddressTxtField", "scotch.tafe@mail.com");
            aboutYouPage.clickElement("ContinuePage2of3 button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 3"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            usiVerificationUnsuccessfulPage.clickElement("Continue Button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 4"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            aboutYouCheckAndConfirmPage.clickElement("ConfirmDetails");
            aboutYouCheckAndConfirmPage.clickElement("Continue Button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 5"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            aboutYouPage.inputTextToField("StreetResidentialAddressLine", "Lo");
            aboutYouPage.inputTextToField("ResidentialAddressPostCode", "2000");
            aboutYouPage.clickElement("ValidateAddressPostalCode");
            aboutYouPage.isElementDisplayed("AddressSearchModal");
            aboutYouPage.selectRandomElementFromList("AddressSearchResultList");
            aboutYouPage.clickElementFromList("SpeakOtherLanguagesAtHomeList", "No");
            aboutYouPage.clickElementFromList("DisabilityStatusList", "No, I don't have a disability");
            aboutYouPage.clickElement("ContinuePage3of3 button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 6"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            qualificationsPage.clickElementFromList("CountryOfBirthList", "Australia");
            qualificationsPage.clickElementFromList("CurrentEmploymentStatusList", "Part-time employee");
            qualificationsPage.clickElementFromList("ReasonForTakingList", "To try for a different career");
            qualificationsPage.clickElement("Continue Button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step 7"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            reviewPersonalInformationPage.clickElement("ConfirmDetails");
            reviewPersonalInformationPage.clickElement("Continue Button");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step8"));

            stepStartTime = CommonUtility.getCurrentTimeStamp();
            Assertions.assertTrue(confirmationOfApplicationPage.isElementDisplayed("Header Text"),
                    "Verify Application of Learner to VFH Course is Successful");
            stepEndTime = CommonUtility.getCurrentTimeStamp();
            stepDurationList.add(CommonUtility.processStepDuration(stepStartTime, stepEndTime, TEST_CASE_NAME,
                    "Step9"));

            webDriverBuilder.tearDownWebDriver();
        }
    }

    @AfterAll
    public static void tearDownAfterAllTest() {
        final String CSV_FILE_EXT = ".csv";
        final String PROJECT_DIR_PATH = System.getProperty("user.dir");

        StringBuilder fileNameToPath = new StringBuilder();
        fileNameToPath.append(PROJECT_DIR_PATH);
        fileNameToPath.append("/");
        fileNameToPath.append("Results");
        fileNameToPath.append("/");
        fileNameToPath.append(TEST_CASE_NAME.replaceAll(" ", "_"));
        fileNameToPath.append("-");
        final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yy-MM-dd_HH-mm-ss");
        fileNameToPath.append(LocalDateTime.now().format(DATE_TIME_FORMATTER));
        fileNameToPath.append(CSV_FILE_EXT);

        FileMgmtUtility.writeTestStepDurationToCSV(fileNameToPath.toString(), stepDurationList);

    }
}
