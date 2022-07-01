package com.twoitesting.pompages;

import com.twoitesting.Hooks;
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
    String baseURL;
    WebDriver driver;



    public ShopPage(WebDriver driver) {
        this.driver = Hooks.driver;
        PageFactory.initElements(driver, this);
        this.baseURL = Hooks.baseURL;
    }

    public void verifyPage(){
        driver.get(baseURL + "shop/");
        System.out.println("I am at the shop");
        driver.findElement(By.xpath("//*[@id=\"main\"]/header/h1")); //My account h1
        System.out.println("I have seen h1");
    }

    public void selectRandomProduct() throws InterruptedException { //Add a random product to cart
        List<WebElement> allProducts = driver.findElements(By.linkText("Add to cart"));
        System.out.println(allProducts.size());
        Random rand = new Random();
        int randomProduct = rand.nextInt(allProducts.size());
        WebElement chosenProduct = allProducts.get(randomProduct);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", chosenProduct);

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.elementToBeClickable(chosenProduct)).click();
//        Thread.sleep(10000);
//        allProducts.get(randomProduct).click();

        System.out.println("I have chosen a product");
    }

    public void viewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("View cart")));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement cartButton = driver.findElement(By.linkText("View cart"));
        jse.executeScript("arguments[0].click()", cartButton);
        driver.findElement(By.xpath("//*[@id=\"post-5\"]/header/h1"));
        System.out.println("I am on the cart");
    }
}
