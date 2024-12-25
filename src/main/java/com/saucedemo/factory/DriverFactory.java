package com.saucedemo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {
    private final static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static  WebDriver initDriver(){
        WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        switch (browser) {
            case "CHROME" ->{
                driver = new ChromeDriver();
            }
            case "FIREFOX" ->{
                driver = new FirefoxDriver();
            }
            case "SAFARI" ->{
                driver = new SafariDriver();
            }
            default -> {
                throw new RuntimeException("Browser ist nicht verfügbar");
            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        DriverFactory.driver.set(driver);
        return driver;
    }
    public static WebDriver getDriver(){

        return driver.get();
    }
}
