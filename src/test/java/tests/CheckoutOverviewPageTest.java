package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.base.BaseTest;

public class CheckoutOverviewPageTest extends BaseTest {

    @Test(enabled = true,
            description = "Проверка перехода со страницы Checkout на страницу Checkout: Overview",
            testName = "Проверка перехода со страницы Checkout на страницу Checkout: Overview")
    public void checkOpenCheckoutOverviewPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
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
        // заполнение всех полей
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы Checkout: Overview на страницу с продуктами",
            testName = "Проверка перехода со страницы Checkout: Overview на страницу с продуктами")
    public void checkReturnToProductsPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
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
        // заполнение поля First Name
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку отмены
        checkoutOverviewPage.cancelButtonClick();
        // проверка возврата на страницу с продуктами
        softAssert.assertEquals(productsPage.getTitle(), "Products");
    }

    @Test(enabled = true,
            description = "Проверка перехода со страницы Checkout: Overview на страницу тележки",
            testName = "Проверка перехода со страницы Checkout: Overview на страницу тележки")
    public void checkReturnToCartPage() {
        SoftAssert softAssert = new SoftAssert();
        // открытие страницы залогина
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
        // заполнение поля First Name
        checkoutPage.inputsFill("userFirstName", "userLastName", "123456");
        // нажимаю на кнопку продолжить
        checkoutPage.continueButtonClick();
        // проверка открытия страницы checkout overview
        softAssert.assertEquals(checkoutOverviewPage.getTitleCheckoutOverviewPage(), "Checkout: Overview");
        // нажимаю на кнопку перехода на страницу тележки
        checkoutOverviewPage.goToCartPage();
        // проверка открытия страницы тележки
        softAssert.assertEquals(cartPage.getTitleCartPage(), "Your Cart");
    }
}
