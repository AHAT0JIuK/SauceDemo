package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private final By PAGE_TITLE = By.cssSelector(".title");
    private final By CANCEL_BUTTON = By.id("cancel");
    private final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/checkout-step-two.html");
    }

    public void cancelButtonClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public String getTitleCheckoutOverviewPage() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void goToCartPage() {
        driver.findElement(CART_BUTTON).click();
    }

    public void finishButtonClick() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
