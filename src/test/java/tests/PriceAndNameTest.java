package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

/*
Создать отдельный Java-класс с тестом, сценарий:
a. Залогиниться
b. Добавить товар в корзину
c. Перейти в корзину
d. Проверить (assertEquals) стоимость товара и его имя в корзине
*/

public class PriceAndNameTest extends BaseTest {

    @Test(enabled = false,
            description = "E2E тест: залогин, добавление товара в тележку, переход в тележку",
            testName = "Практика нахождения вэб-элементов по разным локаторам")
    public void checkCart() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // добавление товара в тележку
        productsPage.addItemToCart();
        // переход в тележку
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // проверка стоимости товара в тележке
        softAssert.assertEquals(cartPage.getItemPrice(), "$29.99");
        // проверка наименования товара в тележке
        softAssert.assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
    }
}
