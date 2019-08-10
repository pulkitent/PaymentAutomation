package com.gojeck.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomeScreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Homepage extends base {
    public static Logger log= LogManager.getLogger(base.class.getName());
    @Test(dataProvider = "gatData")
    public void basePageNavigation(String cardNumber,String expiryDate,String cvv,String password) throws IOException {
        driver=initializeDriver();
        log.info("Driver is initialized");
        driver.get(properties.getProperty("url"));
//        driver.get("https://demo.midtrans.com/");
        driver.manage().window().maximize();
        HomeScreen homeScreen=new HomeScreen(driver);
        String title=homeScreen.gettitle().getText();
        Assert.assertEquals(title,"Midtrans Pillow");
        Assert.assertTrue(homeScreen.getbuynow().isDisplayed());


        homeScreen.getbuynow().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(homeScreen.getcheckout().isDisplayed());
        homeScreen.getcheckout().click();
        driver.switchTo().frame(homeScreen.getFrame());
        Assert.assertTrue(homeScreen.getorderSummary().isDisplayed());
        Assert.assertTrue(homeScreen.docontinue().isDisplayed());
        homeScreen.docontinue().click();
        Assert.assertEquals(homeScreen.getselectPayText().getText(),"Select Payment");
        homeScreen.doCreditPay().click();
        homeScreen.getCardNumber().sendKeys(cardNumber);
        homeScreen.getExpiryDate().sendKeys(expiryDate);
        homeScreen.getCVV().sendKeys(cvv);
        Assert.assertTrue(homeScreen.doPayNow().isDisplayed());
        homeScreen.doPayNow().click();
        driver.switchTo().frame(homeScreen.getFrame2());
        homeScreen.getPassword().sendKeys(password);
        homeScreen.getOk().click();
    }

    @AfterTest

    public void tearDown(){
        driver.close();

    }

    @DataProvider
    public Object[][] gatData()
    {
        Object[][] data=new Object[2][4];
        data[0][0]="4811 1111 11111114";
        data[0][1]="0220";
        data[0][2]="123";
        data[0][3]="112233";
        data[1][0]="4911 1111 11111113";
        data[1][1]="0220";
        data[1][2]="123";
        data[1][3]="112233";
        return data;
    }

}
