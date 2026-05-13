package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class ProductsPageTest extends BaseTest {

    @Test(enabled = true,
            description = "Проверка открытия сайдбара на странице с продуктами",
            testName = "Проверка открытия сайдбара на странице с продуктами")
    @Description("Проверка открытия сайдбара на странице с продуктами")
    @Feature("Sidebar")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-003")
    @Issue("SCDM-002")
    @Owner("Светлов А.А.")
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
        softAssert.assertAll();
    }

    @Test(enabled = true,
            description = "Проверка закрытия сайдбара на странице с продуктами",
            testName = "Проверка закрытия сайдбара на странице с продуктами")
    @Description("Проверка закрытия сайдбара на странице с продуктами")
    @Feature("Sidebar")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-004")
    @Issue("SCDM-002")
    @Owner("Светлов А.А.")
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
        softAssert.assertAll();
    }

    @Test(enabled = true,
            description = "Проверка кнопки добавления продукта в тележку на странице с продуктами",
            testName = "Проверка кнопки добавления продукта в тележку на странице с продуктами")
    @Description("Проверка кнопки добавления продукта в тележку на странице с продуктами")
    @Feature("Add to cart Button")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-005")
    @Issue("SCDM-003")
    @Owner("Светлов А.А.")
    public void checkChangeAddToCartButton() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку добавления товара в тележку
        productsPage.addItemToCart("Sauce Labs Fleece Jacket");
        // проверяю, что кнопка Add To Cart сменилась на кнопку Remove
        softAssert.assertEquals(productsPage.getTitleRemoveButton("Sauce Labs Fleece Jacket"), "Remove");
        // проверяю, что кнопка красного цвета через присутствие у нее класса btn_secondary
        softAssert.assertTrue(productsPage.getClassRemoveButton("Sauce Labs Fleece Jacket").contains("btn_secondary"));
        // проверяю, что у иконки тележки появился красный кружок с единичкой
        softAssert.assertEquals(productsPage.valueRedCircleOfNearCart(), "1");
        // нажимаю на кнопку удаления товара из тележки
        productsPage.removeItemToCart("Sauce Labs Fleece Jacket");
        // проверяю, что кнопка Remove сменилась на кнопку Add To Cart
        softAssert.assertEquals(productsPage.getTitleAddToCartButton("Sauce Labs Fleece Jacket"), "Add to cart");
        // проверяю, что кнопка черного цвета через присутствие у нее класса btn_secondary
        softAssert.assertTrue(productsPage.getClassAddToCartButton("Sauce Labs Fleece Jacket").contains("btn_primary"));
        // проверяю, что у иконки тележки отсутствует красный кружок с единичкой
        softAssert.assertTrue(productsPage.redCircleOfNearCartNotExist());
        softAssert.assertAll();
    }
}
