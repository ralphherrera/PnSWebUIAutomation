package com.pnswebuiautomation.pageobjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TAFEEnrolmentPortalAboutYouPage extends BasePage {

    private static final Logger log = LogManager.getLogger(TAFEEnrolmentPortalAboutYouPage.class);

    // Page Elements
    // Citizenship / Residency
//    @FindBy(css = "input[name='ResideInAustralia']")
    @FindBy(css = "div[id='ResideInAustralia_container'] label[class='radio']")
    private List<WebElement> rdolst_ResideInAustraliaList;

    @FindBy(id = "ResideInAustralia_Yes")
    private WebElement rdo_ResideInAustraliaListYes;

    @FindBy(id = "ResideInAustralia_No")
    private WebElement rdo_ResideInAustraliaListNo;

    @FindBy(id = "UniqueStudentId")
    private WebElement txt_UniqueStudentId;

//    @FindBy(css = "input[name='ResidentialStatus']")
    @FindBy(css = "span[id='spanResidentialStatus'] + div > div > label[class='radio']")
    private List<WebElement> rdolst_AreYouAUSResidencyList;

    @FindBy(css = "select[name='IndigenousStatus'] option")
    private List<WebElement> ddl_IndigenousStatusList;

    // Apprentice or Trainee?
    @FindBy(css = "select[name='Apprenticeship'] option")
    private List<WebElement> ddl_ApprenticeshipList;

    @FindBy(css = "p[class='navigation-forward'] input[id='SubmitButton']")
    private WebElement btn_ContinuePage1of3;

    // About You Page 2 of 3
    @FindBy(css = "select[id='PersonTitle'] option")
    private List<WebElement> ddl_PersonTitleList;

    @FindBy(id = "FamilyName")
    private WebElement txt_FamilyName;

    @FindBy(id = "FirstName")
    private WebElement txt_FirstName;

    @FindBy(id = "DateOfBirth")
    private WebElement txt_DateOfBirth;

    @FindBy(css = "select[id='Gender'] option")
    private List<WebElement> txt_GenderList;

    @FindBy(id = "EmailAddress")
    private WebElement txt_EmailAddress;

    @FindBy(id = "ConfirmEmailAddress")
    private WebElement txt_ConfirmEmailAddress;

    @FindBy(css = "p[class='navigation-forward'] input[id='SubmitButton']")
    private WebElement btn_ContinuePage2of3;

    // About You Page 3 of 3
    @FindBy(id = "ResidentialAddressLine4")
    private WebElement txt_StreetResidentialAddressLine;

    @FindBy(id = "ResidentialAddressPostCode")
    private WebElement txt_ResidentialAddressPostCode;

    @FindBy(css = "div[id='ResidentialAddressPostCode_container'] button")
    private WebElement btn_ValidateAddressPostalCode;

    @FindBy(id = "modalAddressSearch")
    private WebElement modal_AddressSearchModal;

    @FindBy(css = "ul[id='addressResults'] li a")
    private List<WebElement> ullst_AddressSearchResultList;

//    @FindBy(css = "input[name='SpeakOtherLanguages']")
    @FindBy(css = "span[id='spanSpeakOtherLanguages'] + div > div > label[class='radio']")
    private List<WebElement> rdolst_SpeakOtherLanguagesAtHomeList;

    @FindBy(id = "SpeakOtherLanguages_Yes")
    private WebElement rdo_SpeakOtherLanguagesYes;

    @FindBy(id = "SpeakOtherLanguages_No")
    private WebElement rdo_SpeakOtherLanguagesNo;

    @FindBy(css = "select[name='DisabilityStatus'] option")
    private List<WebElement> ddl_DisabilityStatusList;

    @FindBy(css = "p[class='navigation-forward'] input[value='Continue']")
    private WebElement btn_ContinuePage3of3;

    // Page Methods
    @Override
    WebElement returnPageElement(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, WebElement> elementMap = new HashMap<>();

        elementMap.put("ResideInAustraliaListYes", rdo_ResideInAustraliaListYes);
        elementMap.put("ResideInAustraliaListNo", rdo_ResideInAustraliaListNo);
        elementMap.put("UniqueStudentIdTxtField", txt_UniqueStudentId);
        elementMap.put("ContinuePage1of3 button", btn_ContinuePage1of3);
        elementMap.put("FamilyNameTxtField", txt_FamilyName);
        elementMap.put("FirstNameTxtField", txt_FirstName);
        elementMap.put("DateOfBirthTxtField", txt_DateOfBirth);
        elementMap.put("EmailAddressTxtField", txt_EmailAddress);
        elementMap.put("ConfirmEmailAddressTxtField", txt_ConfirmEmailAddress);
        elementMap.put("ContinuePage2of3 button", btn_ContinuePage2of3);
        elementMap.put("StreetResidentialAddressLine", txt_StreetResidentialAddressLine);
        elementMap.put("ResidentialAddressPostCode", txt_ResidentialAddressPostCode);
        elementMap.put("ValidateAddressPostalCode", btn_ValidateAddressPostalCode);
        elementMap.put("AddressSearchModal", modal_AddressSearchModal);
        elementMap.put("SpeakOtherLanguagesYes", rdo_SpeakOtherLanguagesYes);
        elementMap.put("SpeakOtherLanguagesNo", rdo_SpeakOtherLanguagesNo);
        elementMap.put("ContinuePage3of3 button", btn_ContinuePage3of3);


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

        elementMap.put("ResideInAustraliaList", rdolst_ResideInAustraliaList);
        elementMap.put("AreYouAUSResidentList", rdolst_AreYouAUSResidencyList);
        elementMap.put("IndigenousStatusList", ddl_IndigenousStatusList);
        elementMap.put("ApprenticeshipList", ddl_ApprenticeshipList);
        elementMap.put("PersonTitleList", ddl_PersonTitleList);
        elementMap.put("GenderList", txt_GenderList);
        elementMap.put("AddressSearchResultList", ullst_AddressSearchResultList);
        elementMap.put("SpeakOtherLanguagesAtHomeList", rdolst_SpeakOtherLanguagesAtHomeList);
        elementMap.put("DisabilityStatusList", ddl_DisabilityStatusList);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }
}
