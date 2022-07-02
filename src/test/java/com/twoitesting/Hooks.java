package com.twoitesting;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Hooks {

    private WebDriver driver;
    public static String baseURL = " https://www.edgewordstraining.co.uk/demo-site/";
    private SharedDictionary sharedDict; //field to use sharedDict in this class

    public Hooks(SharedDictionary sharedDict) {
        this.sharedDict = sharedDict;
    }

    @Before
    public void SetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        sharedDict.addDict("webdriver", driver);
    }

    @After
    public void TearDown(){
        driver = (WebDriver)sharedDict.readDict("webdriver");
        driver.quit();
    }
}
