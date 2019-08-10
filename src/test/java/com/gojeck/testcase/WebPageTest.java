package com.gojeck.testcase;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.WebPageSimulator;

import java.io.IOException;
import java.util.Properties;

import static Constant.ByConstants.*;

public class WebPageTest {
    private WebPageSimulator webPageSimulator;

    private WebDriver webDriver;

    @Test
    void shouldDisplayTitleAndBuyNowButton() {
        String title = webPageSimulator.fetchElementText(TITLE);

        Assert.assertEquals(title, "Midtrans Pillow");
        Assert.assertTrue(webPageSimulator.isElementDisplayed(BUY_NOW_BUTTON));
    }

    @Test
    void shouldDisplayCheckoutButtonWhenBuyNowButtonClicked() {
        webPageSimulator.clickOnElement(BUY_NOW_BUTTON);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(webPageSimulator.isElementDisplayed(CHECKOUT_BUTTON));
    }

    @Test
    void shouldDisplayOrderSummaryAndContinueButtonWhenCheckoutButtonClicked() {
        webPageSimulator.clickOnElement(CHECKOUT_BUTTON);
        webDriver.switchTo().frame(webPageSimulator.getFrameElement(FIRST_FRAME));

        Assert.assertTrue(webPageSimulator.isElementDisplayed(ORDER_SUMMARY_TEXT));
        Assert.assertTrue(webPageSimulator.isElementDisplayed(CONTINUE_BUTTON));
    }

    @Test
    void shouldDisplaySelectPaymentTextWhenContinueButtonClicked() {
        webPageSimulator.clickOnElement(CONTINUE_BUTTON);

        Assert.assertEquals(webPageSimulator.fetchElementText(SELECT_PAY_TEXT), "Select Payment");
    }

    @Test
    void shouldDisplayPayButtonWhenAllPaymentDetailsGiven() {
        String cardNumber = "";
        String expiryDate = "";
        String CVV = "";
        webPageSimulator.clickOnElement(CREDIT_CARD_PAY_BUTTON);
        webPageSimulator.provideInputToElement(CARD_NUMBER_INPUT, cardNumber);
        webPageSimulator.provideInputToElement(EXPIRY_DATE_INPUT, expiryDate);
        webPageSimulator.provideInputToElement(CVV_INPUT, CVV);

        Assert.assertTrue(webPageSimulator.isElementDisplayed(PAY_NOW_BUTTON));
    }

    @Test()
    public void shouldTestPaymentFlow() {
        String password = "";
        webPageSimulator.clickOnElement(PAY_NOW_BUTTON);
        webDriver.switchTo().frame(webPageSimulator.getFrameElement(SECOND_FRAME));
        webPageSimulator.provideInputToElement(PASSWORD_INPUT, password);
        webPageSimulator.clickOnElement(OK_BUTTON);

        //Add Some Assert
    }

    @BeforeClass
    private void testSetup() throws IOException {
        webDriver = WebDriverInitializer.initialize();

        Properties properties = new Properties();

        webDriver.get(properties.getProperty("url"));
        webDriver.get("https://demo.midtrans.com/");
        webDriver.manage().window().maximize();

        webPageSimulator = new WebPageSimulator(webDriver);
    }

    @AfterClass
    private void tearDown() {
        webDriver.close();
        webDriver.quit();
    }
}