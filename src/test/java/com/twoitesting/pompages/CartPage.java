package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import com.twoitesting.SharedDictionary;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {

    private SharedDictionary sharedDict;
    String baseURL;
    WebDriver driver;

    @FindBy(id = "coupon_code")
    WebElement couponCodeField;

    @FindBy(css = "td[data-title=\"Subtotal\"]")
    WebElement subtotalFromTable;

    @FindBy(css = "#post-5 > div > div > div > div > table > tbody > tr.shipping > td > span") //find shipping cost
    WebElement shippingFromTable;

    @FindBy(css = "#post-5 > div > div > div > div > table > tbody > tr.order-total > td > strong > span") //find total cost
    WebElement totalFromTable;


    public CartPage(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict; //Put the passed instance of sharedDict in the field.
        driver = (WebDriver) sharedDict.readDict("webdriver");
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }

    public void enterCode(String couponCode) {
        couponCodeField.sendKeys(couponCode + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-5 > div > div > div > div > table > tbody > tr.cart-discount.coupon-edgewords")));

    }

    public void verifyDiscount(int discount) {
        float subtotal = Float.parseFloat(subtotalFromTable.getText().substring(1));
        float shipping = Float.parseFloat(shippingFromTable.getText().substring(1));
        float total = Float.parseFloat(totalFromTable.getText().substring(1));
        float subtotalMinusDiscount = subtotal - (subtotal * discount / 100); //subtotal - discount %
        float subtotalMinusDiscountPlusShipping = subtotalMinusDiscount + shipping;
        subtotalMinusDiscountPlusShipping = (float) (Math.round(subtotalMinusDiscountPlusShipping * 100.0) / 100.0); //Rounds result to 2DP
        assertEquals(subtotalMinusDiscountPlusShipping, total);
    }

    public void clearCart(){
        List<WebElement> list = driver.findElements(By.xpath("//*[@type='number']"));
        for (WebElement el : list) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(el));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].value='0'", el);
            if ( el == list.get(list.size()-1)) { //If element is the last one to remove
                el.sendKeys(Keys.ENTER);//Necessary as Update Cart Button is disabled even with javascript clicks
            }
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-5 > div > div.woocommerce > p.cart-empty")));
    }

    public void navigateToAccount() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", driver.findElement(By.linkText("My account")));

    }


}
