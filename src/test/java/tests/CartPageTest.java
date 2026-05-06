package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class CartPageTest extends BaseTest {

    @Test(enabled = true,
            description = "Проверка перехода на страницу тележки со страницы с продуктами",
            testName = "Проверка перехода на страницу тележки со страницы с продуктами")
    public void checkOpenCartPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы тележки на страницу с продуктами",
            testName = "Проверка перехода со страницы тележки на страницу с продуктами")
    public void checkReturnToProductsPageFromCartPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
        loginPage.open();
        // залогин c валидным логином и паролем
        loginPage.login("standard_user", "secret_sauce");
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
        // нажимаю на кнопку перехода на страницу тележки
        productsPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
        // нажимаю на ссылку перехода обратно на страницу c продуктами
        cartPage.returnToProductsPage();
        // проверка открытия страницы с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы тележки на страницу Checkout",
            testName = "Проверка перехода со страницы тележки на страницу Checkout")
    public void checkCheckoutButton() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы
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
    }
}
