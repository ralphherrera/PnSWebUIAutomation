package com.pnswebuiautomation.pageobjects;

import com.pnswebuiautomation.utilities.WebActionsUtility;
import com.pnswebuiautomation.utilities.WebWaitsUtility;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {

    private static final Logger log = LogManager.getLogger(LoginPage.class);

    // Page Elements
    @FindBy(css = "input[id='idp_OtherRpRadioButton']")
    private WebElement rdo_OtherSites;

    @FindBy(css = "select[id='idp_RelyingPartyDropDownList'] option")
    private List<WebElement> ddl_OtherSitesList;

    @FindBy(id = "idp_SignInButton")
    private WebElement btn_SignIn;

    @FindBy(css = "input[id='userNameInput']")
    private WebElement txt_Email;

    @FindBy(css = "input[id='passwordInput']")
    private WebElement txt_Password;

    @FindBy(id = "submitButton")
    private WebElement btn_Login;

    @FindBy(id = "errorText")
    private WebElement txt_LoginInvalidCredentials;

    // Page Methods
    public void clickElement(String elem) {
        webActionsUtil.clickElement(elem,returnPageElement(elem));
    }


    @Override
    public WebElement returnPageElement(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, WebElement> elementMap = new HashMap<>();

        elementMap.put("Other Sites Radio btn", rdo_OtherSites);
        elementMap.put("Sign In btn", btn_SignIn);
        elementMap.put("Email field", txt_Email);
        elementMap.put("Password field", txt_Password);
        elementMap.put("Login btn", btn_Login);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }

    @Override
    public List<WebElement> returnPageElementList(String key) {
        log.traceEntry("Getting page element [{}]", key);
        Map<String, List<WebElement>> elementMap = new HashMap<>();

        elementMap.put("Other Sites Dropdown List", ddl_OtherSitesList);

        if (!elementMap.containsKey(key)) {
            log.warn("No Page Element found with key [{}]", key);
            Assert.fail("No Page Element found with key");
        }
        return log.traceExit(elementMap.get(key));
    }

    /**
     * Opens the browser and navigates to the specified URL
     * @param url
     */
    public void openPage(String url) {
        log.traceEntry("Opening url: [{}]", url);
        webActionsUtil.navigateToPage(url);
    }

    /**
     * Clicks the Other Sites radio button
     */
    public void clickOtherSitesRadioButton() {
        webActionsUtil.clickElement("Other Sites Radio btn", rdo_OtherSites);
    }

    /**
     * Selects the specified option in the dropdown list
     * @param option
     */
    public void selectDropdownOptionFromWebsiteList(String option) {
        webActionsUtil.clickElementFromList(ddl_OtherSitesList, option);
    }

    /**
     * Clicks the Sign in button
     */
    public void clickSignInButton() {
        webActionsUtil.clickElement("Other Sites Radio btn", btn_SignIn);
    }

    /**
     * Enters specified text into the email field
     * @param text email of the user
     */
    public void enterTextToEmailField(String text) {
        webActionsUtil.enterTextToField(txt_Email, text);
    }

    /**
     * Enters specified text into the password field
     * @param password password of the user
     */
    public void enterTextToPassword(String password) {
        webActionsUtil.enterTextToField(txt_Password, password);
    }

    /**
     * Clicks the login button
     */
    public void clickLoginButton() {
        webActionsUtil.clickElement("Other Sites Radio btn", btn_Login);
    }

    /**
     * Checks if the error message is displayed when user credentials is invalid upon login
     * @param expectedErrorMessage Expected error message displayed
     * @return true if error message is displayed; false otherwise
     */
    public boolean verifyIsLoginErrorMessageIsDisplayed(String expectedErrorMessage) {
        return expectedErrorMessage.equalsIgnoreCase(webActionsUtil.getElementText(txt_LoginInvalidCredentials));
    }
}
