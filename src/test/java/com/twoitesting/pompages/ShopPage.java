package com.twoitesting.pompages;

import com.twoitesting.Hooks;
import com.twoitesting.SharedDictionary;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ShopPage {

    private SharedDictionary sharedDict;
    String baseURL;
    WebDriver driver;



    public ShopPage(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict; //Put the passed instance of sharedDict in the field.
        driver = (WebDriver) sharedDict.readDict("webdriver");
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }


    public void selectRandomProduct() { //Add a random product to cart
        List<WebElement> allProducts = driver.findElements(By.linkText("Add to cart"));
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        WebElement chosenProduct = allProducts.get(randomProduct);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", chosenProduct);
    }

    public void viewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View cart")));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement cartButton = driver.findElement(By.linkText("View cart"));
        jse.executeScript("arguments[0].click()", cartButton);
        driver.findElement(By.xpath("//*[@id=\"post-5\"]/header/h1"));
    }
}
