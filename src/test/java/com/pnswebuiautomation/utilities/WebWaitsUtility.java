package com.pnswebuiautomation.utilities;

import com.pnswebuiautomation.constants.CommonConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebWaitsUtility {

    private static final Logger log = LogManager.getLogger(WebWaitsUtility.class);
    private static final int ZERO_TIMEOUT = 0;
    private final static Duration WAIT_FOR_PAGELOAD_TIMEOUT = Duration.ofSeconds(FileMgmtUtil.getNumberValue("default.wait.for.page"));
    private final static Duration EXPLICIT_WAIT_TIMEOUT = Duration.ofSeconds(FileMgmtUtil.getNumberValue(CommonConstants.EXPLICIT_TIMEOUT));

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public WebWaitsUtility(WebDriver driver) {
        this.driver = driver;
    }

    /***
     *
     */
    public void waitForPageToLoad() {
        log.traceEntry();
        try {
            if (!isPageLoaded()) {
                WebDriverWait driverWait = new WebDriverWait(driver, WAIT_FOR_PAGELOAD_TIMEOUT);
                driverWait.until(ExpectedConditions.jsReturnsValue("return document.readyState=='complete';"));
            }
        } catch (Exception e) {
            log.error("Page did not load {}", e.getMessage());
            Assert.fail();
        }
        log.traceExit();
    }

    /***
     *
     * @return
     */
    public boolean isPageLoaded() {
        log.traceEntry();
        return log.traceExit(((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    /***
     * Checks the Page Element in the DOM if it is present
     * @param element
     * @return True if element is present | False if element is not displayed in the DOM
     */
    public boolean isElementPresent(WebElement element) {
        log.traceEntry();

        WebElement target;
        boolean isElementDisplayed = false;
        try {
            driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);

            WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
            target = driverWait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(element));


            if (target.isDisplayed()) {
                isElementDisplayed = true;
            }
        } catch (NoSuchElementException nsee) {
            log.error("Cannot find element [{}]", nsee.getMessage());
            Assert.fail("Element is not present");
        } catch (Exception e) {
            log.error("Something went wrong finding element [{}]", e.getMessage());
            Assert.fail("Element is not present");
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        return log.traceExit(isElementDisplayed);
    }

    /***
     * Checks the Page Element in the DOM if it is present
     * @param by
     * @return True if element is present | False if element is not displayed in the DOM
     */
    public boolean isElementPresent(By by) {
        log.traceEntry();

        boolean isElementDisplayed = false;
        try {
            driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);

            WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
            driverWait.ignoring(StaleElementReferenceException.class).until((WebDriver d) -> {
                d.findElement(by);
                return true;
            });

        } catch (NoSuchElementException nsee) {
            log.error("Cannot find element [{}]", nsee.getMessage());
            Assert.fail("Element is not present");
        } catch (Exception e) {
            log.error("Something went wrong finding element [{}]", e.getMessage());
            Assert.fail("Element is not present");
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        return log.traceExit(isElementDisplayed);
    }

    /***
     * Checks the Page Element in the DOM if it is present
     * @param element
     * @return True if element is present | False if element is not displayed in the DOM
     */
    public boolean waitForElementToDisappear(WebElement element) {
        log.traceEntry();

        boolean isElementNotDisplayed = false;
        try {
            driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);

            WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
            isElementNotDisplayed = driverWait.until(ExpectedConditions.invisibilityOf(element));
            if (isElementNotDisplayed) {
                return isElementNotDisplayed;
            }
        } catch (Exception e) {
            log.error("Something went wrong finding element [{}]", e.getMessage());
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        return log.traceExit(isElementNotDisplayed);
    }

    /***
     * Checks the Page Element in the DOM if it is present
     * @param elements
     * @return True if elements are present | False if element are not displayed in the DOM
     */
    public boolean areElementsPresent(List<WebElement> elements) {
        log.traceEntry();

        boolean areElementsDisplayed = false;
        try {
            driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);
            WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);

            List<WebElement> targets = driverWait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfAllElements(elements));


            log.debug("Element list size [{}]", elements.size());
            if (!targets.isEmpty()) {
                areElementsDisplayed = true;
            }

        } catch (NoSuchElementException nsee) {
            log.error("Cannot find elements [{}]", nsee.getMessage());
            Assert.fail();
        } catch (StaleElementReferenceException sere) {
            log.info("WebElement is Stale!! Retrying to find WebElement");
            WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
            List<WebElement> targets = driverWait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfAllElements(elements));


            log.debug("Element list size [{}]", elements.size());
            if (!targets.isEmpty()) {
                areElementsDisplayed = true;
            }
        } catch (Exception e) {
            log.error("Something went wrong finding element [{}]", e.getMessage());
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        return log.traceExit(areElementsDisplayed);
    }

    /***
     *
     * @param element
     * @param attribute
     * @param value
     * @return
     */
    public boolean waitForHtmlAttributeToChange(WebElement element, String attribute, String value) {
        log.traceEntry();
        boolean didAttributeChanged = false;
        try {
            if (isElementPresent(element)) {
                driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);
                WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
                log.info("Current Attribute 1 [{}] with Value of [{}]", attribute, element.getAttribute(attribute));
                didAttributeChanged = driverWait.until(ExpectedConditions.attributeToBe(element, attribute, value));
                log.info("Getting Attribute 2 [{}] with Value of [{}]", attribute, element.getAttribute(attribute));
            }
        } catch (WebDriverException wde) {
            log.error("Something went wrong [{}]", wde.getMessage());
            Assert.fail();
        } catch (Exception e) {
            log.error("Something went wrong [{}]", e.getMessage());
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        return log.traceExit(didAttributeChanged);
    }

    /***
     *
     * @param element
     * @param text
     */
    public void waitForTextToChange(WebElement element, String text) {
        log.traceEntry();
        try {
            driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);
            WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
            driverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            log.error("Something went wrong [{}]", e.toString());
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        log.traceExit();
    }
}
