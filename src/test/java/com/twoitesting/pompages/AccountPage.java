package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import com.twoitesting.SharedDictionary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {


    private SharedDictionary sharedDict; // Field for shared dictionary to use in this class

    String baseURL;
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(name = "login")
    WebElement loginButton;

    public AccountPage(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict; //Put the passed instance of sharedDict in the field.
        driver = (WebDriver) sharedDict.readDict("webdriver");
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }


    public void loadAccountPage(){
        driver.get(baseURL + "my-account/");

    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void verifyLogin(){
        driver.findElement(By.linkText("Logout")); //If logout button is visible user should be logged in.
    }

    public void navigateToShop(){
        driver.findElement(By.linkText("Shop")).click();
    }

    public void logout(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", driver.findElement(By.linkText("Logout")));
    }
}
