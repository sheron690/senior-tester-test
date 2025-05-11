package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverFactory;

import java.time.Duration;

public class SessionTests {

    @Test
    public void testCartNotSyncedAcrossSessions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");
        WebDriver session1 = DriverFactory.createDriver();
        WebDriver session2 = DriverFactory.createDriver();

        try {
            session1.get("https://www.saucedemo.com/v1/");
            session1.findElement(By.id("user-name")).sendKeys("standard_user");
            session1.findElement(By.id("password")).sendKeys("secret_sauce");
            session1.findElement(By.id("login-button")).click();
            session1.findElement(By.cssSelector(".btn_inventory")).click();

            session2.get("https://www.saucedemo.com/v1/");
            session2.findElement(By.id("user-name")).sendKeys("standard_user");
            session2.findElement(By.id("password")).sendKeys("secret_sauce");
            session2.findElement(By.id("login-button")).click();

            WebElement cartBadge = session2.findElements(By.className("shopping_cart_badge")).stream().findFirst().orElse(null);
            Assert.assertNull(cartBadge, "Cart should not persist across sessions but it does.");
        } finally {
            session1.quit();
            session2.quit();
        }
    }
}
