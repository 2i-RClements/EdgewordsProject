package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import com.twoitesting.SharedDictionary;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private SharedDictionary sharedDict;

    String baseURL;

    WebDriver driver;

    @FindBy(id = "billing_first_name")
    WebElement firstNameField;

    @FindBy(id = "billing_last_name")
    WebElement lastNameField;

    @FindBy(id = "billing_company")
    WebElement companyField;

    @FindBy(id = "billing_address_1")
    WebElement streetAddressField;

    @FindBy(id = "billing_address_2")
    WebElement addressLine2Field;

    @FindBy(id = "billing_city")
    WebElement cityField;

    @FindBy(id = "billing_state")
    WebElement countyField;

    @FindBy(id = "billing_postcode")
    WebElement postcodeField;

    @FindBy(id = "billing_phone")
    WebElement phoneField;

    @FindBy(id = "payment_method_cheque")
    WebElement chequePaymentInput;

    @FindBy(id = "place_order")
    WebElement placeOrderButton;


    public CheckoutPage(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict; //Put the passed instance of sharedDict in the field.
        driver = (WebDriver) sharedDict.readDict("webdriver");
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }

    public void fillDetails(String firstName, String lastName, String company, String streetAddress, String addressLine2, String city, String county, String postcode, String phone){
        firstNameField.clear(); //clear fields before sending information to deal with autofill
        firstNameField.sendKeys(firstName);
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
        companyField.clear();
        companyField.sendKeys(company);
        streetAddressField.clear();
        streetAddressField.sendKeys(streetAddress);
        addressLine2Field.clear();
        addressLine2Field.sendKeys(addressLine2);
        cityField.clear();
        cityField.sendKeys(city);
        countyField.clear();
        countyField.sendKeys(county);
        postcodeField.clear();
        postcodeField.sendKeys(postcode);
        phoneField.clear();
        phoneField.sendKeys(phone);
    }

    public void selectPayByCheque() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", chequePaymentInput);
    }

    public void placeOrder(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", placeOrderButton);
    }
}
