package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CartPageTest extends BaseTest {

    @Test
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

    @Test
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

    @Test
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
