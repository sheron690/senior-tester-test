package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Method to create a WebDriver instance
    public static WebDriver createDriver(ChromeOptions options) {
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    return new ChromeDriver(options);
    }
}
