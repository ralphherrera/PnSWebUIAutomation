//package com.pnswebuiautomation.stepdefinitions;
//
//
//import com.pnswebuiautomation.pageobjects.LoginPage;
//import com.pnswebuiautomation.utilities.FileMgmtUtil;
//import io.cucumber.java.en.And;
//import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
//import io.cucumber.java.en.When;
//import org.junit.Assert;
//
//public class LoginAwsStepDefinitionMethodReference {
//
//    private ScenarioHooks hooks;
//    private LoginPage loginPage;
//
//    public LoginAwsStepDefinitionMethodReference() {
//
//    }
//
//    @Given("I access the AWS EC2 site")
//    public void i_access_the_aws_ec2_site() {
//        hooks = new ScenarioHooks();
//        loginPage = new LoginPage();
//        // Passes the the instance of WebWaitsUtil and WebActionsUtil instantiated
//        // in the Scenariohooks into the PageObject class
//        loginPage.setDriver(hooks.getWebWebsUtil(), hooks.getWebActionsUtil());
//
//        loginPage.openPage(FileMgmtUtil.getPropertyValue("website.url"));
//    }
//
//    @And("I click on Other Sites Radio button")
//    public void i_click_on_the_other_sites_radio_button() {
//        loginPage.clickOtherSitesRadioButton();
//    }
//
//    @And("I select 'Amazon Web Services' site in the dropdown")
//    public void i_select_amazon_web_services_site_in_the_dropdown() {
//        loginPage.selectDropdownOptionFromWebsiteList("Amazon Web Services");
//    }
//
//    @And("I click Sign in button in the first page")
//    public void i_click_sign_in_button_in_the_first_page() {
//        loginPage.clickSignInButton();
//    }
//
//    @And("I enter my email in the login page")
//    public void i_enter_my_email_in_the_login_page() {
//        loginPage.enterTextToEmailField("myonlyemailbutyouyeah@tribalgroup.com");
//    }
//
//    @And("I enter an invalid password in the login page")
//    public void i_enter_an_invalid_password_in_the_login_page() {
//        loginPage.enterTextToPassword("PasswordNgBayan123123Test");
//    }
//
//    @When("I click Sign in button in the login page")
//    public void i_click_sign_in_button_in_the_login_page() {
//        loginPage.clickLoginButton();
//    }
//
//    @Then("I should see an error message displayed")
//    public void i_should_see_an_error_message_displayed(String errorMessage) {
//        Assert.assertTrue("Verifiy user is not able to login with invalid credentials",
//                loginPage.verifyIsLoginErrorMessageIsDisplayed(errorMessage));
//    }
//}
