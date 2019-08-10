package com.gojeck.testcase;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomeScreen;

import java.io.IOException;

public class Homepage extends base {
    @Test(dataProvider = "gatData")
    public void basePageNavigation(String cardNumber,String expiryDate,String cvv,String password) throws IOException {
        driver=initializeDriver();
        driver.get("https://demo.midtrans.com/");
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
        homeScreen.docontinue().click();
        homeScreen.doCreditPay().click();
        homeScreen.getCardNumber().sendKeys(cardNumber);
        homeScreen.getExpiryDate().sendKeys(expiryDate);
        homeScreen.getCVV().sendKeys(cvv);
        homeScreen.doPayNow().click();
        driver.switchTo().frame(homeScreen.getFrame2());
        homeScreen.getPassword().sendKeys(password);
        homeScreen.getOk().click();
        driver.quit();

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
