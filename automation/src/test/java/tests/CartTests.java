package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class CartTests {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginStandardUser();
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String filename = "screenshot-" + result.getName() + ".png";
            File dest = new File("target/surefire-reports/screenshots/" + filename);
            dest.getParentFile().mkdirs(); // Ensure the directory exists
            try {
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Screenshot saved: " + dest.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Failed to save screenshot: " + e.getMessage());
            }
        }
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
    public void testNoFeedbackAfterAddToCart() {
        System.out.println("Clicking Add to Cart button...");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn_inventory"))).click();
    
        System.out.println("Checking that no feedback badge appears...");
        boolean badgeVisible;
        try {
            // Small wait just in case the badge would appear
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".shopping_cart_badge")));
            badgeVisible = true;
        } catch (TimeoutException e) {
            badgeVisible = false;
        }
    
        Assert.assertFalse(badgeVisible, "Unexpected feedback: badge appeared after adding to cart.");
    }

   /*@Test
    public void testEmptyCartCheckoutShouldSucceed() {
        System.out.println("Navigating to cart...");
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link"))).click();
    
        System.out.println("Waiting for checkout button...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement checkoutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.btn_action.checkout_button")));
        checkoutBtn.click();
    
        System.out.println("Filling out form...");
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"), "Did not reach checkout overview.");
        wait.until(ExpectedConditions.urlContains("checkout-step-one.html"));

        // Wait for form to be ready
        WebElement firstName = wait.until(ExpectedConditions.elementToBeClickable(By.id("first-name")));
        firstName.sendKeys("Test");

        // Fill other fields
        driver.findElement(By.id("last-name")).sendKeys("User");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
    
        System.out.println("Submitting form...");
        driver.findElement(By.cssSelector(".cart_button")).click();
    
        System.out.println("Waiting for summary_info...");
        WebElement summaryInfo = wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("summary_info"))
        );
    
        Assert.assertTrue(summaryInfo.isDisplayed(), "Checkout overview not displayed.");
    }*/
}
