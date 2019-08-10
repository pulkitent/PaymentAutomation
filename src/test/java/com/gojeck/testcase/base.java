package com.gojeck.testcase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream("/home/administrator/repo/Midtrans/src/main/resources/data.properties");
        properties.load(fileInputStream);
        String browserName=properties.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","/home/administrator/chromedriver");
            driver=new ChromeDriver();
        }

        else if(browserName.equals("firefox")){
            driver=new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
