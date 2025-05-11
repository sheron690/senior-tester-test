package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    // Method to create a WebDriver instance
    public static WebDriver createDriver() {
        // Set the path to the ChromeDriver executable (adjust path as necessary)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver"); // replace with your chromedriver location

        // Create and return an instance of ChromeDriver
        return new ChromeDriver();
    }
}
