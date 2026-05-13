package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private final By CART_PAGE_TITLE = By.cssSelector(".title");
    private final By CONTINUE_BUTTON = By.id("continue");
    private final By ERROR_MESSAGE = By.cssSelector(".error-message-container");
    private final By INPUT_FIRST_NAME = By.id("first-name");
    private final By INPUT_LAST_NAME = By.id("last-name");
    private final By INPUT_ZIP_CODE = By.id("postal-code");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL + "/checkout-step-one.html");
    }

    @Step("Переход на последнюю страницу оформления заказа")
    public void continueButtonClick() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getTitleCheckoutPage() {
        return driver.findElement(CART_PAGE_TITLE).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Оформление заказа с именем - '{firstName}', фамилией - '{lastName}' и почтовым индексом - '{zipCode}'")
    public void inputsFill(String firstName, String lastName, String zipCode) {
        driver.findElement(INPUT_FIRST_NAME).sendKeys(firstName);
        driver.findElement(INPUT_LAST_NAME).sendKeys(lastName);
        driver.findElement(INPUT_ZIP_CODE).sendKeys(zipCode);
    }
}
