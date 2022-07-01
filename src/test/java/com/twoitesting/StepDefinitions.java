package com.twoitesting;

import io.cucumber.java.en.*;
import com.twoitesting.Hooks.*;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.WebDriver;
import com.twoitesting.pompages.*;

public class StepDefinitions {

    WebDriver driver;
    String baseURL;


    public StepDefinitions() {
        this.driver = Hooks.driver;
        this.baseURL = Hooks.baseURL;
    }

    @Given("I am on the account page")
    public void i_am_on_the_account_page() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.verifyPage();
    }
    @When("I submit the valid username {string} and password {string}")
    public void i_enter_the_valid_username_and_password(String username, String password) {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.login(username, password);
    }
    @Then("I should be logged in")
    public void i_should_be_logged_in() {
        AccountPage accountPage = new AccountPage(driver);
        accountPage.verifyLogin();
    }

    @Given("I have an item in my cart")
    public void i_have_an_item_in_my_cart(){
        ShopPage shopPage = new ShopPage(driver);
        shopPage.verifyPage();
        shopPage.selectRandomProduct();
        shopPage.viewCart();
    }
    @When("I apply the coupon code {string}")
    public void i_apply_the_coupon_code(String couponCode) {
        CartPage cartPage = new CartPage(driver);
        cartPage.enterCode(couponCode);
    }
    @Then("I should receive a {int}% discount")
    public void i_should_receive_a_discount(Integer discount){
        CartPage cartPage = new CartPage(driver);
        cartPage.verifyDiscount(discount);
        //TODO remove all items from cart and logout
    }


}
