package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartPage {

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


    public CartPage(WebDriver driver) {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }

    public void enterCode(String couponCode){
        couponCodeField.sendKeys(couponCode + Keys.ENTER);

    }

    public void verifyDiscount(int discount){
        float subtotal = Float.parseFloat(subtotalFromTable.getText().substring(1));
        float shipping = Float.parseFloat(shippingFromTable.getText().substring(1));
        float total = Float.parseFloat(totalFromTable.getText().substring(1));
        float subtotalMinusDiscountPlusShipping = subtotal - (subtotal*discount/100) + shipping;
        assertEquals(subtotalMinusDiscountPlusShipping, total);
    }


}
