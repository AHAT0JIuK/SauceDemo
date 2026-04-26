package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CartPageTest extends BaseTest {

    @Test
    public void checkOpenCartPage() {
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        assertEquals(cartPage.getTitleCartPage(), "Your Cart");
    }

    @Test
    public void checkReturnToProductsPageFromCartPage() {
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на ссылку перехода обратно на страницу c продуктами
        cartPage.returnToProductsPage();
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkCheckoutButton() {
        // открытие страницы
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
    }
}
