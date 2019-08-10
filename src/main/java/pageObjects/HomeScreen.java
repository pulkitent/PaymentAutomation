package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen {
    public WebDriver driver;
    By title= By.xpath("//div[@class='title']");
    By buynow=By.xpath("//*[@class='btn buy']");
    By checkout=By.xpath("//*[@class='cart-checkout']");
    By frame=By.xpath("//iframe[@id='snap-midtrans']");
    By continuee=By.xpath("//*[@id=\"application\"]/div[1]/a");
    By creditcardpay=By.xpath("//a[@class='list with-promo']");
    By cardnumber=By.xpath("//*[@class='card-container']/div[1]/input");
    By expirydate=By.xpath("//*[@class='card-container']/div[2]/input");
    By cvv=By.xpath("//*[@class='card-container']/div[3]/input");
    By paynow=By.xpath("//*[@class='button-main-content']");
    By password=By.xpath("//*[@id='PaRes']");
    By insideframe2=By.xpath("//iframe[starts-with(@src,'https://api.sandbox.veritrans.co.id')]");
    By ok=By.xpath("//*[@type='submit']");
    By ordersummary=By.xpath("//*[@class='text-page-title-content']");

//    By password=By.xpath("//form[@class='form-horizontal']/div[5]/div/input");

    public HomeScreen(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver=driver;

    }

    public WebElement getbuynow()
    {
        return driver.findElement(buynow);
    }

    public WebElement getcheckout(){
        return driver.findElement(checkout);
    }

    public WebElement docontinue(){
        return driver.findElement(continuee);
    }

    public WebElement getFrame(){
        return driver.findElement(frame);
    }

    public WebElement doCreditPay(){
        return driver.findElement(creditcardpay);
    }

    public WebElement getCardNumber(){
        return  driver.findElement(cardnumber);
    }


    public WebElement getExpiryDate(){
        return  driver.findElement(expirydate);
    }


    public WebElement getCVV(){
        return  driver.findElement(cvv);
    }

    public WebElement doPayNow(){
        return  driver.findElement(paynow);
    }

    public WebElement getPassword(){

        return driver.findElement(password);
    }

    public WebElement getFrame2() {
        return driver.findElement(insideframe2);
    }

    public WebElement getOk() {
        return driver.findElement(ok);
    }

    public WebElement gettitle(){
        return driver.findElement(title);
    }
    public WebElement getorderSummary(){
        return driver.findElement(ordersummary);
    }

}
