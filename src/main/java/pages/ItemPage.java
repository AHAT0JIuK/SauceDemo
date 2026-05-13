package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage extends BasePage {

    private final By ADD_TO_CART_BUTTON = By.id("add-to-cart");
    private final By REMOVE_BUTTON = By.id("remove");
    private final By RED_CIRCLE_OF_NEAR_CART = By.cssSelector(".shopping_cart_badge");
    private final By RETURN_BUTTON = By.id("back-to-products");
    private final String ITEM_LINK_PATTERN =
            "//*[text()='%s']/ancestor::a";

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/inventory-item.html?id=4");
    }

    @Step("Добавление продукта в тележку")
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

    @Step("Переход на страницу продукта")
    public void goToItemPage(String product) {
        driver.findElement(By.xpath(String.format(ITEM_LINK_PATTERN, product))).click();
    }

    public String getTitleReturnButton() {
        return driver.findElement(RETURN_BUTTON).getText();
    }

    @Step("Переход на страницу с продуктами")
    public void returnToProductsPage() {
        driver.findElement(RETURN_BUTTON).click();
    }
}
