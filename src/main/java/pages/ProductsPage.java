package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private final By TITLE = By.cssSelector("[data-test=title]");
    private final By BURGER_BUTTON = By.id("react-burger-menu-btn");
    private final By LOGOUT_BUTTON = By.id("logout_sidebar_link");
    private final By CLOSE_SIDEBAR_BUTTON = By.id("react-burger-cross-btn");
    private final By ADD_TO_CART_BUTTON = By.id("add-to-cart-sauce-labs-backpack");
    private final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    private final By RED_CIRCLE_OF_NEAR_CART = By.cssSelector(".shopping_cart_badge");
    private final By CART_BUTTON = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory.html");
    }

    public String getTitle() {
        return driver.findElement(TITLE).getText();
    }

    public void openSidebar() {
        driver.findElement(BURGER_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_BUTTON));
    }

    public String getTitleLogoutButton() {
        return driver.findElement(LOGOUT_BUTTON).getText();
    }

    public void closeSidebar() {
        driver.findElement(CLOSE_SIDEBAR_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
    }

    public void addItemToCart() {
        driver.findElement(ADD_TO_CART_BUTTON).click();
    }

    public String getTitleRemoveButton() {
        return driver.findElement(REMOVE_BUTTON).getText();
    }

    public String getClassRemoveButton() {
        String buttonClass = driver.findElement(REMOVE_BUTTON).getAttribute("class");
        return buttonClass;
    }

    public String valueRedCircleOfNearCart() {
        return driver.findElement(RED_CIRCLE_OF_NEAR_CART).getText();
    }

    public void removeItemToCart() {
        driver.findElement(REMOVE_BUTTON).click();
    }

    public String getTitleAddToCartButton() {
        return driver.findElement(ADD_TO_CART_BUTTON).getText();
    }

    public String getClassAddToCartButton() {
        String buttonClass = driver.findElement(ADD_TO_CART_BUTTON).getAttribute("class");
        return buttonClass;
    }

    public boolean redCircleOfNearCartNotExist() {
        return driver.findElements(RED_CIRCLE_OF_NEAR_CART).isEmpty();
    }

    public void goToCartPage() {
        driver.findElement(CART_BUTTON).click();
    }

    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }
}
