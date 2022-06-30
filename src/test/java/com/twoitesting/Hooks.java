package com.twoitesting;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    static WebDriver driver;
    public static final String baseURL = " https://www.edgewordstraining.co.uk/demo-site/";

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void TearDown() {
        driver.quit();
    }
}
