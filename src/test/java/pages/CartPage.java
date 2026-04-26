package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    private final By RETURN_BUTTON = By.id("continue-shopping");
    private final By CART_PAGE_TITLE = By.cssSelector(".title");
    private final By CHECKOUT_BUTTON = By.id("checkout");
    private final By ITEM_PRICE = By.className("inventory_item_price");
    private final By ITEM_NAME = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/cart.html");
    }

    public void goToCheckoutPage() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void returnToProductsPage() {
        driver.findElement(RETURN_BUTTON).click();
    }

    public String getTitleCartPage() {
        return driver.findElement(CART_PAGE_TITLE).getText();
    }

    public String getItemPrice() {
        String priceInsideClass = driver.findElement(ITEM_PRICE).getText();
        String price = priceInsideClass.trim(); // убираю из полученного текста разделитель в виде переноса на новую строку
        return price;
    }

    public String getItemName() {
        String nameInsideClass = driver.findElement(By.className("inventory_item_name")).getText();
        return nameInsideClass;
    }

}
