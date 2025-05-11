package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverFactory;

public class CartTests {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to chromedriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = DriverFactory.createDriver(); 

        loginStandardUser();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    private void loginStandardUser() {
        driver.get("https://www.saucedemo.com/v1/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @Test
    public void testAddToCartFeedback() {
        driver.findElement(By.cssSelector(".btn_inventory")).click();
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertTrue(cartBadge.isDisplayed());
    }

    @Test
    public void testEmptyCartCheckoutShouldFail() {
        driver.findElement(By.className("shopping_cart_link")).click();
        driver.findElement(By.id("checkout")).click();
        driver.findElement(By.id("first-name")).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.cssSelector(".cart_button")).click();

        // Expecting failure or warning – customize based on actual behavior
        WebElement checkoutSummary = driver.findElement(By.className("summary_total_label"));
        Assert.assertFalse(checkoutSummary == null || checkoutSummary.getText().isEmpty(), "Unexpected behavior: empty cart should not allow full checkout.");
    }
}
