package com.pnswebuiautomation.stepdefinitions;

import com.pnswebuiautomation.constants.CommonConstants;
import com.pnswebuiautomation.utilities.BrowserManager;
import com.pnswebuiautomation.utilities.FileMgmtUtility;
import com.pnswebuiautomation.utilities.WebActionsUtility;
import com.pnswebuiautomation.utilities.WebWaitsUtility;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ScenarioHooks implements En {

    private static final Logger log = LogManager.getLogger(ScenarioHooks.class);
    private static final String CFG_BROWSER = "browser";

    private WebActionsUtility webActionsUtil;
    private WebWaitsUtility webWaitsUtil;
    public static Scenario scenario;

    public static List<String> stepDurationList = new ArrayList<>();

    public ScenarioHooks() {

        Before((Scenario scenario) -> {
            try {
                log.info("Starting scenario: [{}]", scenario.getName());
                this.scenario = scenario;
                BrowserManager browserManager = new BrowserManager();
                WebDriver driver = browserManager.getBrowserWebDriver(FileMgmtUtility.getPropertyValue(CFG_BROWSER));
                driver.manage().deleteAllCookies();
                driver.manage().window().setSize(new Dimension(1920, 1080));
                driver.manage().timeouts().implicitlyWait(FileMgmtUtility.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);

                webWaitsUtil = new WebWaitsUtility(driver);
                webActionsUtil = new WebActionsUtility(driver, webWaitsUtil);

            } catch (WebDriverException wde) {
                log.error("Something is wrong with the WebDriver [{}]", wde.getMessage());
                Assert.fail("Something is wrong with the WebDriver. Please check stacktrace.");
            } catch (Exception e) {
                log.error("Something went wrong! [{}]", e.getMessage());
                Assert.fail("Something went wrong. Please check stacktrace.");
            }
        });

        After((Scenario scenario) -> {
            try {
                log.info("Ending scenario: {}", scenario.getName());
                if (scenario.isFailed()) {
                    log.error("Scenario [{}] failed. Please see stacktrace.", scenario.getName());
                }
                if (webWaitsUtil.getDriver() != null) {
                    webWaitsUtil.getDriver().quit();
                    webWaitsUtil = null;
                    log.info("Successfully closed WebDriver Instance");
                }



            } catch (WebDriverException wde) {
                log.error("Failed to close instance of Web Driver");
            } catch (Exception e) {
                log.error("No Web Driver instance to close");
            }
        });
    }

    public WebActionsUtility getWebActionsUtil() {
        return webActionsUtil;
    }

    public WebWaitsUtility getWebWaitsUtil() {
        return webWaitsUtil;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public List<String> getStepDurationList() {
        return stepDurationList;
    }

    public void setStepDurationList(List<String> stepDurationList) {
        this.stepDurationList = stepDurationList;
    }
}
