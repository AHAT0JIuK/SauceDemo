package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {

    private final By ADD_TO_CART_BUTTON = By.id("add-to-cart");
    private final By REMOVE_BUTTON = By.id("remove");
    private final By RED_CIRCLE_OF_NEAR_CART = By.cssSelector(".shopping_cart_badge");
    private final By ITEM_LINK = By.id("item_4_title_link");
    private final By RETURN_BUTTON = By.id("back-to-products");

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory-item.html?id=4");
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

    public void goToItemPage() {
        driver.findElement(ITEM_LINK).click();
    }

    public String getTitleReturnButton() {
        return driver.findElement(RETURN_BUTTON).getText();
    }

    public void returnToProductsPage() {
        driver.findElement(RETURN_BUTTON).click();
    }
}
