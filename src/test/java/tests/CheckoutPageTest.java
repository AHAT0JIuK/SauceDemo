package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class CheckoutPageTest extends BaseTest {

    @DataProvider(name = "Тестовые данные заполнения формы Checkout: Your Information")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"standard_user", "", "", "Error: Last Name is required"},
                {"standard_user", "userLastName", "", "Error: Postal Code is required"}
        };
    }

    @Test(enabled = true,
            description = "Проверка заполнения формы Checkout: Your Information неполными данными",
            testName = "Проверка заполнения формы Checkout: Your Information неполными данными",
            dataProvider = "Тестовые данные заполнения формы Checkout: Your Information")
    @Description("Проверка заполнения формы Checkout: Your Information неполными данными")
    @Feature("Checkout: Your Information - Form")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("QATASK-015")
    @Issue("SCDM-007")
    @Owner("Светлов А.А.")
    public void checkLoginNegativeCred(String firstName, String lastName, String zipCode, String errorMessage) {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        softAssert.assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // заполнение полей First Name, Last Name
        checkoutPage.inputsFill(firstName, lastName, zipCode);
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка появления информационного сообщения об обязательности заполнения поля First Name
        softAssert.assertEquals(checkoutPage.getErrorMessage(), errorMessage);
        softAssert.assertAll();
    }
}
