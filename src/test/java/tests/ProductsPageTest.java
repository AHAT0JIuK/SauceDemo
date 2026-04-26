package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductsPageTest extends BaseTest {

    @Test
    public void checkOpenSidebar() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // вызов сайдбара
        productsPage.openSidebar();
        // проверка открытия сайдбара
        softAssert.assertEquals(productsPage.getTitleLogoutButton(), "Logout");
    }

    @Test
    public void checkCloseSidebar() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // вызов сайдбара
        productsPage.openSidebar();
        // проверка открытия сайдбара
        softAssert.assertEquals(productsPage.getTitleLogoutButton(), "Logout");
        // закрытие сайдбара
        productsPage.closeSidebar();
        // проверка закрытия сайдбара
        softAssert.assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkChangeAddToCartButton() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку добавления товара в тележку
        productsPage.addItemToCart();
        // проверяю, что кнопка Add To Cart сменилась на кнопку Remove
        softAssert.assertEquals(productsPage.getTitleRemoveButton(), "Remove");
        // проверяю, что кнопка красного цвета через присутствие у нее класса btn_secondary
        softAssert.assertTrue(productsPage.getClassRemoveButton().contains("btn_secondary"));
        // проверяю, что у иконки тележки появился красный кружок с единичкой
        softAssert.assertEquals(productsPage.valueRedCircleOfNearCart(), "1");
        // нажимаю на кнопку удаления товара из тележки
        productsPage.removeItemToCart();
        // проверяю, что кнопка Remove сменилась на кнопку Add To Cart
        softAssert.assertEquals(productsPage.getTitleAddToCartButton(), "Add to cart");
        // проверяю, что кнопка черного цвета через присутствие у нее класса btn_secondary
        softAssert.assertTrue(productsPage.getClassAddToCartButton().contains("btn_primary"));
        // проверяю, что у иконки тележки отсутствует красный кружок с единичкой
        softAssert.assertTrue(productsPage.redCircleOfNearCartNotExist());
    }
}
