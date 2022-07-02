package com.twoitesting;

import io.cucumber.java.en.*;
import com.twoitesting.Hooks.*;
import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import com.twoitesting.pompages.*;

public class StepDefinitions {

    private WebDriver driver;
    String baseURL;

    private SharedDictionary sharedDict; // Field for shared dictionary to use in this class

    public StepDefinitions(SharedDictionary sharedDict) { //PicoContainer will instantiate sharedDict for us
        this.sharedDict = sharedDict; //Put the passed instance of sharedDict in the field.
        driver = (WebDriver) sharedDict.readDict("webdriver");
        this.baseURL = Hooks.baseURL;
    }


    @Given("I am on the account page")
    public void i_am_on_the_account_page() {
        AccountPage accountPage = new AccountPage(sharedDict);
        accountPage.loadAccountPage();
    }

    @When("I submit the valid username {string} and password {string}")
    public void i_enter_the_valid_username_and_password(String username, String password) {
        AccountPage accountPage = new AccountPage(sharedDict);
        accountPage.login(username, password);
    }

    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        AccountPage accountPage = new AccountPage(sharedDict);
        accountPage.loadAccountPage();
        accountPage.verifyLogin();
    }

    @Given("I have an item in my cart")
    public void i_have_an_item_in_my_cart() {
        AccountPage accountPage = new AccountPage(sharedDict);
        accountPage.navigateToShop();
        ShopPage shopPage = new ShopPage(sharedDict);
        shopPage.selectRandomProduct();
        shopPage.viewCart();
    }

    @When("I apply the coupon code {string}")
    public void i_apply_the_coupon_code(String couponCode) {
        CartPage cartPage = new CartPage(sharedDict);
        cartPage.enterCode(couponCode);
    }

    @Then("I should receive a {int}% discount")
    public void i_should_receive_a_discount(Integer discount) {
        CartPage cartPage = new CartPage(sharedDict);
        cartPage.verifyDiscount(discount);
        cartPage.clearCart();
        cartPage.navigateToAccount();
        AccountPage accountPage = new AccountPage(sharedDict);
        accountPage.logout();
    }

    @When("I use the valid first name {string}, last name {string}, company name {string}, street address {string}, address line two {string}, city {string}, county {string}, postcode {string}, phone {string} to go through checkout")
    public void i_use_the_valid_first_name_last_name_company_name_street_address_address_line_city_county_phone_to_go_through_checkout(String firstName, String lastName, String company, String streetAddress, String addressLine2, String city, String county, String postcode, String phone){

        CartPage cartPage = new CartPage(sharedDict);
        cartPage.proceedToCheckout();
        CheckoutPage checkoutPage = new CheckoutPage(sharedDict);
        checkoutPage.fillDetails(firstName, lastName, company, streetAddress, addressLine2, city, county, postcode, phone);
        checkoutPage.selectPayByCheque();
        checkoutPage.placeOrder();
    }

    @Then("I should be able to find my order")
    public void i_should_be_able_to_find_my_order() {
        OrderReceivedPage orderReceivedPage = new OrderReceivedPage(sharedDict);
        orderReceivedPage.captureOrderNumber();
        orderReceivedPage.navigateToAccount();
        AccountPage accountPage = new AccountPage(sharedDict);
        accountPage.viewOrders();
        MyOrdersPage myOrdersPage = new MyOrdersPage(sharedDict);
        myOrdersPage.verifyOrder();
        myOrdersPage.logout();
    }


}
