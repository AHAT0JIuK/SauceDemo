package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class ItemPageTest extends BaseTest {

    @Test(enabled = true,
            description = "Проверка открытия страницы продукта",
            testName = "Проверка открытия страницы продукта")
    @Description("Проверка открытия страницы продукта")
    @Feature("Item Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-006")
    @Issue("SCDM-004")
    @Owner("Светлов А.А.")
    public void checkOpenItemPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на ссылку перехода на страницу продукта
        itemPage.goToItemPage("Sauce Labs Fleece Jacket");
        // проверка открытия страницы продукта
        softAssert.assertEquals(itemPage.getTitleReturnButton(), "Back to products");
        softAssert.assertAll();
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы продукта на страницу с продуктами",
            testName = "Проверка перехода со страницы продукта на страницу с продуктами")
    @Description("Проверка перехода со страницы продукта на страницу с продуктами")
    @Feature("Item Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-007")
    @Issue("SCDM-004")
    @Owner("Светлов А.А.")
    public void checkReturnToProductsPageFromItemPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на ссылку перехода на страницу продукта
        itemPage.goToItemPage("Sauce Labs Onesie");
        // проверка открытия страницы продукта
        softAssert.assertEquals(itemPage.getTitleReturnButton(), "Back to products");
        // нажимаю на ссылку перехода обратно на страницу c продуктами
        itemPage.returnToProductsPage();
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        softAssert.assertAll();
    }

    @Test(enabled = true,
            description = "Проверка добавления продукта в тележку со страницы продукта",
            testName = "Проверка добавления продукта в тележку со страницы продукта")
    @Description("Проверка добавления продукта в тележку со страницы продукта")
    @Feature("Item Page")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("QATASK-008")
    @Issue("SCDM-003")
    @Owner("Светлов А.А.")
    public void checkAddItemToCartFromItemPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на ссылку перехода на страницу продукта
        itemPage.goToItemPage("Sauce Labs Bike Light");
        // проверка открытия страницы продукта
        softAssert.assertEquals(itemPage.getTitleReturnButton(), "Back to products");
        // нажимаю на кнопку добавления продукта в тележку
        itemPage.addItemToCart();
        // проверяю, что кнопка Add To Cart сменилась на кнопку Remove
        softAssert.assertEquals(itemPage.getTitleRemoveButton(), "Remove");
        // проверяю, что кнопка красного цвета через присутствие у нее класса btn_secondary
        softAssert.assertTrue(itemPage.getClassRemoveButton().contains("btn_secondary"));
        // проверяю, что у иконки тележки появился красный кружок с единичкой
        softAssert.assertEquals(itemPage.valueRedCircleOfNearCart(), "1");
        softAssert.assertAll();
    }
}
