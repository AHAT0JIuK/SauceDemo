package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class ProductsPageTest extends BaseTest {

    @Test
    public void checkOpenSidebar() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // вызов сайдбара
        productsPage.openSidebar();
        // проверка открытия сайдбара
        assertEquals(productsPage.getTitleLogoutButton(), "Logout");
    }

    @Test
    public void checkCloseSidebar() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // вызов сайдбара
        productsPage.openSidebar();
        // проверка открытия сайдбара
        assertEquals(productsPage.getTitleLogoutButton(), "Logout");
        // закрытие сайдбара
        productsPage.closeSidebar();
        // проверка закрытия сайдбара
        assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkChangeAddToCartButton() {
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку добавления товара в тележку
        productsPage.addItemToCart();
        // проверяю, что кнопка Add To Cart сменилась на кнопку Remove
        assertEquals(productsPage.getTitleRemoveButton(), "Remove");
        // проверяю, что кнопка красного цвета через присутствие у нее класса btn_secondary
        assertTrue(productsPage.getClassRemoveButton().contains("btn_secondary"));
        // проверяю, что у иконки тележки появился красный кружок с единичкой
        assertEquals(productsPage.valueRedCircleOfNearCart(), "1");
        // нажимаю на кнопку удаления товара из тележки
        productsPage.removeItemToCart();
        // проверяю, что кнопка Remove сменилась на кнопку Add To Cart
        assertEquals(productsPage.getTitleAddToCartButton(), "Add to cart");
        // проверяю, что кнопка черного цвета через присутствие у нее класса btn_secondary
        assertTrue(productsPage.getClassAddToCartButton().contains("btn_primary"));
        // проверяю, что у иконки тележки отсутствует красный кружок с единичкой
        assertTrue(productsPage.redCircleOfNearCartNotExist());
    }
}
