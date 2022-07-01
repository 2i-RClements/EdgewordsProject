package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    String baseURL;
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;

    public AccountPage(WebDriver driver) {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }


    public void verifyPage(){
        driver.get(baseURL + "my-account/");
        driver.findElement(By.xpath("//*[@id=\"post-7\"]/header/h1")); //My account h1
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void verifyLogin(){
        driver.findElement(By.linkText("Logout")); //If logout button is visible user should be logged in.
    }
}
