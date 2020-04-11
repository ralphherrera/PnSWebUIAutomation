package com.pnswebuiautomation.stepdefinitions;

import com.pnswebuiautomation.pageobjects.LoginPage;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import io.cucumber.java8.En;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class LoginAwsStepDefinitionLambda implements En {

    private static final Logger log = LogManager.getLogger(LoginAwsStepDefinitionLambda.class);

    public LoginAwsStepDefinitionLambda(ScenarioHooks hooks, LoginPage loginPage) {

        Given("^I access the AWS EC2 site$", () -> {
            // Passes the the instance of WebWaitsUtil and WebActionsUtil instantiated
            // in the Scenariohooks into the PageObject class
            loginPage.setDriver(hooks.getWebWebsUtil(), hooks.getWebActionsUtil());

            log.info(hooks.getScenario().getId());
            loginPage.openPage(FileMgmtUtility.getPropertyValue("website.url"));
        });

        And("^I click on Other Sites Radio button$", () -> loginPage.clickOtherSitesRadioButton());

        And("^I select 'Amazon Web Services' site in the dropdown$", () ->
                loginPage.selectDropdownOptionFromWebsiteList("Amazon Web Services"));

        And("^I click Sign in button in the first page$", () -> loginPage.clickSignInButton());

        And("^I enter my email in the login page$", () ->
                loginPage.enterTextToEmailField("myonlyemailbutyouyeah@tribalgroup.com"));

        And("^I enter an invalid password in the login page$", () ->
                loginPage.enterTextToPassword("PasswordNgBayan123123Test"));

        When("^I click Sign in button in the login page$", () -> loginPage.clickLoginButton());

        Then("^I should see an error message displayed$", (String errorMessage) -> {
            log.info(hooks.getScenario().getId());
            Assert.assertTrue("Verifiy user is not able to login with invalid credentials",
                    loginPage.verifyIsLoginErrorMessageIsDisplayed(errorMessage));
        });

    }
}