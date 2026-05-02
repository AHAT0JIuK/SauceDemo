package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinishPage extends BasePage {

    private final By PAGE_TITLE = By.cssSelector(".title");
    private final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final By BACK_HOME_BUTTON = By.id("back-to-products");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/checkout-complete.html");
    }

    public String getTitleFinishPage() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void backHomeButtonClick() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    public void goToCartPage() {
        driver.findElement(CART_BUTTON).click();
    }
}
