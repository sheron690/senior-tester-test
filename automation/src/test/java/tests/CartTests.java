package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.DriverFactory;

import java.time.Duration;

public class CartTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        driver = DriverFactory.createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginStandardUser();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }

    private void loginStandardUser() {
        driver.get("https://www.saucedemo.com/v1/");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        // Wait for products page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));
    }

    @Test
    public void testAddToCartFeedback() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_inventory"))).click();

        WebElement cartBadge = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("shopping_cart_badge")));
        Assert.assertTrue(cartBadge.isDisplayed(), "Cart badge not displayed after adding item.");
    }

    @Test
    public void testEmptyCartCheckoutShouldFail() {
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout"))).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("first-name"))).sendKeys("Test");
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");

        driver.findElement(By.cssSelector(".cart_button")).click();

        try {
            WebElement checkoutSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("summary_total_label")));
            Assert.assertFalse(checkoutSummary.getText().isEmpty(), "Unexpected behavior: empty cart should not allow full checkout.");
        } catch (TimeoutException e) {
            Assert.fail("Expected checkout summary but it was not present. Possibly blocked by empty cart validation.");
        }
    }
}
