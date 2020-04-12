package com.pnswebuiautomation.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserManager {

    private static final Logger log = LogManager.getLogger(BrowserManager.class);

    public BrowserManager() {

    }

    public WebDriver getBrowserWebDriver(String key) {
        WebDriver driver = null;
        log.info("Opening browser [{}]", key);
        switch (key) {
            case "Chrome":
                driver = setUpChromeDriver();
                break;
            case "Firefox":
                driver = setUpGeckoDriver();
                break;
            case "IE":
                driver = setUpIEDriver();
                break;
            default:
                Assert.fail("Invalid browser name in config.properties: " + key);
        }
        return driver;
    }

    private ChromeDriver setUpChromeDriver() {
        System.setProperty("webdriver.chrome.driver", FileMgmtUtility.getPropertyValue("local.chrome.driver.path"));
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--headless", "--disable-gpu", "--window-size=1920,1080","--ignore-certificate-errors");
        chromeOptions.addArguments("--ignore-certificate-errors");
        return new ChromeDriver(chromeOptions);
    }

    private FirefoxDriver setUpGeckoDriver() {
        System.setProperty("webdriver.gecko.driver", FileMgmtUtility.getPropertyValue("local.firefox.driver.path"));
        return new FirefoxDriver();
    }

    private InternetExplorerDriver setUpIEDriver() {
        System.setProperty("webdriver.ie.driver", FileMgmtUtility.getPropertyValue("local.ie.driver.path"));
        return new InternetExplorerDriver();
    }

}