package SauceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver; // تأكدنا من استخدام Edge
import org.testng.Assert;
import org.testng.annotations.*;
import java.time.Duration;

public class automationTests {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @BeforeTest
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    public void SignIn() throws InterruptedException {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Thread.sleep(2000);

    }

    @Test(priority = 2)
    public void AddItemsToCart() throws InterruptedException {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();

        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "2");
        Thread.sleep(2000);

    }

    @Test(priority = 3)
    public void GoToCart() throws InterruptedException {
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"));
        Thread.sleep(2000);

    }

    @Test(priority = 4)
    public void Checkout() throws InterruptedException {
        driver.findElement(By.id("checkout")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"));
        Thread.sleep(2000);

    }

    @Test(priority = 5)
    public void FillCheckoutData() throws InterruptedException {
        driver.findElement(By.id("first-name")).sendKeys("John");
        driver.findElement(By.id("last-name")).sendKeys("Doe");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"));
        Thread.sleep(2000);

    }

    @Test(priority = 6)
    public void Finish() throws InterruptedException {
        driver.findElement(By.id("finish")).click();

        WebElement confirmationMessage = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(confirmationMessage.getText(), "Thank you for your order!");
        Thread.sleep(2000);

    }

    @Test(priority = 7)
    public void BackHome() throws InterruptedException {
        driver.findElement(By.id("back-to-products")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        Thread.sleep(2000);

    }

    @Test(priority = 8)
    public void OpenMenu() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        
        WebElement logoutLink = driver.findElement(By.id("logout_sidebar_link"));
        Assert.assertTrue(logoutLink.isDisplayed());
        Thread.sleep(2000);

    }

    @Test(priority = 9)
    public void SignOut() throws InterruptedException {
        driver.findElement(By.id("logout_sidebar_link")).click();

        Assert.assertEquals(driver.getCurrentUrl(), baseUrl);
        Thread.sleep(2000);

    }

    @AfterTest
    public void Exit() {
        if (driver != null) {
            driver.quit();
        }
    }
}