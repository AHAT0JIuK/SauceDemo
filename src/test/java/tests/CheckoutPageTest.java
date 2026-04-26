package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutPageTest extends BaseTest {

    @Test
    public void checkContinueButtonAllInputsEmpty() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка появления информационного сообщения об обязательности заполнения поля First Name
        assertEquals(checkoutPage.getErrorMessage(), "Error: First Name is required");
    }

    @Test
    public void checkContinueButtonFirstNameFill() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // заполнение поля First Name
        checkoutPage.inputsFill("standard_user", "", "");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка появления информационного сообщения об обязательности заполнения поля First Name
        assertEquals(checkoutPage.getErrorMessage(), "Error: Last Name is required");
    }

    @Test
    public void checkContinueButtonFirstNameAndLastNameFill() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на кнопку перехода на страницу checkout
        cartPage.goToCheckoutPage();
        // проверка открытия страницы checkout
        assertEquals(checkoutPage.getTitleCheckoutPage(), "Checkout: Your Information");
        // заполнение полей First Name, Last Name
        checkoutPage.inputsFill("userFirstName", "userLastName", "");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка появления информационного сообщения об обязательности заполнения поля First Name
        assertEquals(checkoutPage.getErrorMessage(), "Error: Postal Code is required");
    }
}
