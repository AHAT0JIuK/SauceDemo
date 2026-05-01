package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ItemPageTest extends BaseTest {

    @Test
    public void checkOpenItemPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на ссылку перехода на страницу продукта
        itemPage.goToItemPage();
        // проверка открытия страницы продукта
        softAssert.assertEquals(itemPage.getTitleReturnButton(), "Back to products");
    }

    @Test
    public void checkReturnToProductsPageFromItemPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на ссылку перехода на страницу продукта
        itemPage.goToItemPage();
        // проверка открытия страницы продукта
        softAssert.assertEquals(itemPage.getTitleReturnButton(), "Back to products");
        // нажимаю на ссылку перехода обратно на страницу c продуктами
        itemPage.returnToProductsPage();
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
    }

    @Test
    public void checkAddItemToCartFromItemPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на ссылку перехода на страницу продукта
        itemPage.goToItemPage();
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
    }
}
