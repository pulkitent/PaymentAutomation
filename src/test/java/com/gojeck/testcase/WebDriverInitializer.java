package com.gojeck.testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static Constant.StringConstants.*;

class WebDriverInitializer {
    private final static Logger LOGGER = LogManager.getLogger(WebDriverInitializer.class);

    static WebDriver initialize() throws IOException {
        FileInputStream fileStream = new FileInputStream(PROPERTIES_FILE_PATH);

        Properties properties = new Properties();
        properties.load(fileStream);

        WebDriver webDriver;

        String browser = properties.getProperty(BROWSER);
        switch (browser) {
            case CHROME:
                System.setProperty(WEB_DRIVER_CHROME_DRIVER, CHROME_DRIVER_PATH);
                webDriver = new ChromeDriver();
                break;
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case INTERNET_EXPLORER:
                webDriver = new InternetExplorerDriver();
                break;
            default:
                webDriver = new FirefoxDriver();
                break;
        }

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        LOGGER.info("WebDriverInitializer is initialized successfully");

        return webDriver;
    }
}