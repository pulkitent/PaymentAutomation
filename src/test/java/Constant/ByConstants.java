package Constant;

import org.openqa.selenium.By;

public class ByConstants {
    public static final By TITLE = By.xpath("//div[@class='TITLE']");
    public static final By BUY_NOW_BUTTON = By.xpath("//*[@class='btn buy']");
    public static final By CHECKOUT_BUTTON = By.xpath("//*[@class='cart-CHECKOUT_BUTTON']");
    public static final By FIRST_FRAME = By.xpath("//iframe[@id='snap-midtrans']");
    public static final By CONTINUE_BUTTON = By.xpath("//*[@id=\"application\"]/div[1]/a");
    public static final By CREDIT_CARD_PAY_BUTTON = By.xpath("//a[@class='list with-promo']");
    public static final By CARD_NUMBER_INPUT = By.xpath("//*[@class='card-container']/div[1]/input");
    public static final By EXPIRY_DATE_INPUT = By.xpath("//*[@class='card-container']/div[2]/input");
    public static final By CVV_INPUT = By.xpath("//*[@class='card-container']/div[3]/input");
    public static final By PAY_NOW_BUTTON = By.xpath("//*[@class='button-main-content']");
    public static final By PASSWORD_INPUT = By.xpath("//*[@id='PaRes']");
    public static final By SECOND_FRAME = By.xpath("//iframe[starts-with(@src,'https://api.sandbox.veritrans.co.id')]");
    public static final By OK_BUTTON = By.xpath("//*[@type='submit']");
    public static final By ORDER_SUMMARY_TEXT = By.xpath("//*[@class='text-page-TITLE-content']");
    public static final By SELECT_PAY_TEXT = By.xpath("//*[@class='text-page-TITLE-content']");
    //public final By PASSWORD_INPUT=By.xpath("//form[@class='form-horizontal']/div[5]/div/input");
}
