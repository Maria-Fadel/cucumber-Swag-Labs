package com.saucedemo.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
                //driver = new ChromeDriver();
                // ChromeOptions für den Headless-Modus in CI-Umgebung konfigurieren
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless"); // Headless-Modus für CI-Umgebung
                options.addArguments("--no-sandbox"); // Wichtige Option für CI-Umgebungen
                driver = new ChromeDriver(options); // Starte ChromeDriver mit den Optionen
//
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
