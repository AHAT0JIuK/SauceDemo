package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

/*
Создать отдельный Java-класс с тестом, сценарий:
a. Залогиниться
b. Добавить товар в корзину
c. Перейти в корзину
d. Проверить (assertEquals) стоимость товара и его имя в корзине
*/

public class PriceAndNameTest extends BaseTest {

    @Test
    public void checkBasket() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // добавление товара в тележку
        productsPage.addItemToCart();
        // переход в тележку
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // проверка стоимости товара в тележке
        assertEquals(cartPage.getItemPrice(), "$29.99");
        // проверка наименования товара в тележке
        assertEquals(cartPage.getItemName(), "Sauce Labs Backpack");
    }
}
