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
    @When("I navigate to the shop")
    public void i_navigate_to_the_shop() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I am on the shop page")
    public void i_am_on_the_shop_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("I am on the cart page")
    public void i_am_on_the_cart_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("I navigate to the account page")
    public void i_navigate_to_the_account_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("log out")
    public void log_out() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("I should successfully log out")
    public void i_should_successfully_log_out() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
