package com.twoitesting;

import io.cucumber.java.en.*;
import com.twoitesting.Hooks.*;
import org.openqa.selenium.WebDriver;
import com.twoitesting.pompages.*;

public class StepDefinitions {

    WebDriver driver;
    String baseURL;


    public StepDefinitions(Hooks hooks) {
        this.driver = hooks.driver;
        this.baseURL = hooks.baseURL;
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
    public void i_have_an_item_in_my_cart() throws InterruptedException {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.verifyPage();
        shopPage.selectRandomProduct();
        shopPage.viewCart();
    }
    @When("I apply the discount code {string}")
    public void i_apply_the_discount_code(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should receive a {int}% discount")
    public void i_should_receive_a_discount(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
