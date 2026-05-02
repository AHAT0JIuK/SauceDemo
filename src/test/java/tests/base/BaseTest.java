package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.*;
import pages.*;
import utils.TestListener;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ItemPage itemPage;
    protected CartPage cartPage;
    protected CheckoutPage checkoutPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected FinishPage finishPage;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            // объявляю настройки для тестового браузера
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            // объявляю тестовый браузер
            driver = new ChromeDriver(options);
            // неявное ожидание
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        } else if (browser.equalsIgnoreCase("edge")) {
            // объявляю настройки для тестового браузера
            EdgeOptions options = new EdgeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            options.addArguments("--headless");
            // объявляю тестовый браузер
            driver = new EdgeDriver(options);
            // неявное ожидание
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        }

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemPage = new ItemPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        finishPage = new FinishPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDawn() {
        driver.quit();
    }
}
