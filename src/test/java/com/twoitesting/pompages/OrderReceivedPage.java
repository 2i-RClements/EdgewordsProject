package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import com.twoitesting.SharedDictionary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderReceivedPage {

    private SharedDictionary sharedDict;
    String baseURL;
    WebDriver driver;


    public OrderReceivedPage(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict; //Put the passed instance of sharedDict in the field.
        driver = (WebDriver) sharedDict.readDict("webdriver");
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }

    public void captureOrderNumber(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#post-6 > div > div > div > ul > li.woocommerce-order-overview__order.order > strong")));
        String orderNumber =  driver.findElement(By.cssSelector("#post-6 > div > div > div > ul > li.woocommerce-order-overview__order.order > strong")).getText();
        sharedDict.addDict("order number", orderNumber);
        System.out.println("Order Number: " + orderNumber);
    }

    public void navigateToAccount() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", driver.findElement(By.linkText("My account")));

    }

}