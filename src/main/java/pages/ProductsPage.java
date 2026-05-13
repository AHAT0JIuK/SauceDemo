package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By BURGER_BUTTON = By.id("react-burger-menu-btn");
    private final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private final By CLOSE_SIDEBAR_BUTTON = By.id("react-burger-cross-btn");
    private final By RED_CIRCLE_OF_NEAR_CART = By.cssSelector(".shopping_cart_badge");
    private final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final String ADD_TO_CART_BUTTON_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
    private final String REMOVE_BUTTON_PATTERN =
            "//*[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Remove']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    @Step("Открытие сайдбара на странице с продуктами")
    public void openSidebar() {
        driver.findElement(BURGER_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
    }

    public String getTitleLogoutButton() {
        return driver.findElement(LOGOUT_BUTTON).getText();
    }

    @Step("Закрытие сайдбара на странице с продуктами")
    public void closeSidebar() {
        driver.findElement(CLOSE_SIDEBAR_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    @Step("Добавление продукта в тележку")
    public void addItemToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_PATTERN, product))).click();
    }

    public String getTitleRemoveButton(String product) {
        return driver.findElement(By.xpath(String.format(REMOVE_BUTTON_PATTERN, product))).getText();
    }

    public String getClassRemoveButton(String product) {
        String buttonClass = driver.findElement(By.xpath(String.format(REMOVE_BUTTON_PATTERN, product))).getAttribute("class");
        return buttonClass;
    }

    public String valueRedCircleOfNearCart() {
        return driver.findElement(RED_CIRCLE_OF_NEAR_CART).getText();
    }

    @Step("Удаление продукта из тележки")
    public void removeItemToCart(String product) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON_PATTERN, product))).click();
    }

    public String getTitleAddToCartButton(String product) {
        return driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_PATTERN, product))).getText();
    }

    public String getClassAddToCartButton(String product) {
        String buttonClass = driver.findElement(By.xpath(String.format(ADD_TO_CART_BUTTON_PATTERN, product))).getAttribute("class");
        return buttonClass;
    }

    public boolean redCircleOfNearCartNotExist() {
        return driver.findElements(RED_CIRCLE_OF_NEAR_CART).isEmpty();
    }

    @Step("Переход на страницу тележки")
    public void goToCartPage() {
        driver.findElement(CART_BUTTON).click();
    }

    @Step("Разлогин")
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
