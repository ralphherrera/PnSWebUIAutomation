package com.pnswebuiautomation.utilities;

import com.pnswebuiautomation.constants.CommonConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebActionsUtility {

    private static final Logger log = LogManager.getLogger(WebActionsUtility.class);
    private static final int ZERO_TIMEOUT = 0;
    private final static Duration EXPLICIT_WAIT_TIMEOUT = Duration.ofSeconds(FileMgmtUtil.getNumberValue(CommonConstants.EXPLICIT_TIMEOUT));

    private WebDriver driver;
    private WebWaitsUtility webWaitsutil;

    public WebDriver getDriver() {
        return driver;
    }

    public WebActionsUtility(WebDriver driver, WebWaitsUtility webWaitsutil) {
        this.driver = driver;
        this.webWaitsutil = webWaitsutil;
    }

    /***
     *
     * @param url
     */
    public void navigateToPage(String url) {
        log.traceEntry("Opening site: [{}]", url);
        try {
            driver.get(url);
            webWaitsutil.waitForPageToLoad();
        } catch (Exception e) {
            log.error("Something went wrong ", e.getMessage());
            Assert.fail();
        }
        log.traceExit();
    }

    /***
     * Gets the text of the specified element if present
     * @param element
     */
    public String getElementText(WebElement element) {
        log.traceEntry();
        String placeholder = "";
        try {
            if (webWaitsutil.isElementPresent(element)) {
                highlightElement(element);
                placeholder = element.getText();
                removeHighlightedElement(element);
            }
        } catch (Exception e) {
            log.error("Unable to get element text! [{}]", e.getMessage());
        }
        return log.traceExit(placeholder);
    }

    /***
     * Clicks the specified element if present and clickable
     * @param element
     */
    public void clickElement(String strElement, WebElement element) {
        log.traceEntry();
        try {
            if (webWaitsutil.isElementPresent(element) && element.isEnabled()) {
                log.info("Clicking element: [{}]", strElement);
                highlightElement(element);
                element.click();
            } else {
                driver.manage().timeouts().implicitlyWait(ZERO_TIMEOUT, TimeUnit.SECONDS);
                WebDriverWait driverWait = new WebDriverWait(driver, EXPLICIT_WAIT_TIMEOUT);
                driverWait.until(ExpectedConditions.elementToBeClickable(element));
                log.info("Clicking element: [{}]", strElement);
                highlightElement(element);
                element.click();
            }
        } catch (Exception e) {
            log.error("Unable to click element! [{}] -- [{}]", strElement, e.getMessage());
        } finally {
            driver.manage().timeouts().implicitlyWait(FileMgmtUtil.getNumberValue(CommonConstants.DEFAULT_TIMEOUT), TimeUnit.SECONDS);
        }
        log.traceExit();
    }

    /***
     *
     * @param elements
     * @param key
     */
    public void clickElementFromList(List<WebElement> elements, String key) {
        log.traceEntry("Clicking [{}] from list", key);
        try {
            if (webWaitsutil.areElementsPresent(elements)) {
                for (WebElement element : elements) {
                    if (element.getText().equalsIgnoreCase(key.toLowerCase())) {
                        highlightElement(element);
                        clickElement(key, element);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            log.error("Unable to click element! [{}]", e.getMessage());
        }
        log.traceExit();
    }

    /***
     *
     * @param element
     */
    public void jsClickElement(WebElement element) {
        log.traceEntry("Clicking element [{}]", element.toString());
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        highlightElement(element);
        executor.executeScript("arguments[0].click();", element);
        log.traceExit();
    }

    /***
     *
     * @param element
     * @param value
     */
    public void enterTextToField(WebElement element, String value) {
        log.traceEntry();
        try {
            if (value != null) {
                if (webWaitsutil.isElementPresent(element) && element.isEnabled()) {
                    log.info("Entering text [{}] to field [{}]", value, element.toString());
                    highlightElement(element);
                    element.clear();
                    element.sendKeys(value);
                }
            } else {
                Assert.fail("Input text is null");
            }

        } catch (Exception e) {
            log.error("Unable to input text to element! [{}]", e.getMessage());
        }
        log.traceExit();
    }

    /**
     * WebDriver Utility that scrolls page into element identified as WebElement.
     * @param element
     */
    public void scrollIntoView(WebElement element) {
        log.traceEntry();
        try {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            highlightElement(element);
            executor.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            log.error("Something went wrong [{}]", e.getMessage());
        }
        log.traceExit();
    }

    /**
     * WebAction Utility method to hover over an element
     * @param element WebElement to hovered on
     */
    public void hoverMouseOverElement(WebElement element) {
        log.traceEntry();
        try {
            Actions actions = new Actions(driver);
            if (webWaitsutil.isElementPresent(element)) {
                highlightElement(element);
                actions.moveToElement(element).perform();
            }
        } catch (Exception e) {
            log.error("Something went wrong [{}]", e.getMessage());
        }
        log.traceExit();
    }

    /**
     * WebDriver utility to switch to an iframe
     * @param iframe iframe in the dom
     */
    public void switchToIFrame(WebElement iframe) {
        log.traceEntry();
        try {
            if (webWaitsutil.isElementPresent(iframe)) {
                driver.switchTo().frame(iframe);
            }
        } catch (Exception e) {
            log.error("Something went wrong [{}]", e.getMessage());
        }
        log.traceExit();
    }

    /**
     * Highlight Element
     *
     * @param webElement
     */
    private void highlightElement(WebElement webElement) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='2px solid red'", webElement);
        } catch (Exception e) {
            log.error("Something went wrong {}", e);
        }
    }

    /**
     * Remove highlight element
     *
     * @param webElement
     */
    private void removeHighlightedElement(WebElement webElement) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.border='none'", webElement);
        } catch (Exception e) {
            log.error("Something went wrong {}", e);
        }
    }
}
